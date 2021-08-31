package com.crledu.auto.util.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 ************************************************************
 * @Description: 文件zip压缩
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/19 9:21
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ZipUtils {

    private static final int BUFFER_SIZE = 2 * 1024;
    private static final Logger log = LoggerFactory.getLogger(ZipUtils.class);

    public static void toZip(String srcDir, OutputStream outputStream,Boolean keepDirStructure){
        Long start = System.currentTimeMillis();
        ZipOutputStream zos = null;
        try{
            zos = new ZipOutputStream(outputStream);
            File source = new File(srcDir);
            compress(source,zos,source.getName(),keepDirStructure);
            log.info("压缩完成，耗时：" + (System.currentTimeMillis() - start) + " ms");
            zos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void compress(File sourceFile, ZipOutputStream zos,String name,Boolean keepDirStructure){
        byte[] buf = new byte[BUFFER_SIZE];
        if(sourceFile.isFile()){
            try{
                zos.putNextEntry(new ZipEntry(name));
                Integer length = -1;
                FileInputStream fi = new FileInputStream(sourceFile);
                while ((length = fi.read(buf)) != -1){
                    zos.write(buf);
                }
                zos.closeEntry();
                fi.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }else{
            File[] children = sourceFile.listFiles();
            if(children == null || children.length ==0){
                try{
                    if(keepDirStructure){
                        zos.putNextEntry(new ZipEntry(name+ "/"));
                        zos.closeEntry();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }

            }else{
                for(File file:children){
                    if(keepDirStructure){
                        compress(file,zos,name +"/"+file.getName(), true);
                    }else{
                        compress(file,zos,file.getName(), false);
                    }
                }
            }
        }

    }
}
