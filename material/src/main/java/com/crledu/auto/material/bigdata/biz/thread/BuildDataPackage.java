package com.crledu.auto.material.bigdata.biz.thread;

import com.crledu.auto.util.file.ZipUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class BuildDataPackage extends Thread{

    private final String BIGDATA_FILE_PATH = "bigdata";
    private final String ZIP_DEFAULT_NAME = "data";

    private Long importId;

    private String basePath;

    public BuildDataPackage(Long importId,String basePath) {
        this.importId = importId;
        this.basePath = basePath;
    }

    @Override
    public void run(){
        String path = basePath + File.separator+ BIGDATA_FILE_PATH + File.separator + importId.toString();
        String zipPath = basePath + File.separator+ BIGDATA_FILE_PATH;
        File filePath = new File(path);
        if(filePath.exists()){
            //文件夹存在 看看压缩文件在不在
            String zipName = zipPath + File.separator + ZIP_DEFAULT_NAME+"_"+importId.toString()+".zip";
            File file = new File(zipName);
            if(file.exists()){
                return;
            }else{
                try{
                    OutputStream os = new FileOutputStream(file);
                    ZipUtils.toZip(path,os,true);
                    return;
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
