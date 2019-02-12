package com.java.excel.dao;

import com.java.excel.service.ResponseMetadata;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "file", path = "file")
public interface IFileRepository extends CrudRepository<FileRepository, String> {


}