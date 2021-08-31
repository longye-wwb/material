package com.crledu.auto.material.antenna.biz.service;

import com.crledu.auto.material.antenna.biz.dto.AntennaImportFormdataDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface BaseInfraredAmplitudeImportService {
    void importData(AntennaImportFormdataDto formdata, Long creator, MultipartFile struct, MultipartFile realData, MultipartFile emptyData, MultipartFile process);
    void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException;
}
