package cn.characterCounter.app;

import cn.characterCounter.ui.CharacterCounterMainFrame;

/**
 * Created by 朱潇翔 on 2017/1/19.
 */
public class MainApp {
    public static void main(String[] args) {
        //创建主界面
        CharacterCounterMainFrame characterCounterMainFrame = new CharacterCounterMainFrame();
        //显示界面
        characterCounterMainFrame.setVisible(true);
    }
}
