package cn.itcast.csz.app;

import cn.itcast.csz.ui.CSZServiceFrame;

import javax.swing.*;

/**
 * Created by 朱潇翔 on 2016/12/12.
 */
public class MainApp {
    /*
    * 游戏的启动器类
    * */
    public static void main(String[] args) {
        //创建窗体CSZServiceFrame
        CSZServiceFrame frame = new CSZServiceFrame();

        //设置窗体的默认关闭操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //显示窗体
        frame.setVisible(true); //设置窗体是否显示，参数为true，表示显示，false表示不显示
    }
 }
