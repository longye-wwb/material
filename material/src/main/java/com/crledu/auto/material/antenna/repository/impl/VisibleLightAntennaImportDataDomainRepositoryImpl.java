package com.crledu.auto.material.antenna.repository.impl;

import com.crledu.auto.material.antenna.biz.domain.AntennaImportDataDomain;
import com.crledu.auto.material.antenna.biz.domain.VisibleLigntAntennaImportDataDomain;
import com.crledu.auto.material.antenna.biz.repository.BaseVisibleLigntAntennaImportDataDomainRepository;
import com.crledu.auto.material.antenna.repository.dao.BaseVisibleAntennaDao;
import com.crledu.auto.material.antenna.repository.dto.AntennaEntityDataDto;
import com.crledu.auto.material.antenna.repository.entity.AbstractAntennaEntity;
import com.crledu.auto.material.antenna.repository.entity.VisibleAntennaEntity;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.util.ObjectUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 可见光天线导入数据仓库实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 14:52
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class VisibleLightAntennaImportDataDomainRepositoryImpl extends AntennaImportDataDomainRepositoryImpl implements BaseVisibleLigntAntennaImportDataDomainRepository {

    @Resource
    protected void setMyDao(BaseVisibleAntennaDao dao) {
         setDao(dao);
    }

    @Resource
    protected void setMyBigdataRepositoryService(BaseBigdataRepositoryService bigdataRepositoryService) {
        setBigdataRepositoryService(bigdataRepositoryService);
    }

    @Override
    public VisibleLigntAntennaImportDataDomain createWithData(Long id) {
        return null;
    }

    @Override
    public VisibleLigntAntennaImportDataDomain saveInData(VisibleLigntAntennaImportDataDomain domain) {
        AntennaImportDataDomain newDomain = save(domain);
        if(ObjectUtils.isNotNull(newDomain)){
            return (VisibleLigntAntennaImportDataDomain)newDomain;
        }else{
            return  null;
        }
    }

    @Override
    public VisibleLigntAntennaImportDataDomain updateToData(VisibleLigntAntennaImportDataDomain domain) {
        return null;
    }

    @Override
    public Boolean deleteFromData(Long id) {
        return null;
    }

    @Override
    public AntennaImportDataDomain get(Long id) {
        return createWithData(id);
    }

    @Override
    protected AntennaEntityDataDto getNewEntityDataDto() {
        return new AntennaEntityDataDto();
    }

    @Override
    protected AbstractAntennaEntity getNewEntity() {
        return new VisibleAntennaEntity();
    }
}
