package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDBResponse {
    
    private String id;
    private String name;
    private String type;
    private String url;
    private byte[] data;

}
