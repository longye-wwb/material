package com.crledu.auto.material.photon.repository.util;


import com.alibaba.excel.EasyExcel;
import com.crledu.auto.material.photon.repository.dto.PhotonImport;

import java.io.IOException;


/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/7/31
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class ExecelUtil {


    public void getExcel() throws IOException {
        String filePath="C:\\Users\\30286\\Desktop\\微波吸收材料.xlsx";
        EasyExcel.read(filePath, PhotonImport.class, new PhotonListener()).sheet().doRead();
    }


}
