package com.drw.fbeans.services;


import com.drw.fbeans.registry.DocumentAdapterService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("Salary")
public class SalaryDocumentService implements DocumentAdapterService<MultipartFile> {

    @Override
    public String upload(MultipartFile request) {

        return "SalaryDoc";

    }

    @Override
    public String download(String name) {
        return null;
    }
}
