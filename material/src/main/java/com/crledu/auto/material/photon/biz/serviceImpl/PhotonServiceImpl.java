package com.crledu.auto.material.photon.biz.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.bigdata.biz.thread.BuildDataPackage;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.photon.biz.domain.AbsorbLayerDomain;
import com.crledu.auto.material.photon.biz.domain.AbsorbDomain;
import com.crledu.auto.material.photon.biz.repository.PhotonRepository;
import com.crledu.auto.material.photon.biz.service.PhotonService;
import com.crledu.auto.material.photon.repository.dao.PhotonMapper;
import com.crledu.auto.material.photon.repository.dto.PhotonSelection;
import com.crledu.auto.material.photon.repository.entity.Photon;
import com.crledu.auto.material.photon.repository.dto.PhotonImport;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.util.file.CSVFileUtils;
import com.crledu.auto.web.response.PageDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Trevor
 * @Date: 2020/7/10 09:48
 * @Description:  光子业务
 */
@Service
public class PhotonServiceImpl implements PhotonService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Autowired
    private PhotonRepository photonRepository;

    @Resource
    private PhotonMapper photonMapper;

    @Autowired
    private BaseImportDataService importDataService;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    private final String ABSORBING_FILE_KEY = "吸收材料";
    private final String STRUCT_FILE_KEY = "struct";
    private final String LAYER_AMOUNT_KEY = "layer";




    /**
     *****************************************************************************
     * @Description 新增光子信息
     *****************************************************************************
     * @Param [photonImport]
     * @return void
     *****************************************************************************
     * @Author zjs
     * @Date 2020/7/10 15:03
     *****************************************************************************
     **/
    @Override
    public void addNew(PhotonImport photonImport) {
        photonRepository.save(photonImport);
    }


    /**
     *****************************************************************************
     * @Description 查询光子详情
     *****************************************************************************
     * @Param [id]
     * @return PhotonInfoVo
     *****************************************************************************
     * @Author zjs
     * @Date 2020/7/10 15:04
     *****************************************************************************
     **/
    @Override
    public Photon getInfo(Long id) {
        Photon photon = photonMapper.selectById(id);
        return photon;
    }

    /**
     *****************************************************************************
     * @Description 获取信息列表
     *****************************************************************************
     * @Param []
     * @return java.util.List<PhotonInfoVo>
     *****************************************************************************
     * @Author zjs
     * @Date 2020/7/10 15:04
     *****************************************************************************
     *
     * @param current
     * @param size*/
    @Override
    public PageDate<Photon> getList(Integer current, Integer size) {
        Page<Photon> roleIPage = new Page<>(current,size);
        IPage<Photon> roleIPage1 = photonMapper.selectPage(roleIPage, null);
        List<Photon> list = roleIPage1.getRecords();
        PageDate<Photon> pageDate = new PageDate<>();
        pageDate.setPageSize(current);
        pageDate.setPageNum(size);
        pageDate.setTotal(roleIPage1.getTotal());
        pageDate.setRows(list);
        return pageDate;
    }

    @Override
    public void addFromFile(MultipartFile file, MultipartFile process,Long user) {
        InputStream inputStream = null;
        //添加历史记录
        ImportDataCreateDto importDto = new ImportDataCreateDto();
        //importDto.setCreator(viewUserDto.getId());
        importDto.setType(1);
        importDto.setDataFrom(0);
        Map<String,MultipartFile> maps=new HashMap<>();
        maps.put(ABSORBING_FILE_KEY,file);
        importDto.setFiles(maps);
        importDto.setForm(new HashMap<>());
        importDto.setProcess(process);
        ImportDataItemDto importDataItemDto = importDataService.saveInHistory(importDto, DataTypeEnum.PHOTON);
        List<String[]> absorbingData = CSVFileUtils.readCsv(importDataItemDto.getFiles().get(ABSORBING_FILE_KEY));
        List<AbsorbLayerDomain> absorbLayerDomains =new ArrayList<>();
        emptyTable();
            for(int i=1;i<absorbingData.size();i++){
                String[] split = absorbingData.get(i);
                if (!split[2].equals("")&&!split[3].equals("")){
                    AbsorbLayerDomain domain1 = AbsorbLayerDomain.getInstense(Double.valueOf(split[2]), Double.valueOf(split[3]));
                    absorbLayerDomains.add(domain1);
                }
                if (!split[3].equals("")&&!split[4].equals("")) {
                    AbsorbLayerDomain domain2 = AbsorbLayerDomain.getInstense(Double.valueOf(split[4]), Double.valueOf(split[5]));
                    absorbLayerDomains.add(domain2);
                }
                if (!split[5].equals("")&&!split[6].equals("")) {
                    AbsorbLayerDomain domain3 = AbsorbLayerDomain.getInstense(Double.valueOf(split[6]), Double.valueOf(split[7]));
                    absorbLayerDomains.add(domain3);
                }
                AbsorbDomain absorbDomain = AbsorbDomain.getInstence(Double.valueOf(split[1]), absorbLayerDomains,Double.valueOf(split[8]),Double.valueOf(split[9]),Double.valueOf(split[10]),split[11],split[12],split[13],true);
                photonRepository.saveData(absorbDomain);
                bigdataRepositoryService.saveData(absorbDomain.buildData(),importDataItemDto.getId());
            }
        BuildDataPackage buildPackage = new BuildDataPackage(importDataItemDto.getId(),basePath);
        buildPackage.start();
        }

        private void emptyTable(){
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.isNotNull("id");
            photonMapper.delete(queryWrapper);
        }

    @Override
    public void saveFromFile(MultipartFile file, MultipartFile process, Long user) {
        InputStream inputStream = null;
        //添加历史记录
        ImportDataCreateDto importDto = new ImportDataCreateDto();
        //importDto.setCreator(viewUserDto.getId());
        importDto.setType(1);
        importDto.setDataFrom(0);
        Map<String,MultipartFile> maps=new HashMap<>();
        maps.put(ABSORBING_FILE_KEY,file);
        importDto.setFiles(maps);
        importDto.setForm(new HashMap<>());
        importDto.setProcess(process);
        ImportDataItemDto importDataItemDto = importDataService.saveInHistory(importDto, DataTypeEnum.PHOTON);
        List<String[]> absorbingData = CSVFileUtils.readCsv(importDataItemDto.getFiles().get(ABSORBING_FILE_KEY));
        List<AbsorbLayerDomain> absorbLayerDomains =new ArrayList<>();
        for(int i=1;i<absorbingData.size();i++){
            String[] split = absorbingData.get(i);
            if (!split[2].equals("")&&!split[3].equals("")){
                AbsorbLayerDomain domain1 = AbsorbLayerDomain.getInstense(Double.valueOf(split[2]), Double.valueOf(split[3]));
                absorbLayerDomains.add(domain1);
            }
            if (!split[3].equals("")&&!split[4].equals("")) {
                AbsorbLayerDomain domain2 = AbsorbLayerDomain.getInstense(Double.valueOf(split[4]), Double.valueOf(split[5]));
                absorbLayerDomains.add(domain2);
            }
            if (!split[5].equals("")&&!split[6].equals("")) {
                AbsorbLayerDomain domain3 = AbsorbLayerDomain.getInstense(Double.valueOf(split[6]), Double.valueOf(split[7]));
                absorbLayerDomains.add(domain3);
            }
            AbsorbDomain absorbDomain = AbsorbDomain.getInstence(Double.valueOf(split[1]), absorbLayerDomains,Double.valueOf(split[8]),Double.valueOf(split[9]),Double.valueOf(split[10]),split[11],split[12],split[13],false);
            bigdataRepositoryService.saveData(absorbDomain.buildData(),importDataItemDto.getId());
        }
        BuildDataPackage buildPackage = new BuildDataPackage(importDataItemDto.getId(),basePath);
        buildPackage.start();
    }

    @Override
    public List<PhotonImport> dbToExcel(PhotonSelection photonSelection) {
        List<PhotonImport> photonImports =photonRepository.dbToExcel(photonSelection);
       return photonImports;
    }
}
