package com.wechat.controller;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author: Youchang Xu
 * @Description:
 * @Date: created in 22:43 2018/7/5
 * @Modified By:
 */
public class UploadService {

    /**
     * 上传文件
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public  void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
