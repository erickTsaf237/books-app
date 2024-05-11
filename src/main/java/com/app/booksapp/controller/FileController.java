package com.app.booksapp.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/files")
public class FileController {

    //@GetMapping("/{filename}")
    public StreamingResponseBody getFile(@PathVariable String filename) throws IOException {
        Resource resource = new ClassPathResource("static/" + filename);
        InputStream inputStream = resource.getInputStream();

        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                outputStream.write(data, 0, nRead);
            }
            inputStream.close();
        };
    }

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) throws IOException {
        // Specify the directory where your files are stored
        String directory = "src/main/resources/static/";
        Path file = Paths.get(directory, filename);
        Resource resource = new org.springframework.core.io.UrlResource(file.toUri());

        // Determine the appropriate content type dynamically or based on file extension
        String contentType = "application/octet-stream"; // Set a default content type
        if (Files.probeContentType(file) != null) {
            contentType = Files.probeContentType(file);
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}