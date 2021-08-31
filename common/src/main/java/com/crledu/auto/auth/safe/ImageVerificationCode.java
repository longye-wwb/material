package com.crledu.auto.auth.safe;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 ************************************************************
 * @Description: 图片验证码
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/11 11:42
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ImageVerificationCode {

    /**
     * 验证码图片的长
     */
    private int weight = 100;

    /**
     * 验证码图片的宽
     */
    private int height = 40;

    /**
     * 验证码的文本内容
     */
    private String text;

    /**
     * 获取随机数对象
     */
    private Random r = new Random();

    //private String[] fontNames = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};   //字体数组
    /**
     *  字体数组
     */
    private String[] fontNames = {"Georgia"};
    /**
     * 验证码数组
     */
    private String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";

    /**
     *****************************************************************************
     * @Description 获取随机的颜色
     *****************************************************************************
     * @Param []
     * @return java.awt.Color
     *****************************************************************************
     * @Author wenyi
     * @Date 2021/5/11 11:45
     *****************************************************************************
     **/
    private Color randomColor() {
        //这里为什么是225，因为当r，g，b都为255时，即为白色，为了好辨认，需要颜色深一点。
        int r = this.r.nextInt(225);
        int g = this.r.nextInt(225);
        int b = this.r.nextInt(225);
        //返回一个随机颜色
        return new Color(r, g, b);
    }

    /**
     *****************************************************************************
     * @Description 获取随机字体
     *****************************************************************************
     * @Param []
     * @return java.awt.Font
     *****************************************************************************
     * @Author wenyi
     * @Date 2021/5/11 11:46
     *****************************************************************************
     **/
    private Font randomFont() {
        //获取随机的字体
        int index = r.nextInt(fontNames.length);
        String fontName = fontNames[index];
        //随机获取字体的样式，0是无样式，1是加粗，2是斜体，3是加粗加斜体
        int style = r.nextInt(4);
        //随机获取字体的大小
        int size = r.nextInt(10) + 24;
        //返回一个随机的字体
        return new Font(fontName, style, size);
    }

    /**
     *****************************************************************************
     * @Description 获取随机字符
     *****************************************************************************
     * @Param []
     * @return char
     *****************************************************************************
     * @Author wenyi
     * @Date 2021/5/11 11:46
     *****************************************************************************
     **/
    private char randomChar() {
        int index = r.nextInt(codes.length());
        return codes.charAt(index);
    }

    /**
     *****************************************************************************
     * @Description 画干扰线，验证码干扰线用来防止计算机解析图片
     *****************************************************************************
     * @Param [image]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2021/5/11 11:47
     *****************************************************************************
     **/
    private void drawLine(BufferedImage image) {
        //定义干扰线的数量
        int num = r.nextInt(10);
        Graphics2D g = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++) {
            int x1 = r.nextInt(weight);
            int y1 = r.nextInt(height);
            int x2 = r.nextInt(weight);
            int y2 = r.nextInt(height);
            g.setColor(randomColor());
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     *****************************************************************************
     * @Description 创建图片的方法
     *****************************************************************************
     * @Param []
     * @return java.awt.image.BufferedImage
     *****************************************************************************
     * @Author wenyi
     * @Date 2021/5/11 11:47
     *****************************************************************************
     **/
    private BufferedImage createImage() {
        //创建图片缓冲区
        BufferedImage image = new BufferedImage(weight, height, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics2D g = (Graphics2D) image.getGraphics();
        //设置背景色随机
        g.setColor(new Color(255, 255, r.nextInt(245) + 10));
        g.fillRect(0, 0, weight, height);
        //返回一个图片
        return image;
    }

    /**
     *****************************************************************************
     * @Description 获取验证码图片的方法
     *****************************************************************************
     * @Param []
     * @return java.awt.image.BufferedImage
     *****************************************************************************
     * @Author wenyi
     * @Date 2021/5/11 11:48
     *****************************************************************************
     **/
    public BufferedImage getImage() {
        BufferedImage image = createImage();
        //获取画笔
        Graphics2D g = (Graphics2D) image.getGraphics();
        StringBuilder sb = new StringBuilder();
        //画四个字符即可
        for (int i = 0; i < 4; i++)
        {
            //随机生成字符，因为只有画字符串的方法，没有画字符的方法，所以需要将字符变成字符串再画
            String s = randomChar() + "";
            //添加到StringBuilder里面
            sb.append(s);
            //定义字符的x坐标
            float x = i * 1.0F * weight / 4;
            //设置字体，随机
            g.setFont(randomFont());
            //设置颜色，随机
            g.setColor(randomColor());
            g.drawString(s, x, height - 5);
        }
        this.text = sb.toString();
        drawLine(image);
        return image;
    }

    /**
     *****************************************************************************
     * @Description 获取验证码文本的方法
     *****************************************************************************
     * @Param []
     * @return java.lang.String
     *****************************************************************************
     * @Author wenyi
     * @Date 2021/5/11 11:49
     *****************************************************************************
     **/
    public String getText() {
        return text;
    }

    /**
     *****************************************************************************
     * @Description 将验证码图片写出的方法
     *****************************************************************************
     * @Param [image, out]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2021/5/11 11:49
     *****************************************************************************
     **/
    public static void output(BufferedImage image, OutputStream out) throws IOException
    {
        ImageIO.write(image, "JPEG", out);
    }
}
