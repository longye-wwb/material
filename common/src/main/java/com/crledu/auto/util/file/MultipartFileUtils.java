package com.crledu.auto.util.file;

import org.springframework.web.multipart.MultipartFile;


public class MultipartFileUtils {

    /**
     *****************************************************************************
     * @Description 获得上传的临时文件的文件名
     *****************************************************************************
     * @Param [file]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/6 14:05
     *****************************************************************************
     **/
    public static String getFileName(MultipartFile file){
        String name = file.getOriginalFilename();
        return name;
    }

    /**
     *****************************************************************************
     * @Description 获得文件的后缀名称
     *****************************************************************************
     * @Param [file]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/6 14:07
     *****************************************************************************
     **/
    public static String getFileSuffix(MultipartFile file){
        String[] splits = getFileName(file).split(".");
        return splits[splits.length-1];
    }

    /**
     *****************************************************************************
     * @Description 获得文件的前缀（文件的名称）
     *****************************************************************************
     * @Param [file]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/6 14:10
     *****************************************************************************
     **/
    public static String getFilePrefix(MultipartFile file){
        String fileName = getFileName(file);
        String[] ffixs = fileName.split(".");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<ffixs.length-1;i++){
            sb.append(ffixs[i]);
        }
        return sb.toString();
    }
}
