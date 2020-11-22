package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileDBEntity;
import com.example.demo.response.FileDBListResponse;
import com.example.demo.response.FileDBResponse;
import com.example.repository.FileDBRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileStorageService {

    private final FileDBRepository fileDBRepository;

    public String store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        FileDBEntity fileDBEntity = FileDBEntity.builder()
                .name(fileName)
                .type(file.getContentType())
                .data(file.getBytes())
                .build();

        return fileDBRepository.save(fileDBEntity).getId();
    }

    public FileDBResponse getFile(String id) throws Exception {
        return fileDBRepository.findById(id)
                .map(FileDBEntity::toResponse)
                .orElseThrow(Exception::new);
    }

    public List<FileDBListResponse> listFiles() {
        return fileDBRepository.findAll().stream()
                .map(FileDBEntity::toListResponse)
                .collect(Collectors.toList());
    }
    
    



}
