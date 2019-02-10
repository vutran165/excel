package com.java.excel;

import java.io.InputStream;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@RestController
@RequestMapping(value = "/api")
// @MultipartConfig(fileSizeThreshold=1024*1024*10, // 10 MB
// maxFileSize=1024*1024*50, // 50 MB
// maxRequestSize=1024*1024*100)
public class RestApiController {

    @PostMapping("/singleFile")
    @ResponseBody
    public ResponseEntity<String> singleFile(HttpServletRequest req, HttpServletResponse res) {
        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
        // HttpHeaders httpHeadersRes = new HttpHeaders();
        try {
            List<FileItem> fileItems = fileUpload.parseRequest(req);
            InputStream inputStream = fileItems.get(0).getInputStream();
            // MultipartHttpServletRequest multipartreq = new
            // DefaultMultipartHttpServletRequest(req);
            // Iterator<String> iterator = multipartreq.getFileNames();
            // while (iterator.hasNext()) {
            // MultipartFile multipartFile = multipartreq.getFile(iterator.next());
            // String fileName = multipartFile.getOriginalFilename();
            // System.out.println(fileName);
            // }

            return new ResponseEntity<String>("done", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}