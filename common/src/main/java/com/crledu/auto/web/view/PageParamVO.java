package com.crledu.auto.web.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 分页查询参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/17 9:06
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("分页")
public class PageParamVO {

    @ApiModelProperty("页码")
    private Integer pageNum;
    @ApiModelProperty("单页条数")
    private Integer pageSize;

    public PageParamVO() {
        this.pageNum = 1;
        this.pageSize = 10;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum)
    {
        if(pageNum != null && pageNum>0){
            this.pageNum = pageNum;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if(pageSize != null && pageSize >0){
            this.pageSize = pageSize;
        }
    }

    public Integer getOffset(){
        return pageSize * (pageNum-1);
    }

    public Integer getLimit(){
        return pageSize;
    }
}
