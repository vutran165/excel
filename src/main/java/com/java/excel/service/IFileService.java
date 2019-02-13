package com.java.excel.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    
    ResponseMetadata save(List<MultipartFile> multipartFile) throws IOException;

    byte[] getDocumentFile(Long id);
}