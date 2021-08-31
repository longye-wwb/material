package com.crledu.auto.material.impor.biz.service.impl;

import com.crledu.auto.material.impor.biz.domain.ImportDataDomain;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.repository.BaseImportDataDomainRepository;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.material.utils.ImageUtils;
import com.crledu.auto.system.dto.SavedFileInfo;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.util.file.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 ************************************************************
 * @Description: 保存导入数据到历史记录中
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/18 17:49
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class ImportDataServiceImpl implements BaseImportDataService {

    private final String MATERIAL_FILE_PATH = "material";
    private final String PROCESS_FILE_PATH = "process";
    private final String PROCESS_PRE_PATH = "process_";
    private final String DATA_PRE_PATH = "data_";
    private final String DATA_PICTURE_PATH = "picture";

    @Value("${crledu.auto.file.server}")
    private String baseUrl;

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Resource
    private BaseImportDataDomainRepository importDataDomainRepository;

    @Override
    public ImportDataItemDto saveInHistory(ImportDataCreateDto createDto, DataTypeEnum typeEnum) {
        //保存文件
        File process=null;
        if (createDto.getProcess()!=null) {
            String baseFilename = basePath+ File.separator+ PROCESS_FILE_PATH + File.separator+ Long.valueOf(System.currentTimeMillis()).toString();
             process=saveDataFile(createDto.getProcess(), baseFilename, PROCESS_PRE_PATH);
        }
        Map<String,File> fileMap = new HashMap<>();
        if(createDto.getFiles() != null){
            String baseFilename = basePath+ File.separator+ MATERIAL_FILE_PATH + File.separator+ Long.valueOf(System.currentTimeMillis()).toString();
            Set<String> fileList = createDto.getFiles().keySet();
            for(String item:fileList){
                MultipartFile file = createDto.getFiles().get(item);
                if(ObjectUtils.isNotNull(file)){
                    fileMap.put(item,saveDataFile(file,baseFilename,DATA_PRE_PATH));
                }
            }
        }
        //转换数据
        ImportDataDomain importDataDomain = ImportDataDomain.getInstance(typeEnum.getId(),createDto.getForm(),fileMap,createDto.getCreator(),createDto.getDataFrom(),process);
        ImportDataDomain savedDomain = importDataDomainRepository.saveInData(importDataDomain);
        return createItemByDomain(savedDomain);
    }

    @Override
    public void setDataTotal(Long importId, Integer total) {
importDataDomainRepository.setTotal(importId, total);
    }

    @Override
    public String savePictrue(BufferedImage image, Long importId, String name) throws IOException {
        String baseFilename = basePath+ File.separator+ DATA_PICTURE_PATH + File.separator+ "for" + importId.toString();
        File path = new File(baseFilename);
        if(!path.exists()){
            path.mkdirs();
        }
        String fileName = baseFilename + File.separator  + name + ".jpg";
        File picture = new File(fileName);
        ImageIO.write(image,"jpg",picture);
        return fileName;
    }


    private File saveDataFile(MultipartFile file, String basePath,String pre){
        String realName = file.getOriginalFilename();
        String filename = basePath + File.separator + pre +realName;
        File pathFile = new File(basePath);
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
        File target = new File(filename);
        try {
            file.transferTo(target);
        }catch (IOException e){
            e.printStackTrace();
        }
        return target;
    }

    private ImportDataItemDto createItemByDomain(ImportDataDomain domain){
        ImportDataItemDto importDataItemDto = new ImportDataItemDto();
        importDataItemDto.setFiles(domain.getFiles());
        importDataItemDto.setProcess(domain.getProcess());
        importDataItemDto.setCreateTime(domain.getCreateTime());
        importDataItemDto.setCreator(domain.getCreator());
        importDataItemDto.setDataFrom(domain.getDataFrom());
        importDataItemDto.setForm(domain.getForm());
        importDataItemDto.setId(domain.getId());
        importDataItemDto.setStatus(domain.getStatus());
        importDataItemDto.setType(domain.getType());
        return importDataItemDto;
    }
}
