package com.crledu.auto.material.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 ************************************************************
 * @Description: 灰度图的生成
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/12 12:04
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ImageUtils {

    public static BufferedImage createGrayPicture(double[][] data){
        int width = data.length;
        int height = data[0].length;

        //获取画板
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        //根据矩阵生成灰度图
        for(int i =0;i<width;i++){
            for(int j = 0; j < height;j++){
                double colorValue = (1f-data[i][j]) * 255;
                int greyColor = Double.valueOf(colorValue).intValue();
                Color color = new Color(greyColor,greyColor,greyColor);
                bi.setRGB(i,j, color.getRGB());
            }
        }
        return bi;
    }
}
