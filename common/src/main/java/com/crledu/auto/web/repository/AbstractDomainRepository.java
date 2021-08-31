package com.crledu.auto.web.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crledu.auto.util.ObjectUtils;

import java.io.Serializable;

/**
 ************************************************************
 * @Description: 抽象实现的领域对象仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/6 10:03
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public abstract class AbstractDomainRepository<DO extends  AbstractDomain<Long>,ENTITY extends AbstractEntity<Long>> implements BaseRepository<DO>{
    
    private BaseMapper<ENTITY> baseMapper;


    @Override
    public DO createWithData(Long id) {
        ENTITY entity = baseMapper.selectById(id);
        return buildDomain(entity);
    }

    @Override
    public DO saveInData(DO domain) {
        ENTITY entity = buildEmptyEntity();
        copyProperties(domain,entity);
        baseMapper.insert(entity);
        return createWithData(entity.getId());
    }

    @Override
    public DO updateToData(DO domain) {
        ENTITY entity = baseMapper.selectById(domain.getId());
        if(ObjectUtils.isNotNull(entity)){
            copyProperties(domain,entity);
            baseMapper.updateById(entity);
            return createWithData(entity.getId());
        }else{
            return null;
        }
    }

    @Override
    public Boolean deleteFromData(Long id) {
        ENTITY entity = baseMapper.selectById(id);
        if(ObjectUtils.isNotNull(entity)){
            baseMapper.deleteById(id);
            return true;
        }
        return false;
    }

    protected void setBaseMapper(BaseMapper<ENTITY> baseMapper) {
        this.baseMapper = baseMapper;
    }
    
    /**
     *****************************************************************************
     * @Description 将业务对象的属性传递给数据库实体
     *****************************************************************************
     * @Param 
     * @return 
     *****************************************************************************
     * @Author wenyi
     * @Date 2021/4/2 16:57
     *****************************************************************************
     **/
    protected abstract void copyProperties(DO domain, ENTITY entity);
    
    /**
     *****************************************************************************
     * @Description 通过数据库实体构建业务对象
     *****************************************************************************
     * @Param 
     * @return 
     *****************************************************************************
     * @Author wenyi
     * @Date 2021/4/2 16:58
     *****************************************************************************
     **/
    protected abstract  DO buildDomain(ENTITY entity);
    
    /**
     *****************************************************************************
     * @Description 传回没有内容的数据库实体
     *****************************************************************************
     * @Param 
     * @return 
     *****************************************************************************
     * @Author wenyi
     * @Date 2021/4/2 17:18
     *****************************************************************************
     **/
    protected abstract ENTITY buildEmptyEntity();
}
