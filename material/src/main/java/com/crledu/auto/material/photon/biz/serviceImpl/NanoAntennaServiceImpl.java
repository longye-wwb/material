package com.crledu.auto.material.photon.biz.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.bigdata.biz.thread.BuildDataPackage;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.photon.api.vo.*;
import com.crledu.auto.material.photon.biz.domain.NanoAntennaCircleDomain;
import com.crledu.auto.material.photon.biz.domain.NanoAntennaColumnDomain;
import com.crledu.auto.material.photon.biz.domain.NanoAntennaLayerDomain;
import com.crledu.auto.material.photon.repository.dao.*;
import com.crledu.auto.material.photon.repository.dto.*;
import com.crledu.auto.material.photon.repository.entity.*;
import com.crledu.auto.material.photon.repository.util.*;
import com.crledu.auto.material.photon.biz.service.NanoAntennaService;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.util.file.CSVFileUtils;
import com.crledu.auto.web.response.PageDate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/4
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
@Service
public class NanoAntennaServiceImpl implements NanoAntennaService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Resource
    private PhotonSkyMapper photonSkyMapper;

    @Resource
    private PhotonSkyCircleMapper skyCircleMapper;

    @Resource
    private PhotonSkyColumnMapper columnMapper;

    @Resource
    private PhotonSkyCountMapper countMapper;

    @Resource
    private PhotonSkyNewMapper photonSkyNewMapper;

    @Autowired
    private BaseImportDataService importDataService;

    @Autowired
    private BaseBigdataRepositoryService baseBigdataRepositoryService;

    @Value("${crledu.auto.file.sky-path}")
    private String skyPath;

    @Override
    public PhotonSky createPhotonSky(PhotonSkyDto photonSkyDto) {
        PhotonSky entity = new PhotonSky();
        BeanUtils.copyProperties(photonSkyDto, entity);
        photonSkyMapper.insert(entity);
        return entity;
    }

    @Override
    public void importFakeAndReal(MultipartFile fake, MultipartFile real, List<Long> list, Long photonSkyId) {
        List<Double> firstList = new ArrayList<>();
        List<List<Double>> fakeValueList = new ArrayList<>();
        List<List<Double>> realValueList = new ArrayList<>();
        BufferedReader reader = null;//换成你的文件名
        try {
            reader = new BufferedReader(new InputStreamReader(fake.getInputStream()));

            String first = reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
            String line = null;

            String[] firstArray = first.split(",");
            for (String s : firstArray) {
                Double value = Double.parseDouble(s);
                firstList.add(value);
            }
            while ((line = reader.readLine()) != null) {
                String item[] = line.split("，");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                List<Double> doubles = new ArrayList<>();
                String last = item[item.length - 1];//这就是你要的数据了
                String[] lastArray = last.split(",");
                for (String s : lastArray) {
                    Double value = Double.parseDouble(s);

                    doubles.add(value);
                }
                fakeValueList.add(doubles);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader = new BufferedReader(new InputStreamReader(real.getInputStream()));
            String line = null;

            String first = reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
            while ((line = reader.readLine()) != null) {
                String item[] = line.split("，");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                List<Double> doubles = new ArrayList<>();
                String last = item[item.length - 1];//这就是你要的数据了
                String[] lastArray = last.split(",");
                for (String s : lastArray) {
                    Double value = Double.parseDouble(s);

                    doubles.add(value);
                }
                realValueList.add(doubles);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int j = 0; j < list.size(); j++) {
            List<PhotonSkyCount> photonSkyCounts = new ArrayList<>();
            for (int i = 0; i < firstList.size(); i++) {
                PhotonSkyCount photonSkyCoun = new PhotonSkyCount();
                photonSkyCoun.setStart(firstList.get(0));
                photonSkyCoun.setEnd(firstList.get(firstList.size() - 1));
                photonSkyCoun.setFake(fakeValueList.get(j).get(i));
                photonSkyCoun.setSkyType(list.get(j));
                photonSkyCoun.setTruth(realValueList.get(j).get(i));
                photonSkyCoun.setAmplitude(DoubleUtil.div(Math.sqrt(DoubleUtil.sum(Math.pow(fakeValueList.get(j).get(i), 2), Math.pow(realValueList.get(j).get(i), 2))), 1d, 9));
                photonSkyCoun.setPhase(DoubleUtil.div(1d, Math.tan(DoubleUtil.div(fakeValueList.get(j).get(i), realValueList.get(j).get(i), 9)), 9));
                photonSkyCoun.setSkyId(photonSkyId);
                photonSkyCounts.add(photonSkyCoun);
            }
            countMapper.insertBig(photonSkyCounts);
        }


    }

    @Override
    public List<Long> importStructrue(MultipartFile structure, Long id, String type) {
        List<String> firstList = new ArrayList<>();
        List<List<Double>> valueList = new ArrayList<>();
        BufferedReader reader = null;//换成你的文件名
        try {
            reader = new BufferedReader(new InputStreamReader(structure.getInputStream()));

            String first = reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
            String line = null;

            String[] firstArray = first.split(",");
            for (String s : firstArray) {
                firstList.add(s);
            }
            while ((line = reader.readLine()) != null) {
                String item[] = line.split("，");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                List<Double> doubles = new ArrayList<>();
                String last = item[item.length - 1];//这就是你要的数据了
                String[] lastArray = last.split(",");
                for (String s : lastArray) {
                    Double value = Double.parseDouble(s);

                    doubles.add(value);
                }
                valueList.add(doubles);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Long> idList = new ArrayList<>();
        List<PhotonSkyCircle> circles = new ArrayList<>();
        if (firstList.size() == 4) {
            for (List<Double> list : valueList) {
                PhotonSkyCircle photonSkyCircle = new PhotonSkyCircle();
                for (int i = 0; i < firstList.size(); i++) {
                    if (firstList.get(i).equals("h")) {
                        photonSkyCircle.setH(list.get(i));
                    }
                    if (firstList.get(i).equals("p")) {
                        photonSkyCircle.setP(list.get(i));
                    }
                    if (firstList.get(i).equals("minH")) {
                        photonSkyCircle.setMinH(list.get(i));
                    }
                    if (firstList.get(i).equals("r")) {
                        photonSkyCircle.setR(list.get(i));
                    }
                }
                photonSkyCircle.setSkyId(id);
                circles.add(photonSkyCircle);
            }
            skyCircleMapper.insertBig(circles);
            idList = skyCircleMapper.selectIdList(id);
        } else {
            List<PhotonSkyColumn> columns = new ArrayList<>();
            for (List<Double> list : valueList) {
                PhotonSkyColumn photonSkyColumn = new PhotonSkyColumn();
                for (int i = 0; i < firstList.size(); i++) {
                    if (firstList.get(i).equals("h")) {
                        photonSkyColumn.setH(list.get(i));
                    }
                    if (firstList.get(i).equals("p")) {
                        photonSkyColumn.setP(list.get(i));
                    }
                    if (firstList.get(i).equals("minH")) {
                        photonSkyColumn.setMinH(list.get(i));
                    }
                    if (firstList.get(i).equals("x")) {
                        photonSkyColumn.setX(list.get(i));
                    }
                    if (firstList.get(i).equals("y")) {
                        photonSkyColumn.setY(list.get(i));
                    }
                    if (firstList.get(i).equals("angle")) {
                        photonSkyColumn.setAngle(list.get(i));
                    }
                }
                photonSkyColumn.setSkyId(id);
                columns.add(photonSkyColumn);
                columnMapper.insertBig(columns);
            }

            idList = columnMapper.selectIdList(id);

        }
        return idList;
    }

    @Override
    public PageDate<PhotonSkyVo> selectSkyList(PhotonSkySelection photonSkySelection) {

        List<PhotonSkyVo> photonSkyVos = photonSkyMapper.selectList(photonSkySelection);
        Long rows = photonSkyMapper.selectRows(photonSkySelection);
        PageDate pageDate = new PageDate();
        pageDate.setRows(photonSkyVos);
        pageDate.setPageSize(photonSkySelection.getPageSize());
        pageDate.setPageNum(photonSkySelection.getPageNum());
        pageDate.setTotal(rows);
        return pageDate;
    }

    @Override
    public List<NanoAntennaCircleVo> selectCircleList(PhotonSkySelection photonSkySelection) {

        return photonSkyMapper.selectCircleList(photonSkySelection);
    }

    @Override
    public List<NanoAntennaColumnVo> selectColumnList(PhotonSkySelection photonSkySelection) {
        return photonSkyMapper.selectColumnList(photonSkySelection);
    }


    @Override
    public PageDate<PhotonSkyVoNew> selectSkyListNew(PhotonSkySelectionNew photonSkySelectionNew) {
        List<PhotonSkyVoNew> photonSkyVoNews = photonSkyNewMapper.selectResults(photonSkySelectionNew);
        PageDate<PhotonSkyVoNew> pageDate = new PageDate<>();
        pageDate.setRows(photonSkyVoNews);
        pageDate.setPageSize(photonSkySelectionNew.getPageSize());
        pageDate.setPageNum(photonSkySelectionNew.getPageNum());
        pageDate.setTotal(photonSkyNewMapper.selectTotal(photonSkySelectionNew));
        return pageDate;
    }

    @Override
    public List<PhotonSkyMapVo> selectSkyListMap(PhotonSkySelectionMap skySelectionMap) {
        //拿到结构参数id,波段，相位段，振幅段
        Long id = skySelectionMap.getId();
        Double startWave = skySelectionMap.getStartWave();
        Double endWave = skySelectionMap.getEndWave();
        Double startAmplitude = skySelectionMap.getStartAmplitude();
        Double endAmplitude = skySelectionMap.getEndAmplitude();
        Double startPhase = skySelectionMap.getStartPhase();
        Double endPhase = skySelectionMap.getEndPhase();

        //找到文件路径
        String filePath = skyPath + File.separator + id / 1001 + File.separator + id;
        //读取文件到内存

        File file = new File(filePath);
        BufferedReader reader = null;
        StringBuffer s = new StringBuffer();
        try {
            // 一次读一个字符
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                } else {
                    s.append(line);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String json = s.toString();
        List<PhotonSkyMapVo> photonSkyMapVos = JSONArray.parseArray(json, PhotonSkyMapVo.class);
        //根据频率的值进行排序
        QuikSortUtil.quickSort(photonSkyMapVos, 0, photonSkyMapVos.size() - 1);
        //将数据分为三部分。波段左端
        //List<PhotonSkyMapVo> left = new ArrayList<>();
        //波段内
        List<PhotonSkyMapVo> middle = new ArrayList<>();
        //波段右端
        //List<PhotonSkyMapVo> right = new ArrayList<>();
        //波段两端
        //List<PhotonSkyMapVo> startEnd= new ArrayList<>();
        //没有相位与振幅的搜索条件，筛选不成立
        Integer size = 0;
        if (startPhase == null && endPhase == null && startAmplitude == null && endAmplitude == null) {
            return photonSkyMapVos;
        }//只传入开始相位
        else if (startPhase != null && endPhase == null && startAmplitude == null && endAmplitude == null) {

            //波段不为空
            if (startWave != null && endWave != null) {
                for (PhotonSkyMapVo vo : photonSkyMapVos) {
                    if (vo.getWaveLength().compareTo(startWave) > 0 && vo.getWaveLength().compareTo(endWave) < 0) {
                        middle.add(vo);
                    }
                }
                for (PhotonSkyMapVo mapVo : middle) {
                    if (mapVo.getPhase().compareTo(startPhase) > 0) {
                        size++;
                    } else {
                        return null;
                    }
                }
            } else {
                return photonSkyMapVos;
            }
        }
        //只传入结束相位
        else if (endPhase != null && startPhase == null && startAmplitude == null && endAmplitude == null) {
            if (startWave != null && endWave != null) {
                for (PhotonSkyMapVo vo : photonSkyMapVos) {
                    if (vo.getWaveLength().compareTo(startWave) > 0 && vo.getWaveLength().compareTo(endWave) < 0) {
                        middle.add(vo);
                    }
                }
                for (PhotonSkyMapVo mapVo : middle) {
                    if (mapVo.getPhase().compareTo(endPhase) < 0) {
                        size++;
                    } else {
                        return null;
                    }
                }
            } else {
                return photonSkyMapVos;
            }
        }
        //只传入开始结束相位
        else if (startPhase != null && endPhase != null && startAmplitude == null && endAmplitude == null) {
            if (startWave != null && endWave != null) {
                for (PhotonSkyMapVo vo : photonSkyMapVos) {
                    if (vo.getWaveLength().compareTo(startWave) > 0 && vo.getWaveLength().compareTo(endWave) < 0) {
                        middle.add(vo);
                    }
                }
                for (PhotonSkyMapVo mapVo : middle) {
                    if (mapVo.getPhase().compareTo(startPhase) > 0 && mapVo.getPhase().compareTo(endPhase) < 0) {
                        size++;
                    } else {
                        return null;
                    }
                }
            } else {
                return photonSkyMapVos;
            }
        } else if (startAmplitude != null && endAmplitude == null && startPhase == null && endPhase == null) {
            if (startWave != null && endWave != null) {
                for (PhotonSkyMapVo vo : photonSkyMapVos) {
                    if (vo.getWaveLength().compareTo(startWave) > 0 && vo.getWaveLength().compareTo(endWave) < 0) {
                        middle.add(vo);
                    }
                }
                for (PhotonSkyMapVo mapVo : middle) {
                    if (mapVo.getAmplitude().compareTo(startAmplitude) > 0) {
                        size++;
                    } else {
                        return null;
                    }
                }
            } else {
                return photonSkyMapVos;
            }
        } else if (startAmplitude == null && endAmplitude != null && startPhase == null && endPhase == null) {
            if (startWave != null && endWave != null) {
                for (PhotonSkyMapVo vo : photonSkyMapVos) {
                    if (vo.getWaveLength().compareTo(startWave) > 0 && vo.getWaveLength().compareTo(endWave) < 0) {
                        middle.add(vo);
                    }
                }
                for (PhotonSkyMapVo mapVo : middle) {
                    if (mapVo.getAmplitude().compareTo(endAmplitude) < 0) {
                        size++;
                    } else {
                        return null;
                    }
                }
            } else {
                return photonSkyMapVos;
            }
        } else if (startAmplitude != null && endAmplitude != null && startPhase == null && endPhase == null) {
            if (startWave != null && endWave != null) {
                for (PhotonSkyMapVo vo : photonSkyMapVos) {
                    if (vo.getWaveLength().compareTo(startWave) > 0 && vo.getWaveLength().compareTo(endWave) < 0) {
                        middle.add(vo);
                    }
                }
                for (PhotonSkyMapVo mapVo : middle) {
                    if (mapVo.getAmplitude().compareTo(startAmplitude) > 0 && mapVo.getAmplitude().compareTo(endAmplitude) < 0) {
                        size++;
                    } else {
                        return null;
                    }
                }
            } else {
                return photonSkyMapVos;
            }
        } else {
            if (startWave != null && endWave != null) {
                for (PhotonSkyMapVo vo : photonSkyMapVos) {
                    if (vo.getWaveLength().compareTo(startWave) > 0 && vo.getWaveLength().compareTo(endWave) < 0) {
                        middle.add(vo);
                    }
                }
                for (PhotonSkyMapVo mapVo : middle) {
                    if (mapVo.getPhase().compareTo(startPhase) > 0 && mapVo.getPhase().compareTo(endPhase) < 0 && mapVo.getAmplitude().compareTo(startAmplitude) > 0 && mapVo.getAmplitude().compareTo(endAmplitude) < 0) {
                        size++;
                    } else {
                        return null;
                    }
                }
            } else {
                return photonSkyMapVos;
            }

        }
        if (size == middle.size()) {
            return photonSkyMapVos;
        } else {

            return null;
        }
    }

    @Override
    public void createPhotonSkyNew(PhotonSkyDto photonSkyDto, MultipartFile structure, MultipartFile fake, MultipartFile real) {
        //存在三个运行的线程
        final CountDownLatch latch = new CountDownLatch(3);
        //创建线程池
        BlockingQueue<Runnable> bq = new ArrayBlockingQueue<Runnable>(10);
        // ThreadPoolExecutor:创建自定义线程池，池中保存的线程数为3，允许最大的线程数为6
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(3, 6, 50, TimeUnit.MILLISECONDS, bq);
        //开启线程
        MyThread myThread = new MyThread(fake, latch);
        MyThread2 myThread2 = new MyThread2(structure, latch);
        MyThread3 myThread3 = new MyThread3(real, latch);
        tpe.execute(myThread);
        tpe.execute(myThread2);
        tpe.execute(myThread3);
        try {
            //保证线程必须将csv完全解析成功，主线程进行等待。让子线程准备好数据
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //拿到线程的结果
        List<Double> firstList2 = myThread.getFirstList2();
        List<List<Double>> fakeValueList = myThread.getFakeValueList();
        List<List<Double>> realValueList = myThread3.getRealValueList();
        List<String> firstList = myThread2.getFirstList();
        List<List<Double>> valueList = myThread2.getValueList();
        //查询数据库的最大id值

        Integer maxId = photonSkyNewMapper.selectMaxId();
        //解析csv结束
        if (myThread.isWorkDone() && myThread2.isWorkDone() && myThread3.isWorkDone()) {
            List<PhotonSkyNew> skyNews = new ArrayList<>();
            for (int j = 0; j < valueList.size(); j++) {
                PhotonSkyNew skyNew = new PhotonSkyNew();
                BeanUtils.copyProperties(photonSkyDto, skyNew);
                for (int i = 0; i < firstList.size(); i++) {
                    if (firstList.get(i).equals("h")) {
                        skyNew.setH(valueList.get(j).get(i));
                    }
                    if (firstList.get(i).equals("p")) {
                        skyNew.setP(valueList.get(j).get(i));
                    }
                    if (firstList.get(i).equals("minH")) {
                        skyNew.setMinH(valueList.get(j).get(i));
                    }
                    if (firstList.get(i).equals("r")) {
                        skyNew.setR(valueList.get(j).get(i));
                    }
                    if (firstList.get(i).equals("x")) {
                        skyNew.setX(valueList.get(j).get(i));
                    }
                    if (firstList.get(i).equals("y")) {
                        skyNew.setY(valueList.get(j).get(i));
                    }
                    if (firstList.get(i).equals("angle")) {
                        skyNew.setAngle(valueList.get(j).get(i));
                    }
                    skyNew.setId(Long.valueOf(maxId + j + 1));
                    skyNew.setEndL(DoubleUtil.div(300000d, firstList2.get(0), 4));
                    skyNew.setStartL(DoubleUtil.div(300000d, firstList2.get(firstList2.size() - 1), 4));
                }
                skyNews.add(skyNew);
            }
            photonSkyNewMapper.insertBig(skyNews);
            //拿到本次导入数据的数据库id
            List<Long> idList = new ArrayList<>();
            for (PhotonSkyNew photonSkyNew : skyNews) {
                idList.add(photonSkyNew.getId());
            }
            //2.拿到结构参数的数据库主键id
            //获得实部虚部数据


            //生成文件夹路径
            //为保证一个文件夹有1000个文件，所以一次导入不足的进行叠加进文件夹
            System.out.println("文件开始" + new Date());
            //分为两个线程进行创建文件
            int size = idList.size();
            //分为2
            int cut = size / 2;
            int start1 = 0;
            int end1 = cut;
            int start2 = cut;
            int end2 = size;
            MyThread4 myThread4 = new MyThread4(firstList2, fakeValueList, realValueList, skyPath, idList, start1, end1, latch);
            MyThread4 myThread5 = new MyThread4(firstList2, fakeValueList, realValueList, skyPath, idList, start2, end2, latch);
            //分段创建文件
            tpe.execute(myThread4);
            tpe.execute(myThread5);
            try {
                //保证线程必须将csv完全解析成功
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件结束" + new Date());
    }

    @Override
    public List<PhotonSkyMapVo> selectSkyListMapNew(SelectionMapNew selectionMapNew) {
        //拿到结构参数id,频率段
        Long id = selectionMapNew.getId();
        Double start = selectionMapNew.getStart();
        Double end = selectionMapNew.getEnd();

        PhotonSkyNew entity = photonSkyNewMapper.selectById(id);
        //找到文件路径
        String filePath = entity.getFileUrl();
        //读取文件到内存

        File file = new File(filePath);
        Reader reader = null;
        StringBuffer s = new StringBuffer();
        NanoAntennaCircleDto circleDto = new NanoAntennaCircleDto();
        NanoAntennaColumnDto columnDto = new NanoAntennaColumnDto();
        List<PhotonSkyMapVo> photonSkyMapVos = new ArrayList<>();
        try {
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    s.append((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String json = s.toString();
        if (entity.getR() != null) {
            circleDto = JSON.parseObject(json, NanoAntennaCircleDto.class);
            List<NanoAntennaLayerDto> layerDtos = circleDto.getLayerDtos();
            for (NanoAntennaLayerDto layerDto : layerDtos) {
                PhotonSkyMapVo photonSkyMapVo = new PhotonSkyMapVo();
                photonSkyMapVo.setAmplitude(layerDto.getAmplitude());
                photonSkyMapVo.setEnd(circleDto.getEndFrequncy());
                photonSkyMapVo.setFake(layerDto.getFake());
                photonSkyMapVo.setFrequency(layerDto.getFrequncy());
                photonSkyMapVo.setPhase(layerDto.getPhase());
                photonSkyMapVo.setStart(circleDto.getStartFrequncy());
                photonSkyMapVo.setTruth(layerDto.getTruth());
                photonSkyMapVo.setWaveLength(layerDto.getWaveLength());
                photonSkyMapVos.add(photonSkyMapVo);
            }

        } else {
            columnDto = JSON.parseObject(json, NanoAntennaColumnDto.class);
            List<NanoAntennaLayerDto> layerDtos = columnDto.getLayerDtos();
            for (NanoAntennaLayerDto layerDto : layerDtos) {
                PhotonSkyMapVo photonSkyMapVo = new PhotonSkyMapVo();
                photonSkyMapVo.setAmplitude(layerDto.getAmplitude());
                photonSkyMapVo.setEnd(circleDto.getEndFrequncy());
                photonSkyMapVo.setFake(layerDto.getFake());
                photonSkyMapVo.setFrequency(layerDto.getFrequncy());
                photonSkyMapVo.setPhase(layerDto.getPhase());
                photonSkyMapVo.setStart(circleDto.getStartFrequncy());
                photonSkyMapVo.setTruth(layerDto.getTruth());
                photonSkyMapVo.setWaveLength(layerDto.getWaveLength());
                photonSkyMapVos.add(photonSkyMapVo);
            }
        }
        //根据频率的值进行排序
        QuikSortUtil.quickSort(photonSkyMapVos, 0, photonSkyMapVos.size() - 1);
        return photonSkyMapVos;
    }

    @Override
    public void createNanoAntennaNew(NanoAntennaCreateVo createVo, Long id, MultipartFile structure, MultipartFile fake, MultipartFile real, MultipartFile process) {
        ImportDataCreateDto importDto = new ImportDataCreateDto();
        importDto.setCreator(id);
        importDto.setType(2);
        Map<String, Object> formMap = new HashMap<>();
        formMap.put("topType", createVo.getTopType());
        formMap.put("topConstant", createVo.getTopConstant());
        formMap.put("downType", createVo.getDownType());
        formMap.put("downConstant", createVo.getDownConstant());
        formMap.put("file", createVo.getFile());
        formMap.put("lightAngle", createVo.getLightAngle());
        formMap.put("lightType", createVo.getLightType());
        formMap.put("source", createVo.getSource());
        formMap.put("workType", createVo.getWorkType());
        importDto.setForm(formMap);
        importDto.setDataFrom(createVo.getSource());
        importDto.setProcess(process);
        Map<String, MultipartFile> fileMap = new HashMap<>();
        //放入结构参数文件
        fileMap.put("structure", structure);
        //放入虚部文件
        fileMap.put("fake", fake);
        //放入实部文件
        fileMap.put("real", real);
        importDto.setFiles(fileMap);
        ImportDataItemDto importDataItemDto = importDataService.saveInHistory(importDto, DataTypeEnum.NANO_ANTENNA);
        emptyTable();
        //取出并解析结构参数文件
        List<String[]> structureData = CSVFileUtils.readCsv(importDataItemDto.getFiles().get("structure"));
        List<String[]> fakeData = CSVFileUtils.readCsv(importDataItemDto.getFiles().get("fake"));
        List<String[]> truthData = CSVFileUtils.readCsv(importDataItemDto.getFiles().get("real"));
        //结构参数列表
        String[] title = structureData.get(0);
        String[] fakeTitle = fakeData.get(0);
        List<PhotonSkyNew> skyNews = new ArrayList<>();

        if (title.length == 4) {
                for (int j = 1; j < structureData.size(); j++) {
                    Double h = 0d;
                    Double p = 0d;
                    Double minH = 0d;
                    Double r = 0d;
                    for (int i = 0; i < title.length; i++) {

                        if (title[i].equals("h")) {
                            h = Double.valueOf(structureData.get(j)[i]);
                        }
                        if (title[i].equals("p")) {
                            p = Double.valueOf(structureData.get(j)[i]);
                        }
                        if (title[i].equals("minH")) {
                            minH = Double.valueOf(structureData.get(j)[i]);
                        }
                        if (title[i].equals("r")) {
                            r = Double.valueOf(structureData.get(j)[i]);
                        }
                    }
                    //实部虚部计算数据
                    List<NanoAntennaLayerDomain> layerDomains = new ArrayList<>();
                    for (int b = 0; b < fakeTitle.length; b++) {
                        NanoAntennaLayerDomain nanoAntennaLayerDomain = NanoAntennaLayerDomain.getInstance(Double.valueOf(fakeData.get(j)[b]), Double.valueOf(truthData.get(j)[b]), Double.valueOf(fakeTitle[b]));
                        layerDomains.add(nanoAntennaLayerDomain);
                    }
                    NanoAntennaCircleDomain circleDomain = NanoAntennaCircleDomain.getInstance(createVo.getTopType(), createVo.getTopConstant(), createVo.getDownType(), createVo.getDownConstant(),
                            createVo.getLightType(), createVo.getSource(), createVo.getWorkType(), r, h, p, minH, Double.valueOf(fakeTitle[0]), Double.valueOf(fakeTitle[fakeTitle.length - 1]), layerDomains);
                    PhotonSkyNew skyNew = new PhotonSkyNew();
                    BeanUtils.copyProperties(circleDomain, skyNew);
                    NanoAntennaCircleDto circleDto = new NanoAntennaCircleDto();
                    BeanUtils.copyProperties(circleDomain, circleDto);
                    List<NanoAntennaLayerDomain> domains = circleDomain.getLayerDomains();
                    List<NanoAntennaLayerDto> layerDtos = new ArrayList<>();
                    for (NanoAntennaLayerDomain domain : domains) {
                        NanoAntennaLayerDto layerDto = new NanoAntennaLayerDto();
                        BeanUtils.copyProperties(domain, layerDto);
                        layerDtos.add(layerDto);
                    }
                    circleDto.setLayerDtos(layerDtos);
                    String s = baseBigdataRepositoryService.saveData(circleDto, importDataItemDto.getId());
                    skyNew.setFileUrl(s);
                    skyNew.setImportId(importDataItemDto.getId());
                    skyNews.add(skyNew);
                    photonSkyNewMapper.insert(skyNew);
                }
        }else{
                for (int j = 1; j < structureData.size(); j++) {
                    Double h = 0d;
                    Double p = 0d;
                    Double minH = 0d;
                    Double x = 0d;
                    Double y = 0d;
                    Double angle = 0d;
                    for (int i = 0; i < title.length; i++) {
                        if (title[i].equals("h")) {
                            h = Double.valueOf(structureData.get(j)[i]);
                        }
                        if (title[i].equals("p")) {
                            p = Double.valueOf(structureData.get(j)[i]);
                        }
                        if (title[i].equals("minH")) {
                            minH = Double.valueOf(structureData.get(j)[i]);
                        }
                        if (title[i].equals("x")) {
                            x = Double.valueOf(structureData.get(j)[i]);
                        }
                        if (title[i].equals("y")) {
                            y = Double.valueOf(structureData.get(j)[i]);
                        }
                        if (title[i].equals("angle")) {
                            angle = Double.valueOf(structureData.get(j)[i]);
                        }
                    }
                    List<NanoAntennaLayerDomain> layerDomains = new ArrayList<>();
                    for (int b = 0; b < fakeTitle.length; b++) {
                        NanoAntennaLayerDomain nanoAntennaLayerDomain = NanoAntennaLayerDomain.getInstance(Double.valueOf(fakeData.get(j)[b]), Double.valueOf(truthData.get(j)[b]), Double.valueOf(fakeTitle[b]));
                        layerDomains.add(nanoAntennaLayerDomain);
                    }
                    NanoAntennaColumnDomain columnDomain = NanoAntennaColumnDomain.getInstance(createVo.getTopType(), createVo.getTopConstant(), createVo.getDownType(), createVo.getDownConstant(),
                            createVo.getLightType(), createVo.getSource(), createVo.getWorkType(), x, y, angle, h, p, minH, Double.valueOf(fakeTitle[0]), Double.valueOf(fakeTitle[fakeTitle.length - 1]), layerDomains);
                    PhotonSkyNew skyNew = new PhotonSkyNew();
                    BeanUtils.copyProperties(columnDomain, skyNew);
                    NanoAntennaColumnDto columnDto = new NanoAntennaColumnDto();
                    BeanUtils.copyProperties(columnDomain, columnDto);
                    List<NanoAntennaLayerDomain> domains = columnDomain.getLayerDomains();
                    List<NanoAntennaLayerDto> layerDtos = new ArrayList<>();
                    for (NanoAntennaLayerDomain domain : domains) {
                        NanoAntennaLayerDto layerDto = new NanoAntennaLayerDto();
                        BeanUtils.copyProperties(domain, layerDto);
                        layerDtos.add(layerDto);
                    }
                    String s = baseBigdataRepositoryService.saveData(columnDto, importDataItemDto.getId());
                    skyNew.setFileUrl(s);
                    skyNews.add(skyNew);
                    photonSkyNewMapper.insert(skyNew);
                }
            }
        BuildDataPackage buildPackage = new BuildDataPackage(importDataItemDto.getId(),basePath);
        buildPackage.start();
        }

    private void emptyTable(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.isNotNull("id");
        photonSkyNewMapper.delete(queryWrapper);
    }

    @Override
    public void saveNanoAntennaNew(NanoAntennaCreateVo createVo, Long id, MultipartFile structure, MultipartFile fake, MultipartFile real, MultipartFile process) {
        ImportDataCreateDto importDto = new ImportDataCreateDto();
        importDto.setCreator(id);
        importDto.setType(2);
        Map<String, Object> formMap = new HashMap<>();
        formMap.put("topType", createVo.getTopType());
        formMap.put("topConstant", createVo.getTopConstant());
        formMap.put("downType", createVo.getDownType());
        formMap.put("downConstant", createVo.getDownConstant());
        formMap.put("file", createVo.getFile());
        formMap.put("lightAngle", createVo.getLightAngle());
        formMap.put("lightType", createVo.getLightType());
        formMap.put("source", createVo.getSource());
        formMap.put("workType", createVo.getWorkType());
        importDto.setForm(formMap);
        importDto.setDataFrom(createVo.getSource());
        importDto.setProcess(process);
        Map<String, MultipartFile> fileMap = new HashMap<>();
        //放入结构参数文件
        fileMap.put("structure", structure);
        //放入虚部文件
        fileMap.put("fake", fake);
        //放入实部文件
        fileMap.put("real", real);
        importDto.setFiles(fileMap);
        ImportDataItemDto importDataItemDto = importDataService.saveInHistory(importDto, DataTypeEnum.NANO_ANTENNA);
        //取出并解析结构参数文件
        List<String[]> structureData = CSVFileUtils.readCsv(importDataItemDto.getFiles().get("structure"));
        List<String[]> fakeData = CSVFileUtils.readCsv(importDataItemDto.getFiles().get("fake"));
        List<String[]> truthData = CSVFileUtils.readCsv(importDataItemDto.getFiles().get("real"));
        //结构参数列表
        String[] title = structureData.get(0);
        String[] fakeTitle = fakeData.get(0);
        List<PhotonSkyNew> skyNews = new ArrayList<>();

        if (title.length == 4) {
            for (int j = 1; j < structureData.size(); j++) {
                Double h = 0d;
                Double p = 0d;
                Double minH = 0d;
                Double r = 0d;
                for (int i = 0; i < title.length; i++) {

                    if (title[i].equals("h")) {
                        h = Double.valueOf(structureData.get(j)[i]);
                    }
                    if (title[i].equals("p")) {
                        p = Double.valueOf(structureData.get(j)[i]);
                    }
                    if (title[i].equals("minH")) {
                        minH = Double.valueOf(structureData.get(j)[i]);
                    }
                    if (title[i].equals("r")) {
                        r = Double.valueOf(structureData.get(j)[i]);
                    }
                }
                //实部虚部计算数据
                List<NanoAntennaLayerDomain> layerDomains = new ArrayList<>();
                for (int b = 0; b < fakeTitle.length; b++) {
                    NanoAntennaLayerDomain nanoAntennaLayerDomain = NanoAntennaLayerDomain.getInstance(Double.valueOf(fakeData.get(j)[b]), Double.valueOf(truthData.get(j)[b]), Double.valueOf(fakeTitle[b]));
                    layerDomains.add(nanoAntennaLayerDomain);
                }
                NanoAntennaCircleDomain circleDomain = NanoAntennaCircleDomain.getInstance(createVo.getTopType(), createVo.getTopConstant(), createVo.getDownType(), createVo.getDownConstant(),
                        createVo.getLightType(), createVo.getSource(), createVo.getWorkType(), r, h, p, minH, Double.valueOf(fakeTitle[0]), Double.valueOf(fakeTitle[fakeTitle.length - 1]), layerDomains);
                PhotonSkyNew skyNew = new PhotonSkyNew();
                BeanUtils.copyProperties(circleDomain, skyNew);
                NanoAntennaCircleDto circleDto = new NanoAntennaCircleDto();
                BeanUtils.copyProperties(circleDomain, circleDto);
                List<NanoAntennaLayerDomain> domains = circleDomain.getLayerDomains();
                List<NanoAntennaLayerDto> layerDtos = new ArrayList<>();
                for (NanoAntennaLayerDomain domain : domains) {
                    NanoAntennaLayerDto layerDto = new NanoAntennaLayerDto();
                    BeanUtils.copyProperties(domain, layerDto);
                    layerDtos.add(layerDto);
                }
                circleDto.setLayerDtos(layerDtos);
                String s = baseBigdataRepositoryService.saveData(circleDto, importDataItemDto.getId());
//                skyNew.setFileUrl(s);
//                skyNews.add(skyNew);
//                photonSkyNewMapper.insert(skyNew);
            }
        }else{
            for (int j = 1; j < structureData.size(); j++) {
                Double h = 0d;
                Double p = 0d;
                Double minH = 0d;
                Double x = 0d;
                Double y = 0d;
                Double angle = 0d;
                for (int i = 0; i < title.length; i++) {
                    if (title[i].equals("h")) {
                        h = Double.valueOf(structureData.get(j)[i]);
                    }
                    if (title[i].equals("p")) {
                        p = Double.valueOf(structureData.get(j)[i]);
                    }
                    if (title[i].equals("minH")) {
                        minH = Double.valueOf(structureData.get(j)[i]);
                    }
                    if (title[i].equals("x")) {
                        x = Double.valueOf(structureData.get(j)[i]);
                    }
                    if (title[i].equals("y")) {
                        y = Double.valueOf(structureData.get(j)[i]);
                    }
                    if (title[i].equals("angle")) {
                        angle = Double.valueOf(structureData.get(j)[i]);
                    }
                }
                List<NanoAntennaLayerDomain> layerDomains = new ArrayList<>();
                for (int b = 0; b < fakeTitle.length; b++) {
                    NanoAntennaLayerDomain nanoAntennaLayerDomain = NanoAntennaLayerDomain.getInstance(Double.valueOf(fakeData.get(j)[b]), Double.valueOf(truthData.get(j)[b]), Double.valueOf(fakeTitle[b]));
                    layerDomains.add(nanoAntennaLayerDomain);
                }
                NanoAntennaColumnDomain columnDomain = NanoAntennaColumnDomain.getInstance(createVo.getTopType(), createVo.getTopConstant(), createVo.getDownType(), createVo.getDownConstant(),
                        createVo.getLightType(), createVo.getSource(), createVo.getWorkType(), x, y, angle, h, p, minH, Double.valueOf(fakeTitle[0]), Double.valueOf(fakeTitle[fakeTitle.length - 1]), layerDomains);
                PhotonSkyNew skyNew = new PhotonSkyNew();
                BeanUtils.copyProperties(columnDomain, skyNew);
                NanoAntennaColumnDto columnDto = new NanoAntennaColumnDto();
                BeanUtils.copyProperties(columnDomain, columnDto);
                List<NanoAntennaLayerDomain> domains = columnDomain.getLayerDomains();
                List<NanoAntennaLayerDto> layerDtos = new ArrayList<>();
                for (NanoAntennaLayerDomain domain : domains) {
                    NanoAntennaLayerDto layerDto = new NanoAntennaLayerDto();
                    BeanUtils.copyProperties(domain, layerDto);
                    layerDtos.add(layerDto);
                }
                String s = baseBigdataRepositoryService.saveData(columnDto, importDataItemDto.getId());
//                skyNew.setFileUrl(s);
//                skyNews.add(skyNew);
//                photonSkyNewMapper.insert(skyNew);
            }
        }
        BuildDataPackage buildPackage = new BuildDataPackage(importDataItemDto.getId(),basePath);
        buildPackage.start();
    }

    @Override
        public List<PhotonSkyMapVo> selectNanoAntenna (PhotonSkySelectionMap selectionMapNew){

            //拿到结构参数id,波段，相位段，振幅段
            Long id = selectionMapNew.getId();
            Double startWave = selectionMapNew.getStartWave();
            Double endWave = selectionMapNew.getEndWave();
            Double startAmplitude = selectionMapNew.getStartAmplitude();
            Double endAmplitude = selectionMapNew.getEndAmplitude();
            Double startPhase = selectionMapNew.getStartPhase();
            Double endPhase = selectionMapNew.getEndPhase();

            PhotonSkyNew entity = photonSkyNewMapper.selectById(id);
            NanoAntennaCircleDto circleDto = new NanoAntennaCircleDto();
            NanoAntennaColumnDto columnDto = new NanoAntennaColumnDto();
            List<PhotonSkyMapVo> photonSkyMapVos = new ArrayList<>();
            if (entity != null) {
                File dataFile = new File(entity.getFileUrl());
                try {
                    String text = "";
                    BufferedReader reader = new BufferedReader(new FileReader(dataFile));
                    String buffer = null;
                    while ((buffer = reader.readLine()) != null) {
                        text += buffer;
                    }
                    if (entity.getR() != null) {
                        circleDto = JSON.parseObject(text, NanoAntennaCircleDto.class);
                        List<NanoAntennaLayerDto> layerDtos = circleDto.getLayerDtos();
                        for (NanoAntennaLayerDto layerDto : layerDtos) {
                            PhotonSkyMapVo photonSkyMapVo = new PhotonSkyMapVo();
                            photonSkyMapVo.setAmplitude(layerDto.getAmplitude());
                            photonSkyMapVo.setEnd(circleDto.getEndFrequncy());
                            photonSkyMapVo.setFake(layerDto.getFake());
                            photonSkyMapVo.setFrequency(layerDto.getFrequncy());
                            photonSkyMapVo.setPhase(layerDto.getPhase());
                            photonSkyMapVo.setStart(circleDto.getStartFrequncy());
                            photonSkyMapVo.setTruth(layerDto.getTruth());
                            photonSkyMapVo.setWaveLength(layerDto.getWaveLength());
                            photonSkyMapVos.add(photonSkyMapVo);
                        }

                    } else {
                        columnDto = JSON.parseObject(text, NanoAntennaColumnDto.class);
                        List<NanoAntennaLayerDto> layerDtos = columnDto.getLayerDtos();
                        for (NanoAntennaLayerDto layerDto : layerDtos) {
                            PhotonSkyMapVo photonSkyMapVo = new PhotonSkyMapVo();
                            photonSkyMapVo.setAmplitude(layerDto.getAmplitude());
                            photonSkyMapVo.setEnd(circleDto.getEndFrequncy());
                            photonSkyMapVo.setFake(layerDto.getFake());
                            photonSkyMapVo.setFrequency(layerDto.getFrequncy());
                            photonSkyMapVo.setPhase(layerDto.getPhase());
                            photonSkyMapVo.setStart(circleDto.getStartFrequncy());
                            photonSkyMapVo.setTruth(layerDto.getTruth());
                            photonSkyMapVo.setWaveLength(layerDto.getWaveLength());
                            photonSkyMapVos.add(photonSkyMapVo);
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //根据频率的值进行排序
            QuikSortUtil.quickSort(photonSkyMapVos, 0, photonSkyMapVos.size() - 1);
            //将数据分为三部分。波段左端
            //List<PhotonSkyMapVo> left = new ArrayList<>();
            //波段内
            List<PhotonSkyMapVo> middle = new ArrayList<>();
            //波段右端
            //List<PhotonSkyMapVo> right = new ArrayList<>();
            //波段两端
            //List<PhotonSkyMapVo> startEnd= new ArrayList<>();
            //没有相位与振幅的搜索条件，筛选不成立
            Integer size = 0;
            if (startPhase == null && endPhase == null && startAmplitude == null && endAmplitude == null) {
                return photonSkyMapVos;
            }//只传入开始相位
            else if (startPhase != null && endPhase == null && startAmplitude == null && endAmplitude == null) {

                //波段不为空
                if (startWave != null && endWave != null) {
                    for (PhotonSkyMapVo vo : photonSkyMapVos) {
                        if (vo.getWaveLength().compareTo(startWave) > 0 && vo.getWaveLength().compareTo(endWave) < 0) {
                            middle.add(vo);
                        }
                    }
                    for (PhotonSkyMapVo mapVo : middle) {
                        if (mapVo.getPhase().compareTo(startPhase) > 0) {
                            size++;
                        } else {
                            return null;
                        }
                    }
                } else {
                    return photonSkyMapVos;
                }
            }
            //只传入结束相位
            else if (endPhase != null && startPhase == null && startAmplitude == null && endAmplitude == null) {
                if (startWave != null && endWave != null) {
                    for (PhotonSkyMapVo vo : photonSkyMapVos) {
                        if (vo.getWaveLength().compareTo(startWave) > 0 && vo.getWaveLength().compareTo(endWave) < 0) {
                            middle.add(vo);
                        }
                    }
                    for (PhotonSkyMapVo mapVo : middle) {
                        if (mapVo.getPhase().compareTo(endPhase) < 0) {
                            size++;
                        } else {
                            return null;
                        }
                    }
                } else {
                    return photonSkyMapVos;
                }
            }
            //只传入开始结束相位
            else if (startPhase != null && endPhase != null && startAmplitude == null && endAmplitude == null) {
                if (startWave != null && endWave != null) {
                    for (PhotonSkyMapVo vo : photonSkyMapVos) {
                        if (vo.getWaveLength().compareTo(startWave) > 0 && vo.getWaveLength().compareTo(endWave) < 0) {
                            middle.add(vo);
                        }
                    }
                    for (PhotonSkyMapVo mapVo : middle) {
                        if (mapVo.getPhase().compareTo(startPhase) > 0 && mapVo.getPhase().compareTo(endPhase) < 0) {
                            size++;
                        } else {
                            return null;
                        }
                    }
                } else {
                    return photonSkyMapVos;
                }
            } else if (startAmplitude != null && endAmplitude == null && startPhase == null && endPhase == null) {
                if (startWave != null && endWave != null) {
                    for (PhotonSkyMapVo vo : photonSkyMapVos) {
                        if (vo.getWaveLength().compareTo(startWave) > 0 && vo.getWaveLength().compareTo(endWave) < 0) {
                            middle.add(vo);
                        }
                    }
                    for (PhotonSkyMapVo mapVo : middle) {
                        if (mapVo.getAmplitude().compareTo(startAmplitude) > 0) {
                            size++;
                        } else {
                            return null;
                        }
                    }
                } else {
                    return photonSkyMapVos;
                }
            } else if (startAmplitude == null && endAmplitude != null && startPhase == null && endPhase == null) {
                if (startWave != null && endWave != null) {
                    for (PhotonSkyMapVo vo : photonSkyMapVos) {
                        if (vo.getWaveLength().compareTo(startWave) > 0 && vo.getWaveLength().compareTo(endWave) < 0) {
                            middle.add(vo);
                        }
                    }
                    for (PhotonSkyMapVo mapVo : middle) {
                        if (mapVo.getAmplitude().compareTo(endAmplitude) < 0) {
                            size++;
                        } else {
                            return null;
                        }
                    }
                } else {
                    return photonSkyMapVos;
                }
            } else if (startAmplitude != null && endAmplitude != null && startPhase == null && endPhase == null) {
                if (startWave != null && endWave != null) {
                    for (PhotonSkyMapVo vo : photonSkyMapVos) {
                        if (vo.getWaveLength().compareTo(startWave) > 0 && vo.getWaveLength().compareTo(endWave) < 0) {
                            middle.add(vo);
                        }
                    }
                    for (PhotonSkyMapVo mapVo : middle) {
                        if (mapVo.getAmplitude().compareTo(startAmplitude) > 0 && mapVo.getAmplitude().compareTo(endAmplitude) < 0) {
                            size++;
                        } else {
                            return null;
                        }
                    }
                } else {
                    return photonSkyMapVos;
                }
            } else {
                if (startWave != null && endWave != null) {
                    for (PhotonSkyMapVo vo : photonSkyMapVos) {
                        if (vo.getWaveLength().compareTo(startWave) > 0 && vo.getWaveLength().compareTo(endWave) < 0) {
                            middle.add(vo);
                        }
                    }
                    for (PhotonSkyMapVo mapVo : middle) {
                        if (mapVo.getPhase().compareTo(startPhase) > 0 && mapVo.getPhase().compareTo(endPhase) < 0 && mapVo.getAmplitude().compareTo(startAmplitude) > 0 && mapVo.getAmplitude().compareTo(endAmplitude) < 0) {
                            size++;
                        } else {
                            return null;
                        }
                    }
                } else {
                    return photonSkyMapVos;
                }

            }
            if (size == middle.size()) {
                return photonSkyMapVos;
            } else {

                return null;
            }
        }
    }


