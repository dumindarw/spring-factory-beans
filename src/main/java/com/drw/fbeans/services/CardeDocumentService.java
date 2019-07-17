package com.drw.fbeans.services;


import com.drw.fbeans.registry.DocumentAdapterService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("Cadre")
public class CardeDocumentService implements DocumentAdapterService<MultipartFile> {


    @Override
    public String upload(MultipartFile  request) {

        //Save in Disk
        //Save in DB

        return "CadreDoc";

    }


    @Override
    public String download(String name) {
        return null;
    }
}
