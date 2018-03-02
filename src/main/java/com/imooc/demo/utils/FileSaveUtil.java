package com.imooc.demo.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSaveUtil {

    public static String saveFile(MultipartFile file, String path, String name){
        File pFile = new File(path);
        if(!pFile.exists()){
            pFile.mkdirs();
        }
        File saveFile = new File(pFile, name);
        BufferedOutputStream bos = null;
        try{
            bos = new BufferedOutputStream(new FileOutputStream(saveFile.getAbsolutePath()));
            bos.write(file.getBytes());
            bos.flush();
            bos.close();
            return saveFile.getAbsolutePath();
        }catch (Exception e){
            throw new RuntimeException("文件保存失败");
        }
    }
}
