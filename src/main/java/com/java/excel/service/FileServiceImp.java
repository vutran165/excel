package com.java.excel.service;

import java.io.IOException;
import java.util.List;

import com.java.excel.dao.FileRepository;
import com.java.excel.dao.IFileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImp implements IFileService {

    @Autowired
    private IFileRepository iFileRepository;

    @Override
    public ResponseMetadata save(List<MultipartFile> multipartFile) throws IOException {
        List<FileRepository> files;
       for(MultipartFile mFile: multipartFile)
       {
           FileRepository file = new FileRepository();
           file.setFilename(mFile.getOriginalFilename());
           file.setFile(mFile.getBytes());
           iFileRepository.save(file);
       }

       

        ResponseMetadata metadata = new ResponseMetadata();
        metadata.setMessage("success");
        metadata.setStatus(200);
        return null;
    }

    @Override
    public byte[] getDocumentFile(Long id) {
        return null;
    }

}