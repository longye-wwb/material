package com.crledu.auto.util.string;

import com.crledu.auto.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class SqlUtils {

    private static final String spider = ",";

    public static String allLikeString(String value){
        if(value == null){
            return null;
        }else{
            return "%"+value+"%";
        }
    }

    public static String buildIdArrayStr(List<Long> ids){
        if(ObjectUtils.isNotNull(ids)&&ids.size()>0){
            StringBuilder sb = new StringBuilder();
            sb.append(ids.get(0));
            for(int i = 1;i<ids.size();i++){
                sb.append(spider);
                sb.append(ids.get(i));
            }
            return sb.toString();
        }
        return "";
    }

    public static List<Long> buildIdList(String str){
        List<Long> result = new ArrayList<>();
        if(!str.isEmpty()){
            String[] longStr = str.split(spider);
            for(String itemStr :longStr){
                result.add(Long.parseLong(itemStr));
            }
        }
        return result;
    }
}
