package com.crledu.auto.material.system.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.material.system.api.vo.DataVisitorCounterItemVo;
import com.crledu.auto.material.system.data.service.BaseVisitorCounterDataService;
import com.crledu.auto.material.system.repository.dao.VisitorCounterMapper;
import com.crledu.auto.material.system.repository.entity.VisitorCounterEntity;
import com.crledu.auto.util.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 访问热度数据统计服务实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/20 15:01
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class VisitorCounterDataServiceImpl implements BaseVisitorCounterDataService {

    @Resource
    private VisitorCounterMapper visitorCounterMapper;

    @Override
    public Float totalVisitor() {
        QueryWrapper<VisitorCounterEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("id");
        List<VisitorCounterEntity> datas = visitorCounterMapper.selectList(queryWrapper);
        if(ObjectUtils.isNotNull(datas)){
            Float total = 0f;
            for(VisitorCounterEntity entity:datas){
                total += entity.getTotal();
            }
            return total;
        }else{
            return 0f;
        }
    }

    @Override
    public List<DataVisitorCounterItemVo> listVisitor() {
        QueryWrapper<VisitorCounterEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("id");
        List<VisitorCounterEntity> datas = visitorCounterMapper.selectList(queryWrapper);
        if(ObjectUtils.isNotNull(datas)){
            List<DataVisitorCounterItemVo> result = new ArrayList<>();
            for(VisitorCounterEntity entity:datas){
                DataVisitorCounterItemVo itemVo = new DataVisitorCounterItemVo();
                itemVo.setId(entity.getId());
                itemVo.setData(entity.getTotal());
                result.add(itemVo);
            }
            return result;
        }else{
            return new ArrayList<>();
        }
    }
}
