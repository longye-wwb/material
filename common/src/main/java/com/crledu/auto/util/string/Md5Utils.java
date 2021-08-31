package com.crledu.auto.util.string;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 ************************************************************
 * @Description: 使用MD5算法加密解密相关方法
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/6/30 17:10
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class Md5Utils {

    /**
     *****************************************************************************
     * @Description 获得字符串的MD5计算过后的字符串。
     *****************************************************************************
     * @Param [plainText]
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/3 9:52
     *****************************************************************************
     **/
    public static String stringToMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

}
