package org.lshw.server.controller;

import org.lshw.server.info.Client;
import org.lshw.server.service.LSHWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/lshw")
public class LSHWController {    
    @Autowired
    private LSHWService lshws;
    
    @PostMapping
    public void makeReport(
        @RequestPart("client") Client request,
        @RequestPart("report") MultipartFile file
    ) {
        lshws.saveReport(request, file);
    }
}
