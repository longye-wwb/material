package com.crledu.auto.util.list;

import java.util.List;

public class ListUtils {

    public static String[] stringListtoArrray(List<String> strList){
        String[] result = new String[strList.size()];
        strList.toArray(result);
        return result;
    }

}
