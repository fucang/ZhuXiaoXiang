package cn.itcast.picture.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 朱潇翔 on 2016/12/13.
 */
/*
* 图片拼图类
* */
public class PictureCanvas extends JPanel {
    //静态变量：用来确定选择的图片的ID
    public static int pictureID = 1; //图片ID
    public static int stepNum = 0; //游戏步数

    //成员变量
    private Cell[] cell; //小方格

    //空参数构造方法，通过构造方法将小方格图片显示
    public PictureCanvas() {
        //设置拼图区的布局
        this.setLayout(null); //空布局，按帧布局
        //创建12个图片小方格，添加到拼图区
        cell = new Cell[12];
        for (int i = 0; i < 4; ++i) { //外循环代表行数
            for(int j = 0; j < 3; ++j) { //内循环代表列数
                //加载图片
                int num = i * 3 + j + 1;
                String name = "picture\\" + PictureCanvas.pictureID +"_" + num + ".gif";
                ImageIcon imageIcon = new ImageIcon(name);
                //创建图片小方格
                cell[num - 1] = new Cell(imageIcon);

                //指定小方格显示的位置
                cell[num - 1].setLocation(j*150+25, i*150+20);

                //图片小方格添加到拼图区
                this.add(cell[num - 1]);

            }
        }

        //删除第12个小方格
        this.remove(cell[11]);

        //指定一个空的小方格
        Rectangle nullCell = new Rectangle(300 + 25, 450 + 20, 150, 150);

    }

    //重新加载图片，并添加数字提示
    public void reLoadPictureAddNumber() {
        //获取到每一个图片小方格
        for(int i = 0; i < 4; ++i) {
            for(int j = 0; j < 3; ++j) {
                //获取小方格cell[i*3+j]
                //设置小方格显示的图片
                int num = i * 3 + j + 1;
                String name = "picture\\" + PictureCanvas.pictureID +"_" + num + ".gif"; //因为有可能改变了图片的ID
                ImageIcon imageIcon = new ImageIcon(name);
                cell[i*3+j].setIcon(imageIcon);
                //设置小方格显示的数字提示
                cell[i*3+j].setText("" + (i*3+j+1));
                cell[i*3+j].setVerticalTextPosition(this.getY()/2);
                cell[i*3+j].setHorizontalTextPosition(this.getX()/2);

            }
        }

    }

    //重新加载图片并去除数字提示
    public void reLoadPictureClearNumber() {
        for(int i = 0; i < 4; ++i) {
            for(int j = 0; j < 3; ++j) {
                //设置小方格显示的图片
                int num = i * 3 + j + 1;
                String name = "picture\\" + PictureCanvas.pictureID +"_" + num + ".gif"; //因为有可能改变了图片的ID
                ImageIcon imageIcon = new ImageIcon(name);
                cell[i*3+j].setIcon(imageIcon);
                cell[i*3+j].setText("");
            }
        }
    }

}
