package org.lshw.server.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lshw.server.info.Client;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LSHWService {
    
    private static final Logger LOGGER = Logger.getLogger(LSHWService.class.getName());
    private static final File ROOT_PATH;
    
    static {
        ROOT_PATH = new File(System.getProperty("user.dir"), "reports");
        if (! ROOT_PATH.exists()) {
            ROOT_PATH.mkdir();
        }        
        LOGGER.log(Level.INFO, "ROOT_PATH: {0}", ROOT_PATH);
    }
    
    public void saveReport(Client infoClient, MultipartFile reportFile) {
        try {
            InputStream input = reportFile.getInputStream();
            String ip = infoClient.address().trim();
            File file = new File(ROOT_PATH, ip);
            
            if (! file.exists()) {
                file.mkdir();
            }
        
            File report = new File(file, makeName(ip));
            try (OutputStream output = new FileOutputStream(report)) {
                byte[] buff = new byte[1024];
                int position;
                while ((position = input.read(buff)) != -1) {
                    output.write(buff, 0, position);
                }
            }
            
            LOGGER.log(Level.INFO, "Saved report: {0}", report);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
    
    private static String makeName(String address) {
        return System.currentTimeMillis() + "_" + address + ".txt"; 
    }
}
