package cn.GamePanel.util;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 朱潇翔 on 2016/11/28.
 */
public class MainFrame extends JFrame {
    MainFrame() {
        //构造方法主要完成窗体的初始化和程序界面中所有控件的布局、初始化和时间添加
        super();
        //getContentPane()方法：JFrame窗体类的方法，用于获取窗体的内容面板，
        //窗体的所有控件都要添加到这个面板中
        getContentPane().setLayout(new BorderLayout());

        setTitle("拼图游戏");
    }

}


