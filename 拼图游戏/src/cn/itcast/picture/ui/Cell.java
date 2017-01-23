package cn.itcast.picture.ui;

import javax.swing.*;

/**
 * Created by 朱潇翔 on 2016/12/13.
 */
/*
* 单元格类：每一张小图片都是一个图片按钮
* */
public class Cell extends JButton {
    //带有图片且带有文字的小方格
    public Cell(String text, Icon icon) {
        super(text, icon);
        //设置小方格的大小
        this.setSize(150, 150);
        //设置文字水平居中显示
        this.setHorizontalTextPosition(CENTER);
        //设置文字垂直居中显示
        this.setVerticalTextPosition(CENTER);

    }

    //带有图片的小方格
    public Cell(Icon icon) {
        super(icon);
        //设置当前小方格的大小
        this.setSize(150, 150);
    }
}
