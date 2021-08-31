package com.crledu.auto.material.breath.biz.service;

import com.crledu.auto.material.breath.api.vo.BreadthInfoVo;
import com.crledu.auto.material.breath.api.vo.BreadthListVo;
import com.crledu.auto.material.breath.api.vo.BreadthSelectListVo;
import com.crledu.auto.material.breath.biz.dto.BreadthImpotDto;
import com.crledu.auto.web.response.PageDate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/2
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public interface BreadthService {
    void importBreadth(BreadthImpotDto impotDto, Long id, MultipartFile structure, MultipartFile curve, MultipartFile process);

    PageDate<BreadthListVo> selectBreadthList(BreadthSelectListVo breadthSelectListVo);

    BreadthInfoVo selectBreadthInfo(Long id);

    void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException;
}
