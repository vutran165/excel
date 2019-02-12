package com.java.excel.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    
    ResponseMetadata save(MultipartFile MultipartFile) throws IOException;

    byte[] getDocumentFile(Long id);
}