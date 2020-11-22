package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.response.FileDBListResponse;
import com.example.demo.response.FileDBResponse;
import com.example.demo.service.FileStorageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:8081")
@RequestMapping("/files")
public class FileController {

    private final FileStorageService fileStorageService;

    @PostMapping()
    public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        String fileId = fileStorageService.store(file);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{fileId}")
                .buildAndExpand(fileId)
                .toUri())
                .build();
    }
    
    @GetMapping()
    public ResponseEntity<List<FileDBListResponse>> listFiles() {
        
        List<FileDBListResponse> files = fileStorageService.listFiles();
        
        return ResponseEntity.ok(files);
    }
    
    @GetMapping("/{fileId}")
    public ResponseEntity<byte[]> getFile(@PathVariable String fileId) throws Exception {
        
        FileDBResponse file = fileStorageService.getFile(fileId);
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"".concat(file.getName().concat("\"")))
                .body(file.getData());
    }
    
    
}
