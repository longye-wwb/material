package com.crledu.auto.material.base.service;

import com.crledu.auto.material.base.domain.AbstructImportDomain;
import com.crledu.auto.material.base.dto.ImportHistoryFormDto;
import com.crledu.auto.material.base.dto.ImportItemFileData;
import com.crledu.auto.material.base.dto.ImportItemFormData;
import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.base.service.annotation.DataName;
import com.crledu.auto.material.base.service.annotation.TableConstructor;
import com.crledu.auto.material.bigdata.biz.thread.BuildDataPackage;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.utils.ImageUtils;
import com.crledu.auto.material.utils.MatlabFileUtils;
import com.crledu.auto.util.MapUtils;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.util.file.CSVFileUtils;
import com.crledu.auto.web.exception.RestRuntimeException;
import com.opencsv.CSVWriter;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 ************************************************************
 * @Description: 导入解析文件的服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/30 14:59
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public abstract class AbstractImportService<T extends AbstructImportDomain> {

    public final String STRUCT_FILE_KEY = "sruct";
    public final String METLAB_FILE_KEY = "metlab";

    private String fileName = "template.csv";

    protected void importMaterialData(ImportItemFileData fileData, ImportHistoryFormDto historyDto, ImportItemFormData formData){
        ImportDataCreateDto createDto = new ImportDataCreateDto();
        try {
            createDto.setForm(MapUtils.getObjectToMap(formData));
            Map<String,MultipartFile> fileMap = new HashedMap();
            fileMap.put(STRUCT_FILE_KEY,fileData.getStruct());
            fileMap.putAll(fileData.getDataMap());
            fileMap.putAll(fileData.getPlusMap());
            createDto.setFiles(fileMap);
            createDto.setProcess(historyDto.getProcess());
            createDto.setDataFrom(historyDto.getDataForm());
            createDto.setCreator(historyDto.getCreator());
            createDto.setType(historyDto.getType().getId());

        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        ImportDataItemDto importDataItemDto = saveIntoHistory(createDto);
        Map<String,File> dataFile = new HashedMap();
        for(String name:fileData.getDataMap().keySet()){
            dataFile.put(name,importDataItemDto.getFiles().get(name));
        }
        formData.setImportId(importDataItemDto.getId());
        //为了适配没有数据表格的情况，
        File file = importDataItemDto.getFiles().get(STRUCT_FILE_KEY);
        if(ObjectUtils.isNotNull(file)){
            setDataTotal(importDataItemDto.getId(),readData(importDataItemDto.getFiles().get(STRUCT_FILE_KEY),formData,dataFile));
        }else{
            setDataTotal(importDataItemDto.getId(),readData(importDataItemDto.getStructData(),formData,dataFile));
        }

    }

    /**
     ************************************************************
     * @Description: 解析曲线的数据并保存
     * @Version: v1.1.1
     ************************************************************
     * @CopyrightBy: 创享源信息技术有限公司
     * @author: wenyi
     * @Date: 2020/11/30 17:51
     ************************************************************
     * @ModifiedBy: [name] on [time]
     ************************************************************
     **/
    private Integer readData(File struct, ImportItemFormData formData, Map<String,File> dataFiles){

        //解析文件比较数据的行数
        List<String[]> structData = CSVFileUtils.readCsv(struct,',');
        Map<String,List<String[]>> data = new HashedMap();
        String[] waveLength = null;
        Set<String> dataKeySet = dataFiles.keySet();
        for(String name : dataKeySet){
            List<String[]> fileData = CSVFileUtils.readCsv(dataFiles.get(name));
            if(waveLength != null&&waveLength.length!=fileData.get(0).length){
                throw new RestRuntimeException("导入参数文件的"+name+":列数不对应。","1300000101");
            }
            waveLength = fileData.get(0);
            data.put(name,fileData);
            if(data.get(name).size() != structData.size()){
                throw new RestRuntimeException("导入参数文件的"+name+":行数不对应。","1300000101");
            }
        }
        //分析结构数据表格
        Map<String,Integer> structHeader = new HashedMap();
        for(int j = 0 ;j<structData.get(0).length;j++){
            structHeader.put(structData.get(0)[j],j);
        }

        //分析波长数据表头
        Float[] header = new Float[waveLength.length];
        for(int b = 0;b < waveLength.length;b++){
            try{
                header[b] = Float.parseFloat(waveLength[b]);
            }catch (NumberFormatException e){
                header[b] = Float.parseFloat(new Integer(b).toString());
            }

        }
        if(formData.getSaveData()){
            emptyTable();
        }
        //分析曲线数据的表格
        for(int a = 1;a<structData.size();a++){
            //获得曲线数据
            Map<String,String[]> dataMap = new HashedMap();
            for(String key:dataKeySet){
                dataMap.put(key,data.get(key).get(a));
            }
            saveRow(structData.get(a),structHeader,header,dataMap,formData);
        }
        BuildDataPackage buildPackage = new BuildDataPackage(formData.getImportId(),getBasePath());
        buildPackage.start();
        return structData.size() - 1;
    }

    private Integer readData(List<String[]> struct, ImportItemFormData formData, Map<String,File> dataFiles){
        //解析文件比较数据的行数
        Map<String,List<String[]>> data = new HashedMap();
        String[] waveLength = null;
        Set<String> dataKeySet = dataFiles.keySet();
        for(String name : dataKeySet){
            List<String[]> fileData = CSVFileUtils.readCsv(dataFiles.get(name));
            if(waveLength != null&&waveLength.length!=fileData.get(0).length){
                throw new RestRuntimeException("导入参数文件的"+name+":列数不对应。","1300000101");
            }
            waveLength = fileData.get(0);
            data.put(name,fileData);
            if(data.get(name).size() != struct.size()){
                throw new RestRuntimeException("导入参数文件的"+name+":行数不对应。","1300000101");
            }
        }
        //分析结构数据表格
        Map<String,Integer> structHeader = new HashedMap();
        for(int j = 0 ;j<struct.get(0).length;j++){
            structHeader.put(struct.get(0)[j],j);
        }

        //分析波长数据表头
        Float[] header = new Float[waveLength.length];
        for(int b = 0;b < waveLength.length;b++){
            try{
                header[b] = Float.parseFloat(waveLength[b]);
            }catch (NumberFormatException e){
                header[b] = Float.parseFloat(new Integer(b).toString());
            }
        }
        if(formData.getSaveData()){
            emptyTable();
        }
        //分析曲线数据的表格
        for(int a = 1;a<struct.size();a++){
            //获得曲线数据
            Map<String,String[]> dataMap = new HashedMap();
            for(String key:dataKeySet){
                dataMap.put(key,data.get(key).get(a));
            }
            saveRow(struct.get(a),structHeader,header,dataMap,formData);
        }
        BuildDataPackage buildPackage = new BuildDataPackage(formData.getImportId(),getBasePath());
        buildPackage.start();
        return struct.size() - 1;
    }

    private void saveRow(String[] struct,Map<String,Integer> tableHeader,Float[] waveLength,Map<String,String[]> data,ImportItemFormData importItemFormData){
        //获得构造函数
        Constructor tableConstructor = getTableConstructor(getDomainClass());
        //获得构造函数的参数列表
        Type[] paramTypes = tableConstructor.getGenericParameterTypes();
        Annotation[][] annotations = tableConstructor.getParameterAnnotations();
        //构建参数数组
        Object[] params = new Object[paramTypes.length];
        for(int i = 0;i<paramTypes.length;i++){
            Type type = paramTypes[i];
            Annotation[] paramAnnotation = annotations[i];
            if(paramAnnotation.length == 0){
                Class typeClass = (Class)type;
                if(ImportItemFormData.class.isAssignableFrom(typeClass)){
                    params[i] = importItemFormData;
                    continue;
                }else if(typeClass.isArray()){
                    params[i] = waveLength;
                    continue;
                }
            }else{
                for(Annotation annotation:paramAnnotation){
                    if(annotation instanceof ColumnName){
                        ColumnName columnName = (ColumnName)annotation;
                        String name = columnName.value();
                        String valueStr = struct[tableHeader.get(name)];
                        params[i]= ObjectUtils.getValueByString(type,valueStr);
                        break;
                    }else if(annotation instanceof DataName){
                        String name = ((DataName)annotation).value();
                        params[i]=data.get(name);
                        break;
                    }
                }
            }
        }
        try{
            T domain = (T)tableConstructor.newInstance(params);
            saveDomain(domain);
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }

    }

    private Constructor getTableConstructor(Class clazz){
        //获取domain的构造方法
        Constructor[] cons= clazz.getDeclaredConstructors();
        //查找一个通过注解注释的构造方法
        for(Constructor constructor:cons){
            if(constructor.isAnnotationPresent(TableConstructor.class)){
                return constructor;
            }
        }
        return null;
    }

    protected void buildTemplateFile(HttpServletResponse response, HttpServletRequest request) throws IOException{
        String userAgent = request.getHeader("User-Agent");
        //获得构造函数
        Constructor tableConstructor = getTableConstructor(getDomainClass());
        //获取表格中的列
        Annotation[][] annotations = tableConstructor.getParameterAnnotations();
        //分解表格中的列属性
        List<String> columnList = new ArrayList<>();
        for(int i = 0;i<annotations.length;i++){
            Annotation[] paramAnnotation = annotations[i];
            for(Annotation annotation:paramAnnotation){
                if(annotation instanceof ColumnName){
                    ColumnName columnName = (ColumnName)annotation;
                    columnList.add(columnName.value());
                    break;
                }
            }
        }
        String[] line = new String[columnList.size()];
        //编写文件
        if(columnList.size() > 0){
            for(int j = 0;j<columnList.size();j++){
                line[j] = columnList.get(j);
            }
        }
        List<String[]> content = new ArrayList<>();
        content.add(line);
        // 针对IE或者以IE为内核的浏览器：
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE浏览器的处理：
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setHeader("Content-Disposition",  String.format("attachment; filename=%s", fileName));
        response.setContentType("application/octet-stream");
        CSVFileUtils.writeDataToFile(response.getOutputStream(),content,',');
    }

    protected abstract ImportDataItemDto saveIntoHistory(ImportDataCreateDto importDataCreateDto);

    protected abstract void saveDomain(T domain);

    protected abstract Class getDomainClass();

    protected abstract void emptyTable();

    protected abstract void setDataTotal(Long id,Integer size);

    protected abstract String getBasePath();
}
