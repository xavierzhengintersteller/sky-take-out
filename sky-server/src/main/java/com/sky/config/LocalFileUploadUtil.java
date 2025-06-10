package com.sky.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
@Slf4j
public class LocalFileUploadUtil {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public String upload(byte[] fileBytes, String fileName) throws IOException {
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File targetFile = new File(directory, fileName);
        try (FileOutputStream fos = new FileOutputStream(targetFile)) {
            fos.write(fileBytes);
        }

        // 返回文件路径或URL（如前端通过Nginx访问，则返回URL）
        return "/uploads/" + fileName;
    }
}
