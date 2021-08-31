package com.crledu.auto.material.bigdata.repository.impl;

import com.alibaba.fastjson.JSON;
import com.crledu.auto.material.bigdata.biz.domain.BigdataDomain;
import com.crledu.auto.material.bigdata.biz.repository.BaseBigdataDomianRepository;
import com.crledu.auto.util.file.ZipUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.zip.ZipOutputStream;

/**
 ************************************************************
 * @Description: 深度学习数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/18 17:05
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class BigdataDomianRepositoryImpl implements BaseBigdataDomianRepository {

    @Value("${crledu.auto.file.server}")
    private String baseUrl;

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    private final String BIGDATA_FILE_PATH = "bigdata";
    private final String ZIP_DEFAULT_NAME = "data";

    @Override
    public BigdataDomain createWithData(Long id) {
        return null;
    }

    @Override
    public BigdataDomain saveInData(BigdataDomain domain) {
        Long pathLong = domain.getImportId();
        String path = basePath + File.separator+ BIGDATA_FILE_PATH + File.separator + pathLong.toString();
        File pathFile = new File(path);
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
        Long name = new Long(System.currentTimeMillis());
        File dataFile = new File(path + File.separator + name.toString() + ".json");
        if(!dataFile.exists()){
            BufferedWriter bw = null;
            try{
                bw = new BufferedWriter(new FileWriter(dataFile));
                bw.write(JSON.toJSONString(domain.getData()));
                bw.flush();
                bw.close();
                domain.save(path + File.separator + name.toString() + ".json");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return domain;
    }

    @Override
    public BigdataDomain updateToData(BigdataDomain domain) {
        return null;
    }

    @Override
    public Boolean deleteFromData(Long id) {
        return null;
    }

    @Override
    public File getGetDataPackage(Long id) {
        String path = basePath + File.separator+ BIGDATA_FILE_PATH + File.separator + id.toString();
        String zipPath = basePath + File.separator+ BIGDATA_FILE_PATH;
        File filePath = new File(path);
        if(filePath.exists()){
            //文件夹存在 看看压缩文件在不在
            String zipName = zipPath + File.separator + ZIP_DEFAULT_NAME+"_"+id.toString()+".zip";
            File file = new File(zipName);
            if(file.exists()){
                return file;
            }else{
                try{
                    OutputStream os = new FileOutputStream(file);
                    ZipUtils.toZip(path,os,true);
                    return file;
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public long getDataFileSize() {
        return FileUtils.sizeOfDirectory(new File(basePath + File.separator+ BIGDATA_FILE_PATH));
    }
}
