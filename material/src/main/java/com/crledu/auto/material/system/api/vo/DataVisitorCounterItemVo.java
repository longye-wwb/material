package com.crledu.auto.material.system.api.vo;

import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 数据访问热度展示数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/20 14:56
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("热度统计")
public class DataVisitorCounterItemVo {

    @ApiModelProperty("归类编码")
    private Long id;

    @ApiModelProperty("归类名称")
    private String name;

    @ApiModelProperty("统计热度")
    private Float data;

    public DataVisitorCounterItemVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.name = DataTypeEnum.findNameById(id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Float getData() {
        return data;
    }

    public void setData(Float data) {
        this.data = data;
    }
}
