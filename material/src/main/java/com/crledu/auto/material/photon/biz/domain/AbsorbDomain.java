package com.crledu.auto.material.photon.biz.domain;



import com.crledu.auto.material.photon.biz.dto.PhotonDataDto;
import com.crledu.auto.material.photon.repository.entity.Photon;
import com.crledu.auto.material.photon.repository.util.DoubleUtil;

import java.util.List;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/11/23
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class AbsorbDomain {

    private Long id;                //主键id
    private Double n;               //吸收频带数
    private List<AbsorbLayerDomain> absorbLayerDomains; //频带带宽列表
    private Double db;              //dB形式的吸收率阈值Γ（默认10）
    private Double fDelta;          //频率带宽：几个频段吸收带宽求和Δf  fmax1-fmin1+fmax2-fmin2+fmax3-fmin3
    private Double lambdaDelta;     //波长带宽Δλ  c/fmin1-c/fmax2+c/fmin2-c/fmax2+c/fmin3-c/fmax3
    private Double d;               //厚度d（mm)
    private Double rozanov;         //Rozanov参数Roz：172*d/(Δλ*Γ)
    private Double angle;           //入射角度
    private String polarization;    //偏振
    private String direction;       //入射方向
    private String article;         //文章

    private Boolean saveData;

    public PhotonDataDto buildData(){
        PhotonDataDto photon = new PhotonDataDto();
        photon.setN(this.getN());
        photon.setAngle(this.getAngle());
        photon.setRozanov(this.getRozanov());
        photon.setArticle(this.getArticle());
        photon.setDb(this.getDb());
        photon.setD(this.getD());
        photon.setDirection(this.getDirection());
        photon.setfDelta(this.getfDelta());
        photon.setLambdaDelta(this.getLambdaDelta());
        photon.setPolarization(this.getPolarization());
        if (this.getAbsorbLayerDomains().size()==3) {
            photon.setFmin1(this.getAbsorbLayerDomains().get(0).getStart());
            photon.setFmax1(this.getAbsorbLayerDomains().get(0).getEnd());
            photon.setFmin2(this.getAbsorbLayerDomains().get(1).getStart());
            photon.setFmax2(this.getAbsorbLayerDomains().get(1).getEnd());
            photon.setFmin3(this.getAbsorbLayerDomains().get(2).getStart());
            photon.setFmax3(this.getAbsorbLayerDomains().get(2).getEnd());
            photon.setFc1(this.getAbsorbLayerDomains().get(0).getCenter());
            photon.setFc2(this.getAbsorbLayerDomains().get(1).getCenter());
            photon.setFc3(this.getAbsorbLayerDomains().get(2).getCenter());
        }else if (this.getAbsorbLayerDomains().size()==2){
            photon.setFmin1(this.getAbsorbLayerDomains().get(0).getStart());
            photon.setFmax1(this.getAbsorbLayerDomains().get(0).getEnd());
            photon.setFmin2(this.getAbsorbLayerDomains().get(1).getStart());
            photon.setFmax2(this.getAbsorbLayerDomains().get(1).getEnd());
            photon.setFc1(this.getAbsorbLayerDomains().get(0).getCenter());
            photon.setFc2(this.getAbsorbLayerDomains().get(1).getCenter());
        }else {
            photon.setFmin1(this.getAbsorbLayerDomains().get(0).getStart());
            photon.setFmax1(this.getAbsorbLayerDomains().get(0).getEnd());
            photon.setFc1(this.getAbsorbLayerDomains().get(0).getCenter());
        }
        return photon;
    }

    public Boolean getSaveData() {
        return saveData;
    }

    public Long getId() {
        return id;
    }

    public Double getN() {
        return n;
    }

    public List<AbsorbLayerDomain> getAbsorbLayerDomains() {
        return absorbLayerDomains;
    }

    public Double getDb() {
        return db;
    }

    public Double getfDelta() {
        return fDelta;
    }

    public Double getLambdaDelta() {
        return lambdaDelta;
    }

    public Double getD() {
        return d;
    }

    public Double getRozanov() {
        return rozanov;
    }

    public Double getAngle() {
        return angle;
    }

    public String getPolarization() {
        return polarization;
    }

    public String getDirection() {
        return direction;
    }

    public String getArticle() {
        return article;
    }



    public static AbsorbDomain getInstence(Double n, List<AbsorbLayerDomain> absorbLayerDomains, Double db, Double d, Double angle, String polarization, String direction, String article,Boolean saveData){

        AbsorbDomain p = new AbsorbDomain(n, absorbLayerDomains,db,d,angle,polarization,direction,article,saveData);
        return p;
    }

    protected AbsorbDomain(Double n, List<AbsorbLayerDomain> absorbLayerDomains, Double db, Double d, Double angle, String polarization, String direction, String article,Boolean saveData) {
        this.n = n;
        this.absorbLayerDomains = absorbLayerDomains;
        this.db = db;
        this.d = d;
        this.angle = angle;
        this.polarization = polarization;
        this.direction = direction;
        this.article = article;
        this.saveData = saveData;

        Double result=0d;
        Double result2=0d;
        for (AbsorbLayerDomain absorbLayerDomain : absorbLayerDomains){
            result+= DoubleUtil.sub(absorbLayerDomain.getEnd(), absorbLayerDomain.getStart());
            result2+=DoubleUtil.sub(DoubleUtil.div(300d, absorbLayerDomain.getStart(),5),DoubleUtil.div(300d, absorbLayerDomain.getEnd(),5));
        }
        this.fDelta=result;
        this.lambdaDelta=result2;
        this.rozanov=DoubleUtil.div(DoubleUtil.mul(172d,d),DoubleUtil.mul(this.lambdaDelta,db),5);
    }
}
