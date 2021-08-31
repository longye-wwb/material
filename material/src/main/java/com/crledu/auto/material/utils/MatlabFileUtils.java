package com.crledu.auto.material.utils;

import com.jmatio.io.MatFileReader;
import com.jmatio.types.MLArray;
import com.jmatio.types.MLDouble;
import com.jmatio.types.MLInt8;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MatlabFileUtils {

    private static File getTempFile(String name) throws IOException {
        File file = new File(name);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public static byte[][] readInt8MatFile(String name,String arrayName) throws IOException {
        MatFileReader mfr = new MatFileReader(getTempFile(name));
        MLInt8 mlArrayRetrived = (MLInt8) mfr.getMLArray(arrayName);
        byte[][] result = mlArrayRetrived.getArray();
        return result;
    }

    public static double[][][] readDoubleMatFile(String name,String arrayName) throws IOException {
        File file = getTempFile(name);
        return readDoubleMatFile(file,arrayName);
    }

    public static double[][][] readDoubleMatFile(File matFile,String arrayName) throws IOException {
        MatFileReader mfr = new MatFileReader(matFile);
        MLDouble mlArrayRetrived = (MLDouble) mfr.getMLArray(arrayName);
        double[][] array = mlArrayRetrived.getArray();
        //裁剪图片
        int width = array.length;
        int total = array[0].length / width;
        double[][][] result = new double[total][width][width];
        for(int t = 0; t<total ; t++){
            for(int i = 0 ; i < width ; i++){
                for(int j = 0 ; j < width ; j++){
                    result[t][i][j] = array[i][t*width+j];
                }
            }
        }
        return result;
    }

    public static void main(String ...args){
        String file = "C:\\Users\\Lenovo\\Desktop\\structure1-100.mat";
        String name = "structure";
        String path = "C:\\Users\\Lenovo\\Desktop\\picture\\";
        try {
            double[][][] result = readDoubleMatFile(file,name);
            for(int i =0;i<result.length;i++){
                String fileName = path + "structure" + i +".jpg";
                File picture = new File(fileName);
                ImageIO.write(ImageUtils.createGrayPicture(result[i]),"jpg",picture);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
