package com.crledu.auto.web.response;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
 ************************************************************
 * @Description: 分页数据返回结构
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/16 19:11
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class PageDate<ITEM> {

    private Long total;

    private Integer pageSize;

    private Integer pageNum;

    private List<ITEM> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public List<ITEM> getRows() {
        return rows;
    }

    public void setRows(List<ITEM> rows) {
        this.rows = rows;
    }

    public PageDate() {
    }

    public PageDate(Page<ITEM> page) {
        this.pageNum =Long.valueOf(page.getCurrent()).intValue();
        this.pageSize=Long.valueOf(page.getSize()).intValue();
        this.total =page.getTotal();
        this.rows=page.getRecords();
    }

    public PageDate(Long total, Integer pageSize, Integer pageNum, List<ITEM> rows) {
        this.total = total;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.rows = rows;
    }


}
