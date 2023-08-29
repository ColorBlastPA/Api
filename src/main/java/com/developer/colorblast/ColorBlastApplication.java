package com.developer.colorblast;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootApplication
public class ColorBlastApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColorBlastApplication.class, args);

	}
}