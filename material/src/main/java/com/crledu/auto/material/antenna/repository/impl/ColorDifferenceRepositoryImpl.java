package com.crledu.auto.material.antenna.repository.impl;

import com.crledu.auto.material.antenna.biz.domain.AntennaImportDataDomain;
import com.crledu.auto.material.antenna.biz.domain.ColorDifferenceImportDataDomain;
import com.crledu.auto.material.antenna.biz.repository.BaseColorDifferenceRepository;
import com.crledu.auto.material.antenna.repository.dao.BaseColorDiffrenceMapper;
import com.crledu.auto.material.antenna.repository.dao.BaseInfraredAmplitudeDao;
import com.crledu.auto.material.antenna.repository.dto.AntennaEntityDataDto;
import com.crledu.auto.material.antenna.repository.dto.ColorDifferenceDataDto;
import com.crledu.auto.material.antenna.repository.entity.AbstractAntennaEntity;
import com.crledu.auto.material.antenna.repository.entity.ColorDifferenceEntity;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.util.ObjectUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 消色差结构数据对象数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 15:24
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class ColorDifferenceRepositoryImpl extends AntennaImportDataDomainRepositoryImpl implements BaseColorDifferenceRepository {

    @Resource
    protected void setMyDao(BaseColorDiffrenceMapper dao) {
        setDao(dao);
    }

    @Resource
    protected void setMyBigdataRepositoryService(BaseBigdataRepositoryService bigdataRepositoryService) {
        setBigdataRepositoryService(bigdataRepositoryService);
    }

    @Override
    protected AntennaEntityDataDto getNewEntityDataDto() {
        return new ColorDifferenceDataDto();
    }

    @Override
    protected AbstractAntennaEntity getNewEntity() {
        return new ColorDifferenceEntity();
    }

    @Override
    public AntennaImportDataDomain get(Long id) {
        return createWithData(id);
    }

    @Override
    public ColorDifferenceImportDataDomain createWithData(Long id) {
        return null;
    }

    @Override
    public ColorDifferenceImportDataDomain saveInData(ColorDifferenceImportDataDomain domain) {
        AntennaImportDataDomain newDomain = save(domain);
        if(ObjectUtils.isNotNull(newDomain)){
            return (ColorDifferenceImportDataDomain)newDomain;
        }else{
            return null;
        }
    }

    @Override
    public ColorDifferenceImportDataDomain updateToData(ColorDifferenceImportDataDomain domain) {
        return null;
    }

    @Override
    public Boolean deleteFromData(Long id) {
        return null;
    }
}
