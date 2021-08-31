package com.crledu.auto.util.file;

import com.crledu.auto.util.date.DateUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 文件处理工具方法集合
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/6/30 16:56
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class FileUtils {

    public static final String fileNameSpliter = ".";

    /**
     *****************************************************************************
     * @Description 通过数组建立文件路径
     *****************************************************************************
     * @Param [args, needSeparatorBegin]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/6/30 17:22
     *****************************************************************************
     **/
    public static String buildFilePath(String[] args,boolean needSeparatorBegin){
        StringBuilder sb = new StringBuilder();
        if(args.length > 0){
            for(int i = 0 ; i < args.length ; i++){
                if(args[i].trim().isEmpty()){
                    continue;
                }else{
                    if(i == 0 && !needSeparatorBegin){
                        sb.append(args[i].trim());
                    }else{
                        sb.append(File.separator);
                        sb.append(args[i].trim());
                    }
                }
            }
            return sb.toString();
        }else{
            if(needSeparatorBegin){
                return File.separator;
            }else{
                return "";
            }
        }
    }

    /**
     *****************************************************************************
     * @Description 拼接url路径。
     *****************************************************************************
     * @Param [args, needSeparatorBegin]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/10 17:55
     *****************************************************************************
     **/
    public static String buildUrlPath(String[] args,boolean needSeparatorBegin){
        StringBuilder sb = new StringBuilder();
        if(args.length > 0){
            for(int i = 0 ; i < args.length ; i++){
                if(args[i].trim().isEmpty()){
                    continue;
                }else{
                    if(i == 0 && !needSeparatorBegin){
                        sb.append(args[i].trim());
                    }else{
                        sb.append("/");
                        sb.append(args[i].trim());
                    }
                }
            }
            return sb.toString();
        }else{
            if(needSeparatorBegin){
                return "/";
            }else{
                return "";
            }
        }
    }

    /**
     *****************************************************************************
     * @Description 获取文件后缀。
     *****************************************************************************
     * @Param [file]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/3 11:21
     *****************************************************************************
     **/
    public static String getFileSuffix(File file){
        String fileName = file.getName();
        return getFileSuffix(fileName);
    }

    public static String getFileSuffix(String fileName){

        Integer index = fileName.lastIndexOf(fileNameSpliter);
        String result = fileName.substring(index+".".length());
        return result;
    }

    /**
     *****************************************************************************
     * @Description 获取文件名（不含后缀）
     *****************************************************************************
     * @Param [fileName]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/3 11:29
     *****************************************************************************
     **/
    public static String  getPrefix(String fileName){

        Integer index = fileName.lastIndexOf(fileNameSpliter);
        String result = fileName.substring(0,index);
        return result;
    }

    /**
     *****************************************************************************
     * @Description 获取文件的名称（不包含后缀）
     *****************************************************************************
     * @Param [file]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/3 12:08
     *****************************************************************************
     **/
    public static String getPrefix(File file){
        String filename = getFileName(file);
        return getPrefix(filename);
    }

    /**
     *****************************************************************************
     * @Description 获取文件的名称（包含后缀）
     *****************************************************************************
     * @Param [file]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/3 11:24
     *****************************************************************************
     **/
    public static String getFileName(File file){
        return file.getName();
    }

    public static String getFileName(MultipartFile file){
        return file.getOriginalFilename();
    }

    /**
     *****************************************************************************
     * @Description 新建文件的名称。
     *****************************************************************************
     * @Param [file, expectDate]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/3 14:10
     *****************************************************************************
     **/
    public static String rebuildFileName(File file,Boolean expectDate){
        String addtion = expectDate?DateUtils.getTodayDateString(DateUtils.DEFAULT_TIME_PATTERN):DateUtils.getTodayDateString(DateUtils.FILE_PATTERN);
        String filePrefix = getPrefix(file);
        String suffix = getFileSuffix(file);
        return filePrefix + "-" + addtion + "." + suffix;
    }

    public static String rebuildFileName(String fileName,Boolean expectDate){
        String addtion = expectDate?DateUtils.getTodayDateString("HHmmss"):DateUtils.getTodayDateString(DateUtils.FILE_PATTERN);
        String filePrefix = getPrefix(fileName);
        String suffix = getFileSuffix(fileName);
        return filePrefix + "-" + addtion + "." + suffix;
    }

    /**
     *****************************************************************************
     * @Description 保存文件到系统的相应盘位,并返回相对路径（加上basepath为完整路径）
     *****************************************************************************
     * @Param [relaticvPath, resource, realnamed]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/3 11:34
     *****************************************************************************
     **/
    public static String saveFile(String basePath, String relaticvPath, File resource, boolean realnamed) throws FileNotFoundException,IOException{
        //判断文件存放地址是否存在
        File basefilePath = new File(basePath);
        if(basefilePath.exists()){
            //构建文件的相对路径
            List<String> pathList = new ArrayList<>();
            pathList.add(relaticvPath);
            //为保证文件夹的大小，每天自动新建一个日期文件夹
            String timePath = DateUtils.getTodayDateString(null);
            pathList.add(timePath);
            //重建文件名
            String fileNewName = rebuildFileName(resource,true);
            pathList.add(fileNewName);
            String[] paths = new String[]{};
            pathList.toArray(paths);
            String filePath = FileUtils.buildFilePath(paths,true);
            File target = new File(basePath + filePath);
            copyFile(resource,target);
            return filePath;
        }else {
            throw new FileNotFoundException("文件存放的文件夹不存在。");
        }
    }

    /**
     *****************************************************************************
     * @Description copy文件source到target
     *****************************************************************************
     * @Param [source, target]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/3 14:09
     *****************************************************************************
     **/
    public static  void  copyFile(File source,File target) throws FileNotFoundException,IOException{
        if(!target.exists()){
            target.mkdirs();
        }
        BufferedOutputStream out = null;
        BufferedInputStream fi = null;
        try {
            //将上传文件保存到服务器上传文件夹目录下
            out = new BufferedOutputStream(new FileOutputStream(target));
            byte[] buffer = new byte[1024];
            fi = new BufferedInputStream(new FileInputStream(source));
            while (fi.read(buffer) > 0) {
                out.write(buffer);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
           throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }finally {
            //关闭处理流
            if(fi!=null){fi.close();}
            if(out!=null){out.close();}
        }
    }

    /**
     *****************************************************************************
     * @Description copy文件source到target
     *****************************************************************************
     * @Param [source, target]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/3 14:09
     *****************************************************************************
     **/
    public static  void  copyFile(File source,String targetPath) throws FileNotFoundException,IOException{

        String pathString = targetPath.substring(0,targetPath.lastIndexOf(File.separator));
        File path = new File(pathString);
        File target = new File(targetPath);
        if(!path.exists()){
            path.mkdirs();
        }
        BufferedOutputStream out = null;
        BufferedInputStream fi = null;
        try {
            //将上传文件保存到服务器上传文件夹目录下
            out = new BufferedOutputStream(new FileOutputStream(target));
            byte[] buffer = new byte[1024];
            fi = new BufferedInputStream(new FileInputStream(source));
            while (fi.read(buffer) > 0) {
                out.write(buffer);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }finally {
            //关闭处理流
            if(fi!=null){fi.close();}
            if(out!=null){out.close();}
        }
    }

    public static  void  copyFile(MultipartFile source, String targetPath) throws IOException{

        String pathString = targetPath.substring(0,targetPath.lastIndexOf(File.separator));
        File path = new File(pathString);
        File target = new File(targetPath);
        if(!path.exists()){
            path.mkdirs();
        }
        BufferedOutputStream out = null;
        BufferedInputStream fi = null;
        try {
            //将上传文件保存到服务器上传文件夹目录下
            out = new BufferedOutputStream(new FileOutputStream(target));
            byte[] buffer = new byte[1024];
            fi = new BufferedInputStream(source.getInputStream());
            while (fi.read(buffer) > 0) {
                out.write(buffer);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }finally {
            //关闭处理流
            if(fi!=null){fi.close();}
            if(out!=null){out.close();}
        }
    }

    public static String formatFileSize(long fileS) {//转换文件大小
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }
}
