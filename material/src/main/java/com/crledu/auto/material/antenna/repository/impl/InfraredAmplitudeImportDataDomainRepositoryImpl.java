package com.crledu.auto.material.antenna.repository.impl;

import com.crledu.auto.material.antenna.biz.domain.AntennaImportDataDomain;
import com.crledu.auto.material.antenna.biz.domain.InfraredAmplitudeImportDataDomain;
import com.crledu.auto.material.antenna.biz.repository.BaseInfraredAmplitudeImportDataDomainRepository;
import com.crledu.auto.material.antenna.repository.dao.BaseInfraredAmplitudeDao;
import com.crledu.auto.material.antenna.repository.dto.AntennaEntityDataDto;
import com.crledu.auto.material.antenna.repository.entity.AbstractAntennaEntity;
import com.crledu.auto.material.antenna.repository.entity.InfraredAmplitudeEntity;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.util.ObjectUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 红外宽带振幅转换数据仓库实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 14:38
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class InfraredAmplitudeImportDataDomainRepositoryImpl extends AntennaImportDataDomainRepositoryImpl implements BaseInfraredAmplitudeImportDataDomainRepository {

    @Resource
    protected void setMyDao(BaseInfraredAmplitudeDao dao) {
        setDao(dao);
    }

    @Resource
    protected void setMyBigdataRepositoryService(BaseBigdataRepositoryService bigdataRepositoryService) {
        setBigdataRepositoryService(bigdataRepositoryService);
    }

    @Override
    public InfraredAmplitudeImportDataDomain createWithData(Long id) {
        return null;
    }

    @Override
    public InfraredAmplitudeImportDataDomain saveInData(InfraredAmplitudeImportDataDomain domain) {
        AntennaImportDataDomain newDomain = save(domain);
        if(ObjectUtils.isNotNull(newDomain)){
            return (InfraredAmplitudeImportDataDomain)newDomain;
        }else{
            return  null;
        }
    }

    @Override
    public InfraredAmplitudeImportDataDomain updateToData(InfraredAmplitudeImportDataDomain domain) {
        return null;
    }

    @Override
    public Boolean deleteFromData(Long id) {
        return null;
    }

    @Override
    protected AntennaEntityDataDto getNewEntityDataDto() {
        return new AntennaEntityDataDto();
    }

    @Override
    protected AbstractAntennaEntity getNewEntity() {
        return new InfraredAmplitudeEntity();
    }

    @Override
    public AntennaImportDataDomain get(Long id) {
        return createWithData(id);
    }
}
