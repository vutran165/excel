package com.java.excel.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.excel.dao.IFileRepository;
import com.java.excel.service.IFileService;
import com.java.excel.service.ResponseMetadata;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@RestController
@RequestMapping(value = "/api")
public class RestApiController {

    private String fileLocation;

    

    @Autowired
    IFileService iFileService;

    @PostMapping("/singleFile")
    @ResponseBody
    public String singleFile(HttpServletRequest req) {
        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());

        // MultipartRequest multipartRequest = new MultipartRequest();
        try {
            // for(MultipartFile file: files){
            // if(file.isEmpty()){
            // continue;
            // }

            // byte[] bytes = file.getBytes();
            // String fileName = file.getOriginalFilename();
            // System.out.println(fileName);
            // }
            MultipartHttpServletRequest multipartreq = new DefaultMultipartHttpServletRequest(req);
            List<FileItem> fileItems = fileUpload.parseRequest(req);
            for (FileItem item : fileItems) {
                System.out.println(item.getName());
            }
            InputStream inputStream = fileItems.get(0).getInputStream();

            // MultipartHttpServletRequest multipartreq = (MultipartHttpServletRequest) req;
            MultipartFile multipartFiletest = multipartreq.getFile("log (1).csv");
            // List<MultipartFile> multipartFile = multipartreq.getFiles("files");
            Iterator<String> iterator = multipartreq.getFileNames();
            while (iterator.hasNext()) {
                MultipartFile multipartFile = multipartreq.getFile(iterator.next());
                String fileName = multipartFile.getOriginalFilename();
                System.out.println(fileName);
            }
            return "done";
            // return new ResponseEntity<String>("done", HttpStatus.OK);
        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            return e.getMessage();
            // return new ResponseEntity<String>(e.getMessage(),
            // HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/uploadExcelFile")
    public String uploadFile(Model model, MultipartFile file) {
        try {
            InputStream in = file.getInputStream();
            File currDir = new File(".");
            String path = currDir.getAbsolutePath();
            fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
            FileOutputStream f = new FileOutputStream(fileLocation);
            int ch = 0;
            while ((ch = in.read()) != -1) {
                f.write(ch);
            }
            f.flush();
            f.close();
            model.addAttribute("message", "File: " + file.getOriginalFilename() + " has been uploaded successfully!");
            return "excel";
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            return e.getMessage();
        }

    }

    @PostMapping("/upload")
    public @ResponseBody ResponseMetadata handleFileUpload(@RequestParam(value = "files") List<MultipartFile> multipartFile)
            throws IOException {
                
        return iFileService.save(multipartFile);
    }
}