package com.crledu.auto.material.bigdata.biz.service.impl;

import com.crledu.auto.material.bigdata.biz.domain.BigdataDomain;
import com.crledu.auto.material.bigdata.biz.repository.BaseBigdataDomianRepository;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.util.file.FileUtils;
import com.crledu.auto.util.string.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;

/**
 ************************************************************
 * @Description: 深度学习数据仓库服务实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/18 17:02
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class BigdataRepositoryServiceImpl implements BaseBigdataRepositoryService {

    @Resource
    private BaseBigdataDomianRepository bigdataDomianRepository;

    @Override
    public String saveData(Object data, Long importId) {
        BigdataDomain bigdataDomain = BigdataDomain.getInstance(importId, data);
        bigdataDomianRepository.saveInData(bigdataDomain);
        return bigdataDomain.getPath();
    }

    @Override
    public File downloadData(Long id) {
        return bigdataDomianRepository.getGetDataPackage(id);
    }

    @Override
    public String getDataFile(String path) {
        if(ObjectUtils.isNull(path)){
            return "";
        }
        File file = new File(path);
        String result = StringUtils.EMPTY_STRING;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = br.readLine()) != null){
                result += line;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer deleteDataFile(Long importId) {
        return null;
    }

    @Override
    public String countDataDileSize() {
        long size = bigdataDomianRepository.getDataFileSize();
        String sizeStr = FileUtils.formatFileSize(size);
        return sizeStr;
    }
}
