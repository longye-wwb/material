package com.crledu.auto.web.vo.date;

import com.crledu.auto.util.ObjectUtils;

public class TimeAreaParam {

    private String start;
    private String end;

    public TimeAreaParam() {
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public boolean bothHad(){
        if(ObjectUtils.isNotNull(start)&&ObjectUtils.isNotNull(end)){
            return true;
        }else{
            return false;
        }
    }
}
