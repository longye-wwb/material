package com.crledu.auto.material.system.repository.impl;

import com.crledu.auto.system.dto.SavedFileInfo;
import com.crledu.auto.system.repository.BaseSystemFileRepository;
import com.crledu.auto.util.file.FileUtils;
import com.crledu.auto.web.exception.RestRuntimeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Repository
public class DiskFileSystemRepository implements BaseSystemFileRepository {

    @Value("${crledu.auto.file.server}")
    private String baseUrl;

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Override
    public SavedFileInfo save(File file,SavedFileInfo savedFileInfo) {
        try{
            FileUtils.copyFile(file,savedFileInfo.getPath());
        }catch (FileNotFoundException e){
            throw new RestRuntimeException("原文件未找到！"+e.getMessage(),"10002");
        }catch (IOException e){
            throw new RestRuntimeException("文件转存出现IOexception！"+e.getMessage(),"10003");
        }
        return savedFileInfo;
    }

    @Override
    public SavedFileInfo save(MultipartFile file, SavedFileInfo savedFileInfo) {
        try{
            FileUtils.copyFile(file,savedFileInfo.getPath());
        }catch (FileNotFoundException e){
            throw new RestRuntimeException("原文件未找到！"+e.getMessage(),"10002");
        }catch (IOException e){
            throw new RestRuntimeException("文件转存出现IOexception！"+e.getMessage(),"10003");
        }
        return savedFileInfo;
    }

    @Override
    public File readFile(String path) {
        String fileAddres = basePath+File.separator+path;
        File target = new File(fileAddres);
        return target;
    }
}
