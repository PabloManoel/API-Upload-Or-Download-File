package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.response.FileDBListResponse;
import com.example.demo.response.FileDBResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "files")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDBEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    String name;
    String type;

    @Lob
    private byte[] data;

    public FileDBListResponse toListResponse() {

        String url = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{fileId}")
        .buildAndExpand(id)
        .toUriString();
        
        return FileDBListResponse.builder()
                .id(id)
                .url(url)
                .name(name)
                .type(type)
                .size(data.length)
                .build();
    }
    
    public FileDBResponse toResponse() {
        
        return FileDBResponse.builder()
                .id(id)
                .name(name)
                .type(type)
                .data(data)
                .build();
    }
}