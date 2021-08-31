package com.crledu.auto.util.file;

import com.opencsv.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: csv文件相关工具
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/12 16:31
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class CSVFileUtils {

    //参考https://www.jianshu.com/p/6414185b2f01

     private static Logger logger = LoggerFactory.getLogger(CSVFileUtils.class);

    public static List<String[]> readCsv(File file){
        try {
            InputStreamReader is = new InputStreamReader(new FileInputStream(file), "utf-8");
            CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build();
            CSVReader reader = new CSVReaderBuilder(is).withCSVParser(csvParser).build();
            List<String[]> strings = reader.readAll();
            return strings;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<String[]> readCsv(File file,char csvSeparator){
        try {
            InputStreamReader is = new InputStreamReader(new FileInputStream(file), "utf-8");
            CSVParser csvParser = new CSVParserBuilder().withSeparator(csvSeparator).build();
            CSVReader reader = new CSVReaderBuilder(is).withCSVParser(csvParser).build();
            List<String[]> strings = reader.readAll();
            return strings;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static <T> List<T> parseCsvToBean(Class<T> clazz, String fileName, String params, char csvSeparator, int skipLineNum) throws FileNotFoundException {
        //获取列位置数组
        String[] columnMapping = params.split("\\|", -1);
        ColumnPositionMappingStrategy<T> mapper = new ColumnPositionMappingStrategy<>();
        mapper.setColumnMapping(columnMapping);
        mapper.setType(clazz);
        List<T> parse;
        try {
            CsvToBean csvToBean = new CsvToBeanBuilder(new FileReader(fileName))
                    .withMappingStrategy(mapper)
                    .withSeparator(csvSeparator)
                    .withSkipLines(skipLineNum)
                    .build();
            parse = csvToBean.parse();
        } catch (FileNotFoundException e) {
            logger.error("【fileName：{}地址异常！】", fileName);
            throw e;
        }
        return parse;
    }

    public static void writeDataToFile(String fileName,List<String[]> data){
        CSVWriter writer= null;
        try {
            writer = new CSVWriter(
                    new OutputStreamWriter(new FileOutputStream(fileName),"utf-8"),
                    '\t',CSVWriter.NO_QUOTE_CHARACTER);
            for(String[] item:data){
                writer.writeNext(item);
            }
            writer.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataToFile(String fileName,List<String[]> data,char csvSeparator){
        CSVWriter writer= null;
        try {
            writer = new CSVWriter(
                    new OutputStreamWriter(new FileOutputStream(fileName),"utf-8"),
                    csvSeparator,CSVWriter.NO_QUOTE_CHARACTER);
            for(String[] item:data){
                writer.writeNext(item);
            }
            writer.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataToFile(OutputStream outputStream,List<String[]> data,char csvSeparator){
        CSVWriter writer= null;
        try {
            writer = new CSVWriter(
                    new OutputStreamWriter(outputStream,"utf-8"),
                    csvSeparator,CSVWriter.NO_QUOTE_CHARACTER);
            for(String[] item:data){
                writer.writeNext(item);
            }
            writer.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
