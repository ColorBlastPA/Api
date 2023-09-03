package com.developer.colorblast.minio;
import com.developer.colorblast.certificates.entity.CertificateEntity;
import com.developer.colorblast.certificates.service.CertificateService;
import com.developer.colorblast.client.entity.ClientEntity;
import com.developer.colorblast.client.service.ClientService;
import com.developer.colorblast.pro.entity.ProfessionnelEntity;
import com.developer.colorblast.pro.service.ProfessionnelService;
import com.developer.colorblast.product.entity.ProductEntity;
import com.developer.colorblast.product.service.ProductService;
import io.minio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MinioController {

    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucket.name}")
    private String bucketName;

    @Value("${minio.endpoint}")
    private String minioEndpoint;

    private final CertificateService certificateService;

    private final ProfessionnelService professionnelService;

    private final ClientService clientService;

    private final ProductService productService;

    public MinioController(CertificateService certificateService, ProfessionnelService professionnelService, ClientService clientService, ProductService productService) {
        this.certificateService = certificateService;
        this.professionnelService = professionnelService;
        this.clientService = clientService;
        this.productService = productService;
    }

    @PostMapping("/upload-pdf/{idPro}")
    public ResponseEntity<String> uploadPDF(@RequestParam("file") MultipartFile file,@PathVariable Long idPro) {
        UUID randomIdKey = UUID.randomUUID();

        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(randomIdKey.toString())
                            .contentType("application/pdf")
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .build()
            );

            String message = "Fichier PDF ajouté avec succès : " + randomIdKey.toString();

            Optional<ProfessionnelEntity> pro = professionnelService.findById(idPro);
            if(pro.isPresent()){
                CertificateEntity certificate = new CertificateEntity(randomIdKey.toString(),idPro,file.getOriginalFilename(),getUrl(randomIdKey.toString()));
                CertificateEntity NewCertificate = certificateService.createCertificate(certificate);
                pro.get().setIdCertificate(NewCertificate.getId());
                professionnelService.updateProfessionnel(pro.get());
            }else{
                return new ResponseEntity<>("Professionnel inexistant", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Une erreur est survenue lors de l'ajout du fichier PDF.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/download-pdf/{filename}")
    public ResponseEntity<InputStreamResource> downloadPDF(@PathVariable String filename) {
        try {
            Optional<InputStream> inputStreamOptional = getInputStreamFromMinio(filename);

            if (inputStreamOptional.isPresent()) {
                InputStream inputStream = inputStreamOptional.get();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_PDF);
                headers.setContentDispositionFormData("attachment", filename);

                return new ResponseEntity<>(new InputStreamResource(inputStream), headers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Optional<InputStream> getInputStreamFromMinio(String filename) {
        try {
            return Optional.ofNullable(minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(filename)
                            .build()
            ));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @GetMapping("/get-file-url/{filename}")
    public ResponseEntity<String> getFileUrl(@PathVariable String filename) {
        String fileUrl = minioEndpoint + bucketName + "/" + filename;
        return new ResponseEntity<>(fileUrl, HttpStatus.OK);
    }

    private String getUrl(String key){
        return minioEndpoint + bucketName + "/" + key;
    }

    @PostMapping("/setAvatarClient/{idClient}")
    public ResponseEntity<Object> setAvatarClient(@RequestParam("file") MultipartFile file, @PathVariable Long idClient) {
        UUID randomIdKey = UUID.randomUUID();

        try {
            String contentType = file.getContentType();
            if (contentType == null || (!contentType.equals(MediaType.IMAGE_JPEG_VALUE) &&
                    !contentType.equals(MediaType.IMAGE_PNG_VALUE) &&
                    !contentType.equals("image/jpeg") &&
                    !contentType.equals("image/jpg"))) {
                return new ResponseEntity<>("Le fichier doit être au format JPEG ou PNG.", HttpStatus.BAD_REQUEST);
            }


            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(randomIdKey.toString())
                            .contentType(contentType)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .build()
            );

            Optional<ClientEntity> clientOptional = clientService.findById(idClient);
            if (clientOptional.isPresent()) {
                ClientEntity client = clientOptional.get();
                client.setAvatar(getUrl(randomIdKey.toString()));
                clientService.updateClient(client);
                return new ResponseEntity<>(client, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Client non trouvé avec l'ID spécifié.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Une erreur est survenue lors de l'ajout de l'image.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/setImageProduct/{idProduct}")
    public ResponseEntity<Object> setImageProduct(@RequestParam("file") MultipartFile file, @PathVariable Long idProduct) {
        UUID randomIdKey = UUID.randomUUID();

        try {
            String contentType = file.getContentType();
            if (contentType == null || (!contentType.equals(MediaType.IMAGE_JPEG_VALUE) && !contentType.equals(MediaType.IMAGE_PNG_VALUE))) {
                return new ResponseEntity<>("Le fichier doit être au format JPEG ou PNG.", HttpStatus.BAD_REQUEST);
            }

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(randomIdKey.toString())
                            .contentType(contentType)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .build()
            );

            Optional<ProductEntity> productOptional = productService.findById(idProduct);
            if (productOptional.isPresent()) {
                ProductEntity product = productOptional.get();
                product.setImage(getUrl(randomIdKey.toString()));
                productService.updateProduct(product);
                return new ResponseEntity<>(product, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Produit non trouvé avec l'ID spécifié.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Une erreur est survenue lors de l'ajout de l'image.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/setAvatarPro/{idPro}")
    public ResponseEntity<Object> setAvatarPro(@RequestParam("file") MultipartFile file, @PathVariable Long idPro) {
        UUID randomIdKey = UUID.randomUUID();

        try {
            String contentType = file.getContentType();
            if (contentType == null || (!contentType.equals(MediaType.IMAGE_JPEG_VALUE) && !contentType.equals(MediaType.IMAGE_PNG_VALUE))) {
                return new ResponseEntity<>("Le fichier doit être au format JPEG ou PNG.", HttpStatus.BAD_REQUEST);
            }

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(randomIdKey.toString())
                            .contentType(contentType)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .build()
            );

            Optional<ProfessionnelEntity> professionnelOptional = professionnelService.findById(idPro);
            if (professionnelOptional.isPresent()) {
                ProfessionnelEntity professionnel = professionnelOptional.get();
                professionnel.setAvatar(getUrl(randomIdKey.toString()));
                professionnelService.updateProfessionnel(professionnel);
                return new ResponseEntity<>(professionnel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Professionnel non trouvé avec l'ID spécifié.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Une erreur est survenue lors de l'ajout de l'image.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/download-image/{filename}")
    public ResponseEntity<InputStreamResource> downloadImage(@PathVariable String filename) {
        try {
            Optional<InputStream> inputStreamOptional = getInputStreamFromMinio(filename);

            if (inputStreamOptional.isPresent()) {
                InputStream inputStream = inputStreamOptional.get();
                HttpHeaders headers = new HttpHeaders();
                String contentType = getContentTypeForImage(filename);
                headers.setContentType(MediaType.parseMediaType(contentType));
                headers.setContentDispositionFormData("attachment", filename);

                return new ResponseEntity<>(new InputStreamResource(inputStream), headers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String getContentTypeForImage(String filename) {
        if (filename.toLowerCase().endsWith(".jpg") || filename.toLowerCase().endsWith(".jpeg")) {
            return MediaType.IMAGE_JPEG_VALUE;
        } else if (filename.toLowerCase().endsWith(".png")) {
            return MediaType.IMAGE_PNG_VALUE;
        } else {
            return MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
    }
}
