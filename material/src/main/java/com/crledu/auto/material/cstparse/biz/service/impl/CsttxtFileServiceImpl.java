package com.crledu.auto.material.cstparse.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.crledu.auto.material.cstparse.biz.dto.CstHeaderDto;
import com.crledu.auto.material.cstparse.biz.service.BaseCsttxtFileService;
import com.crledu.auto.util.file.CSVFileUtils;
import com.crledu.auto.util.list.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 文件解析服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 14:13
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class CsttxtFileServiceImpl implements BaseCsttxtFileService {

    private final String DATA_BEGIN_KEY = "-------------------------";

    private static Logger  log = LoggerFactory.getLogger(CsttxtFileServiceImpl.class);

    @Value("${crledu.auto.file.temp}")
    private String tempPath;

    @Override
    public void decodeCsttxtFile(MultipartFile source, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = "data.csv";
        List<String[]> data = getTableStruct(source);
        String userAgent = request.getHeader("User-Agent");
        // 针对IE或者以IE为内核的浏览器：
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE浏览器的处理：
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setHeader("Content-Disposition",  String.format("attachment; filename=%s", fileName));
        response.setContentType("application/octet-stream");
        CSVFileUtils.writeDataToFile(response.getOutputStream(),data,',');
    }

    public List<String[]> getTableStruct(MultipartFile file){
        List<String[]> data = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
            //取第一行数据
            List<String> headerList = new ArrayList<>();
            List<String> firstDataList = new ArrayList<>();
            while (!br.readLine().contains(DATA_BEGIN_KEY)) {
            }
            //获得数据
            String line = null;
            while ((line = br.readLine()).length() > 4){
                line=line.trim();
                Integer position = line.indexOf(" ");
                String header = line.substring(0,position);
                String dataStr = line.substring(position).trim();
                headerList.add(header);
                firstDataList.add(dataStr);
            }
            data.add(ListUtils.stringListtoArrray(headerList));
            data.add(ListUtils.stringListtoArrray(firstDataList));
            do {
                //获取参数属性值,跳过定义行
                String firstLine = br.readLine();
                if(firstLine == null || firstLine.length() < 4){
                    break;
                }
                while (!br.readLine().contains(DATA_BEGIN_KEY)) {
                }
                List<String> dataList = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    if (line.length() < 4) {
                        break;
                    } else {
                        line=line.trim();
                        Integer position = line.indexOf(" ");
                        String dataStr = line.substring(position).trim();
                        dataList.add(dataStr);
                    }
                }
                data.add(ListUtils.stringListtoArrray(dataList));
            }while(true);
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

    public CstHeaderDto  getDataFirstRow(File file){
        CstHeaderDto cstHeaderDto = new CstHeaderDto();
        cstHeaderDto.setLines(0);
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            //获取参数属性值,跳过定义行
            while ( !br.readLine().contains(DATA_BEGIN_KEY)){
                cstHeaderDto.setLines(cstHeaderDto.getLines() + 1);
            }
            cstHeaderDto.setLines(cstHeaderDto.getLines() + 1);
            //获得数据
            String line = null;
            while ((line = br.readLine()) != null){
                if(line.length() < 4){
                    log.info("当前是分隔行："+line);
                    break;
                }else {
                    log.info("当前是数据行："+line);
                    line=line.trim();
                    Integer position = line.indexOf(" ");
                    String header = line.substring(0,position);
                    String dataStr = line.substring(position).trim();
                    cstHeaderDto.getHeader().add(header);
                    cstHeaderDto.getData().add(dataStr);
                    cstHeaderDto.setLines(cstHeaderDto.getLines() + 1);
                }
            }
            log.info("表头数据为："+ JSON.toJSONString(cstHeaderDto));
        }catch (IOException e){
            e.printStackTrace();
        }
        return cstHeaderDto;
    }
}
