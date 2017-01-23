package cn.itcast.picture.app;

import cn.itcast.picture.ui.PictureMainFrame;

/**
 * Created by 朱潇翔 on 2016/12/13.
 */
public class MainApp {
    //启动器
    public static void main(String[] args) {
        //创建主界面
        PictureMainFrame pictureMainFrame = new PictureMainFrame();
        //显示界面
        pictureMainFrame.setVisible(true);
    }
}
