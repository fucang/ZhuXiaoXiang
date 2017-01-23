package cn.itcast.picture.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 朱潇翔 on 2016/12/13.
 */
/*
* 图片预览类
* */
public class PicturePreview extends JPanel {
    //重写绘制组件方法，显示预览图片
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //指定图片路径
        String filename = "picture\\"+ PictureCanvas.pictureID +".jpg";

        //通过图片路径获取到图片中的图像
        ImageIcon imageIcon = new ImageIcon(filename);
        Image image = imageIcon.getImage(); //获取到图片中的图像

        //将图像绘制在预览区的面板中
        g.drawImage(image, 25, 20, 450, 600, this);

    }
}
