package com.crledu.auto.web.dto;

/**
 ************************************************************
 * @Description: 管理列表数据结构
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/20 15:27
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ItemDTO {

    /**
     * 列表项主键
     */
    private Long id;

    /**
     * 列表项状态
     */
    private Integer statu;

    /**
     * 列表项目状态名称
     */
    private String statuName;

    public ItemDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public String getStatuName() {
        return statuName;
    }

    public void setStatuName(String statuName) {
        this.statuName = statuName;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", statu=" + statu +
                ", statuName='" + statuName + '\'' +
                '}';
    }
}
