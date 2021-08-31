package com.crledu.auto.material.system.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 ************************************************************
 * @Description: 访问量数据实体
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/20 14:47
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@TableName("sys_counter")
public class VisitorCounterEntity {

    /**
     * 访问数据类型
     */
    @TableId(value = "id",type = IdType.INPUT)
    private Long id;

    /**
     * 访问统计
     */
    private Float total;

    public VisitorCounterEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
