package com.drw.fbeans.controllers;

import com.drw.fbeans.registry.DocumentServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/doc")
public class DocumentController {

    @Autowired
    DocumentServiceRegistry documentServiceRegistry;


    @GetMapping(value="/upload/{docName}")
    public ResponseEntity<String> uploadDocument(@PathVariable("docName") String docName, @RequestParam("file") MultipartFile file){


        String response = documentServiceRegistry.getService(docName).upload(file);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value="/download/{docName}")
    public ResponseEntity<String> downloadDocument(@PathVariable("docName") String docName){

        //file to ArrayList<T> then upload(ArrayList<T>)?

        String response = documentServiceRegistry.getService(docName).download(docName);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
