package com.crledu.auto.material.impor.data.dto;

import com.crledu.auto.web.view.PageParamVO;
import com.crledu.auto.web.vo.date.DateAreaParamVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 ************************************************************
 * @Description: 导入历史选择参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/19 10:26
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("导入历史筛选")
public class ImportHistorySelectDto extends PageParamVO {

    @ApiModelProperty("上传时间")
    private DateAreaParamVo createTime;

    @ApiModelProperty("数据类型")
    private Integer type;

    public ImportHistorySelectDto() {
    }

    public DateAreaParamVo getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateAreaParamVo createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
