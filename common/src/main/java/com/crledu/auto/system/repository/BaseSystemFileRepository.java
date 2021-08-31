package com.crledu.auto.system.repository;

import com.crledu.auto.system.dto.SavedFileInfo;
import com.crledu.auto.web.exception.RestRuntimeException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface BaseSystemFileRepository {

    /**
     *****************************************************************************
     * @Description 将文件保存到系统的文件保存位子
     *****************************************************************************
     * @Param [file]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/6 14:17
     *****************************************************************************
     **/
    SavedFileInfo save(File file,SavedFileInfo savedFileInfo);

    SavedFileInfo save(MultipartFile file, SavedFileInfo savedFileInfo);

    /**
     *****************************************************************************
     * @Description 通过文件路径访问文件
     *****************************************************************************
     * @Param [path]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/6 14:19
     *****************************************************************************
     **/
    File readFile(String path);
}
