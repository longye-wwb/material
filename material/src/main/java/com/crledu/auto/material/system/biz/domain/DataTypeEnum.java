package com.crledu.auto.material.system.biz.domain;

/**
 ************************************************************
 * @Description: 系统数据模块枚举
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/3 15:59
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public enum DataTypeEnum {
    PHOTON(1,"吸波材料"),INFRARED_AMPLITUDE(2,"红外宽带振幅转换"),INFRARED_PHASE(3,"红外宽带位相调控"),
    VISIBLE_LIGHT(4,"可见光"),MICRO_BREADTH(5,"微波窄带吸收"),COOLING_MATERAIL(6,"辐射制冷材料"),
    INFRARED_GRATING(7,"红外光栅"),INFRARED_PROJECTION(8,"微波红外兼容-透射层"),MICRO_ABSORBING(9,"微波吸收"),
    PROJECTION(10,"红外宽带高反射及微波宽带高透射一体化"),MICRO_AMPLITUDE(11,"微波宽带偏振转换"),MICRO_PHASE(12,"微波宽带相位调控"),
    MICROWAVE_ABSORBING(13,"微波宽带吸波器"),MICRO_INTEGRATION(14,"微波窄带透波及宽带吸波一体化"),NANO_ANTENNA(15,"纳米天线"),
    DIFFRACTION(16,"衍射组件"),COLOR_DIFFERENCE(17,"消色差结构"),BOUNDARY(18,"边界优化");
    private Integer id;
    private String name;

    DataTypeEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String findNameById(Long id){
        int idVal = id.intValue();
        DataTypeEnum[] contents = DataTypeEnum.values();
        for(DataTypeEnum dataTypeEnum:contents){
            if(idVal == dataTypeEnum.id.intValue()){
                return dataTypeEnum.name;
            }
        }
        return "未知";
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
