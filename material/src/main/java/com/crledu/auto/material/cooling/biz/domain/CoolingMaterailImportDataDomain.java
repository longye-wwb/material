package com.crledu.auto.material.cooling.biz.domain;

import com.crledu.auto.material.cooling.biz.dto.AbsorbingItemDto;
import com.crledu.auto.material.impor.biz.domain.ImportDataDomain;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialImportCreateDto;
import com.crledu.auto.util.file.CSVFileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 ************************************************************
 * @Description: 辐射制冷导入业务对象，此对象不可被持久化
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/12 15:42
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class CoolingMaterailImportDataDomain extends ImportDataDomain {

    private Integer type;

    /**
     * 吸收率表格
     */
    private File abs;

    /**
     * 结构参数表格
     */
    private File structs;

    /**
     * 数据程序
     */
    private File process;

    /**
     * 奇数层材料
     */
    private String firstMaterail;

    /**
     * 偶数层材料
     */
    private String secondMaterail;

    /**
     * 入射光源
     */
    private Integer lightType;

    /**
     * 入射角
     */
    private Float lightAngle;

    /**
     * 波段
     */
    private Float maxWlength;

    /**
     * 波段
     */
    private Float minWlength;

    /**
     * 工作方式
     */
    private Integer workMode;

    private List<Float> wavelengths;

    private Integer layerIndex;
    private List<Integer> heigthIndexs;

    protected CoolingMaterailImportDataDomain(CoolingMaterialImportCreateDto importDto) {
        super(3,getForm(importDto), getFiles(importDto), importDto.getCreator(), importDto.getDataFrom(), importDto.getProcess());
        this.abs = importDto.getAbs();
        MaterailLayerDomain bottom = new MaterailLayerDomain(0,importDto.getBottomMaterail(),null,null);
        this.firstMaterail = importDto.getFirstMaterail();
        this.secondMaterail = importDto.getSecondMetarail();
        this.lightAngle = importDto.getLightAngle();
        this.lightType = importDto.getLightType();
        this.process = importDto.getProcess();
        this.structs = importDto.getLayers();
        this.workMode = importDto.getWorkingMode();
        this.type = importDto.getType();
    }

    public static CoolingMaterailImportDataDomain getInstance(CoolingMaterialImportCreateDto importDto){
        return new CoolingMaterailImportDataDomain(importDto);
    }

    private static Map<String,File> getFiles(CoolingMaterialImportCreateDto importDto){
        Map<String,File> map = new HashMap<>();
        map.put("abs",importDto.getAbs());
        map.put("structs",importDto.getLayers());
        return map;
    }

    private static Map<String,Object> getForm(CoolingMaterialImportCreateDto importDto){
        Map<String,Object> map = new HashMap<>();
        map.put("bottomMaterail",importDto.getBottomMaterail());
        map.put("firstMaterail",importDto.getFirstMaterail());
        map.put("secondMetarail",importDto.getSecondMetarail());
        map.put("lightType",importDto.getLightType());
        map.put("lightAngle",importDto.getLightAngle());
        map.put("workingMode",importDto.getWorkingMode());
        return map;
    }

    public List<CoolingMaterailDataDomain> paresImpordata(){
        List<CoolingMaterailDataDomain> result = new ArrayList<>();
        List<String[]> structsMap = CSVFileUtils.readCsv(structs);
        parseStructsHeader(structsMap.get(0));
        List<String[]> absMap = CSVFileUtils.readCsv(abs);
        parseWaveLength(absMap.get(0));
        for(int i = 1;i<structsMap.size();i++){
            result.add(buildDataDomain(structsMap.get(i),absMap.get(i)));
        }
        return result;
    }

    private void parseStructsHeader(String[] headerMap){
        this.heigthIndexs = new ArrayList<>();
        for(int j=0;j<headerMap.length - 1;j++){
            heigthIndexs.add(0);
        }
        for(int i = 0;i<headerMap.length;i++){
            if("layer".equals(headerMap[i].trim())){
                layerIndex = i;
            }else if( headerMap[i].trim().startsWith("h")){
                Integer index = Integer.getInteger(headerMap[i].substring(1));
                heigthIndexs.set(index,i);
            }
        }
    }

    private void parseWaveLength(String[] wavelegthArray){
        for(String str:wavelegthArray){
            if(str == null||str.isEmpty()){
                this.wavelengths.add(null);
            }else{
                Float wavelength = Float.valueOf(str);
                this.wavelengths.add(wavelength);
            }
        }
    }

    private CoolingMaterailDataDomain buildDataDomain(String[] stucts,String[] absors){
        //分析分层数据
        List<MaterailLayerDomain> layers = new ArrayList<>();
        Integer layer = Integer.valueOf(stucts[layerIndex]);
        Float thickness = 0f;
        for(int i = 1;i<=layer;i++){
            Float height = Float.valueOf(stucts[heigthIndexs.get(i)]);
            thickness += height;
            String mate = i%2 == 0?secondMaterail:firstMaterail;
            MaterailLayerDomain materailLayerDomain = new MaterailLayerDomain(i,mate,height,null);
            layers.add(materailLayerDomain);
        }
        List<AbsorbingItemDto> absorsList = new ArrayList<>();
        for(int j = 1;j<absors.length;j++){
            AbsorbingItemDto item = new AbsorbingItemDto();
            item.setAbsorbing(Float.valueOf(absors[j].trim()));
            item.setWaveLength(wavelengths.get(j));
            absorsList.add(item);
        }
        return CoolingMaterailDataDomain.getInstance(null,type,thickness,null,null,layers,lightType,lightAngle,workMode,absorsList,null);
    }
}
