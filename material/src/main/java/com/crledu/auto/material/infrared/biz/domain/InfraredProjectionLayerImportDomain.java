package com.crledu.auto.material.infrared.biz.domain;

import com.crledu.auto.material.base.domain.AbstructImportDomain;
import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.base.service.annotation.DataName;
import com.crledu.auto.material.base.service.annotation.TableConstructor;
import com.crledu.auto.material.infrared.biz.dto.InfraredProjectionFormdataDto;
import com.crledu.auto.material.infrared.biz.dto.ProjectionDataItemDto;

import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 红外透射业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/7 12:19
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class InfraredProjectionLayerImportDomain extends AbstructImportDomain {

    private ProjectionLayerMetalPatchDomain patchDomain;

    private ProjectionLayerBaseDomain baseDomain;

    /**
     * 红外辐射率
     */
    private Float infraredEmissivity;

    private Float lightAngle;

    private List<ProjectionDataItemDto> data;

    @TableConstructor
    public InfraredProjectionLayerImportDomain(@ColumnName("p") Float period, @ColumnName("d")Float width, InfraredProjectionFormdataDto formdataDto, Float[] waveLengths, @DataName("projection") String[] projection){
        super(formdataDto);
        this.lightAngle = formdataDto.getLightAngle();
        this.baseDomain = ProjectionLayerBaseDomain.getInstance(formdataDto.getBaseMaterial(),formdataDto.getBaseThickness(),formdataDto.getBaseElectric(),formdataDto.getBaseInfraredEmissivity());
        this.patchDomain = ProjectionLayerMetalPatchDomain.getInstance(formdataDto.getPatchMaterial(),formdataDto.getPatchInfraredEmissivity(),period,width,formdataDto.getPatchThickness());
        this.data = new ArrayList<>();
        for(int i = 0;i<waveLengths.length;i++){
            ProjectionDataItemDto dataItemDto = new ProjectionDataItemDto();
            dataItemDto.setWavelength(waveLengths[i]);
            dataItemDto.setProjection(Float.parseFloat(projection[i]));
            this.data.add(dataItemDto);
        }
        this.infraredEmissivity = computeInfraredEmissivity();
    }

    private Float computeInfraredEmissivity(){
        /**
         *  ε1*t+ε2*(1-t)
         *  没有基底用材料三红外发射率ε3代替ε2
         */
        Float scale = 1.0F - patchDomain.getProportionOfMetals();
        Float result = 1.0f - (patchDomain.getInfraredEmissivity() * patchDomain.getProportionOfMetals() + baseDomain.getInfraredEmissivity() * scale);
        return result;
    }

    public ProjectionLayerMetalPatchDomain getPatchDomain() {
        return patchDomain;
    }

    public ProjectionLayerBaseDomain getBaseDomain() {
        return baseDomain;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public Float getInfraredEmissivity() {
        return infraredEmissivity;
    }

    public List<ProjectionDataItemDto> getData() {
        return data;
    }
}
