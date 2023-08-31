package com.developer.colorblast.minio;
import io.minio.*;
import io.minio.errors.MinioException;
import io.minio.GetPresignedObjectUrlArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
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

    @PostMapping("/upload-pdf")
    public ResponseEntity<String> uploadPDF(@RequestParam("file") MultipartFile file) {
        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(file.getOriginalFilename())
                            .contentType("application/pdf")
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .build()
            );

            String message = "Fichier PDF ajouté avec succès : " + file.getOriginalFilename();
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

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String contentType = file.getContentType();
            if (contentType == null || (!contentType.equals(MediaType.IMAGE_JPEG_VALUE) && !contentType.equals(MediaType.IMAGE_PNG_VALUE))) {
                return new ResponseEntity<>("Le fichier doit être au format JPEG ou PNG.", HttpStatus.BAD_REQUEST);
            }

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(file.getOriginalFilename())
                            .contentType(contentType)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .build()
            );

            String message = "Image ajoutée avec succès : " + file.getOriginalFilename();
            return new ResponseEntity<>(message, HttpStatus.OK);
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
