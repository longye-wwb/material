package com.crledu.auto.material.photon.biz.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.photon.biz.domain.AbsorbDomain;
import com.crledu.auto.material.photon.repository.dto.PhotonSelection;

import com.crledu.auto.material.photon.repository.dao.PhotonMapper;
import com.crledu.auto.material.photon.repository.dto.PhotonImport;
import com.crledu.auto.material.photon.repository.entity.Photon;
import com.crledu.auto.material.photon.repository.util.DoubleUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Trevor
 * @Date: 2020/7/10 09:58
 * @Description:
 */
@Repository
public class PhotonRepositoryImpl implements PhotonRepository{

    @Resource
    private PhotonMapper photonMapper;








    /**
     *****************************************************************************
     * @Description 光子信息持久化到数据库
     *****************************************************************************
     * @Param [photonDomain]
     * @return void
     *****************************************************************************
     * @Author zjs
     * @Date 2020/7/10 14:16
     *****************************************************************************
     **/
    @Override
    public void save(PhotonImport photonImport) {
        DoubleUtil doubleUtil = new DoubleUtil();
        Photon photon = new Photon();
        photon.setAngle(photonImport.getAngle());
        photon.setArticle(photonImport.getArticle());
        photon.setDirection(photonImport.getDirection());
        photon.setD(photonImport.getD());
        photon.setDb(photonImport.getDb());
        photon.setFmin1(photonImport.getFmin1());
        photon.setFmin2(photonImport.getFmin2());
        photon.setFmin3(photonImport.getFmin3());
        photon.setFmax1(photonImport.getFmax1());
        photon.setFmax2(photonImport.getFmax2());
        photon.setFmax3(photonImport.getFmax3());
        photon.setFc1(DoubleUtil.div(DoubleUtil.sum(photonImport.getFmax1(), photonImport.getFmin1()),2,8));
        if (photonImport.getFmin2()==0&& photonImport.getFmax2()==0){
            photon.setFc2(0d);
        }else {
            photon.setFc2(DoubleUtil.div(DoubleUtil.sum(photonImport.getFmax2(), photonImport.getFmin2()), 2, 8));
        }
        if (photonImport.getFmin3()==0&& photonImport.getFmax3()==0){
            photon.setFc3(0d);
        }else {
            photon.setFc3(DoubleUtil.div(DoubleUtil.sum(photonImport.getFmax3(), photonImport.getFmin3()), 2, 8));
        }
        Double sub1 = DoubleUtil.sub(photonImport.getFmax1(), photonImport.getFmin1());
        Double sub2 =DoubleUtil.sub(photonImport.getFmax2(), photonImport.getFmin2());
        Double sub3 =DoubleUtil.sub(photonImport.getFmax3(), photonImport.getFmin3());
        photon.setfDelta( DoubleUtil.sum(DoubleUtil.sum(sub1,sub2),sub3));
        photon.setN(photonImport.getN());
        Double d1min = DoubleUtil.div(3d, photon.getFmin1(), 8);
        Double d1max = DoubleUtil.div(3d, photon.getFmax1(), 8);
        Double d2min=0d;
        Double d2max=0d;
        Double d3min=0d;
        Double d3max=0d;
        if (photonImport.getFmin2()==0&& photonImport.getFmax2()==0) {
        }else {
            d2min = DoubleUtil.div(3d, photon.getFmin2(), 8);
            d2max = DoubleUtil.div(3d, photon.getFmax2(), 8);
        }
        if (photonImport.getFmin3()==0&& photonImport.getFmax3()==0){
        }
        else {
            d3min = DoubleUtil.div(3d, photon.getFmin3(), 8);
            d3max = DoubleUtil.div(3d, photon.getFmax3(), 8);
        }
        DoubleUtil.sum(DoubleUtil.sum( DoubleUtil.sub(d1min,d1max),DoubleUtil.sub(d2min,d2max)),DoubleUtil.sub(d3min,d3max));
        photon.setLambdaDelta(DoubleUtil.mul(DoubleUtil.sum(DoubleUtil.sum( DoubleUtil.sub(d1min,d1max),DoubleUtil.sub(d2min,d2max)),DoubleUtil.sub(d3min,d3max)),100));
        //172*d/(Δλ*Γ)
//            doubleUtil.mul(photonImport.getDb(),photon.getLambdaDelta());
//            doubleUtil.mul(Double.valueOf(172),photonImport.getD());
        photon.setPolarization(photonImport.getPolarization());
        photon.setRozanov(DoubleUtil.div(DoubleUtil.mul(Double.valueOf(172), photonImport.getD()),DoubleUtil.mul(photonImport.getDb(),photon.getLambdaDelta()),8));
        photonMapper.insert(photon);
    }


    /**
     *****************************************************************************
     * @Description excel导入数据
     *****************************************************************************
     * @Param [list]
     * @return void
     *****************************************************************************
     * @Author zjs
     * @Date 2020/8/5 15:44
     *****************************************************************************
     **/
    @Override
    public void saveExecl(List<PhotonImport> list) {

        DoubleUtil doubleUtil = new DoubleUtil();
        for (PhotonImport photonImport : list){
            Photon photon = new Photon();
            photon.setAngle(photonImport.getAngle());
            photon.setArticle(photonImport.getArticle());
            photon.setDirection(photonImport.getDirection());
            photon.setD(photonImport.getD());
            photon.setDb(photonImport.getDb());
            photon.setFmin1(photonImport.getFmin1());
            photon.setFmin2(photonImport.getFmin2());
            photon.setFmin3(photonImport.getFmin3());
            photon.setFmax1(photonImport.getFmax1());
            photon.setFmax2(photonImport.getFmax2());
            photon.setFmax3(photonImport.getFmax3());
            photon.setFc1(DoubleUtil.div(DoubleUtil.sum(photonImport.getFmax1(), photonImport.getFmin1()),2,8));
            if (photonImport.getFmin2()==0&& photonImport.getFmax2()==0){
                photon.setFc2(0d);
            }else {
                photon.setFc2(DoubleUtil.div(DoubleUtil.sum(photonImport.getFmax2(), photonImport.getFmin2()), 2, 8));
            }
            if (photonImport.getFmin3()==0&& photonImport.getFmax3()==0){
                photon.setFc3(0d);
            }else {
                photon.setFc3(DoubleUtil.div(DoubleUtil.sum(photonImport.getFmax3(), photonImport.getFmin3()), 2, 8));
            }
            Double sub1 = DoubleUtil.sub(photonImport.getFmax1(), photonImport.getFmin1());
            Double sub2 =DoubleUtil.sub(photonImport.getFmax2(), photonImport.getFmin2());
            Double sub3 =DoubleUtil.sub(photonImport.getFmax3(), photonImport.getFmin3());
            photon.setfDelta( DoubleUtil.sum(DoubleUtil.sum(sub1,sub2),sub3));
            photon.setN(photonImport.getN());
            Double d1min = DoubleUtil.div(3d, photon.getFmin1(), 8);
            Double d1max = DoubleUtil.div(3d, photon.getFmax1(), 8);
            Double d2min=0d;
            Double d2max=0d;
            Double d3min=0d;
            Double d3max=0d;
            if (photonImport.getFmin2()==0&& photonImport.getFmax2()==0) {
            }else {
                 d2min = DoubleUtil.div(3d, photon.getFmin2(), 8);
                 d2max = DoubleUtil.div(3d, photon.getFmax2(), 8);
            }
            if (photonImport.getFmin3()==0&& photonImport.getFmax3()==0){
            }
            else {
                 d3min = DoubleUtil.div(3d, photon.getFmin3(), 8);
                 d3max = DoubleUtil.div(3d, photon.getFmax3(), 8);
            }


            DoubleUtil.sum(DoubleUtil.sum( DoubleUtil.sub(d1min,d1max),DoubleUtil.sub(d2min,d2max)),DoubleUtil.sub(d3min,d3max));
            photon.setLambdaDelta(DoubleUtil.mul(DoubleUtil.sum(DoubleUtil.sum( DoubleUtil.sub(d1min,d1max),DoubleUtil.sub(d2min,d2max)),DoubleUtil.sub(d3min,d3max)),100));
            //172*d/(Δλ*Γ)
//            doubleUtil.mul(photonImport.getDb(),photon.getLambdaDelta());
//            doubleUtil.mul(Double.valueOf(172),photonImport.getD());
            photon.setPolarization(photonImport.getPolarization());
            photon.setRozanov(DoubleUtil.div(DoubleUtil.mul(Double.valueOf(172), photonImport.getD()),DoubleUtil.mul(photonImport.getDb(),photon.getLambdaDelta()),8));
            photonMapper.insert(photon);
        }
    }

    /**
     *****************************************************************************
     * @Description 导出excel
     *****************************************************************************
     * @Param [photonSelection]
     * @return java.util.List<PhotonImport>
     *****************************************************************************
     * @Author zjs
     * @Date 2020/8/5 15:45
     *****************************************************************************
     **/
    @Override
    public List<PhotonImport> dbToExcel(PhotonSelection photonSelection) {
        QueryWrapper<Photon> q = new QueryWrapper<>();
        List<Photon> photons = new ArrayList<>();
        if (photonSelection.getPageNum()!=null&&photonSelection.getPageSize()!=null) {
            Page<Photon> page = new Page(photonSelection.getPageNum(), photonSelection.getPageSize());
            IPage<Photon> photonIPage = photonMapper.selectPage(page, q);
            photons = photonIPage.getRecords();
        }else {
            photons=photonMapper.selectList(q);
        }
        List<PhotonImport> photonImports = new ArrayList<>();
        for (Photon photon : photons){
            PhotonImport photonImport = new PhotonImport();
            BeanUtils.copyProperties(photon, photonImport);
            photonImports.add(photonImport);
        }
        return photonImports;
    }


    @Override
    public void saveData(AbsorbDomain absorbDomain) {
        Photon photon = new Photon();
        photon.setN(absorbDomain.getN());
        photon.setAngle(absorbDomain.getAngle());
        photon.setRozanov(absorbDomain.getRozanov());
        photon.setArticle(absorbDomain.getArticle());
        photon.setDb(absorbDomain.getDb());
        photon.setD(absorbDomain.getD());
        photon.setDirection(absorbDomain.getDirection());
        photon.setfDelta(absorbDomain.getfDelta());
        photon.setLambdaDelta(absorbDomain.getLambdaDelta());
        photon.setPolarization(absorbDomain.getPolarization());
        if (absorbDomain.getAbsorbLayerDomains().size()==3) {
            photon.setFmin1(absorbDomain.getAbsorbLayerDomains().get(0).getStart());
            photon.setFmax1(absorbDomain.getAbsorbLayerDomains().get(0).getEnd());
            photon.setFmin2(absorbDomain.getAbsorbLayerDomains().get(1).getStart());
            photon.setFmax2(absorbDomain.getAbsorbLayerDomains().get(1).getEnd());
            photon.setFmin3(absorbDomain.getAbsorbLayerDomains().get(2).getStart());
            photon.setFmax3(absorbDomain.getAbsorbLayerDomains().get(2).getEnd());
            photon.setFc1(absorbDomain.getAbsorbLayerDomains().get(0).getCenter());
            photon.setFc2(absorbDomain.getAbsorbLayerDomains().get(1).getCenter());
            photon.setFc3(absorbDomain.getAbsorbLayerDomains().get(2).getCenter());
        }else if (absorbDomain.getAbsorbLayerDomains().size()==2){
            photon.setFmin1(absorbDomain.getAbsorbLayerDomains().get(0).getStart());
            photon.setFmax1(absorbDomain.getAbsorbLayerDomains().get(0).getEnd());
            photon.setFmin2(absorbDomain.getAbsorbLayerDomains().get(1).getStart());
            photon.setFmax2(absorbDomain.getAbsorbLayerDomains().get(1).getEnd());
            photon.setFc1(absorbDomain.getAbsorbLayerDomains().get(0).getCenter());
            photon.setFc2(absorbDomain.getAbsorbLayerDomains().get(1).getCenter());
        }else {
            photon.setFmin1(absorbDomain.getAbsorbLayerDomains().get(0).getStart());
            photon.setFmax1(absorbDomain.getAbsorbLayerDomains().get(0).getEnd());
            photon.setFc1(absorbDomain.getAbsorbLayerDomains().get(0).getCenter());
        }
        photonMapper.insert(photon);
    }
}
