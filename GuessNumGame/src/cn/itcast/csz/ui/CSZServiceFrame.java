package cn.itcast.csz.ui;

import cn.itcast.csz.service.CSZService;

import javax.swing.*;

/**
 * Created by 朱潇翔 on 2016/12/12.
 */

/*
* 子类，完成界面上按钮点击事件的处理
* */
public class CSZServiceFrame extends CSZFrame {
    private CSZService service = new CSZService();
    private boolean status = true; //游戏的当前状态
    private final int MAXCOUNT = service.getMaxCount();

    public CSZServiceFrame() {
        //继承关系，执行父类的构造方法
        super();
        //生成4位的随机数，由CSZService.java完成
        this.service.init();
    }

    /*
    * run()：
    *   1、比较是否正确
    *   2、生成0A0B，并添加到Label中显示
    *   3、判断次数。如果达到上限，弹框，结束
    * */
    public void run(String input) {
        //更新游戏状态
        if(!this.status) {
            this.status = true;
            //产生一个随机数
            this.service.init();
        }

        //比较输入的数字是否正确
        //生成0A0B，并添加到Label中
        this.service.createResult(input);
        int count = this.service.getCount();

        //获取结果
        String[] results = this.service.getResults();
        String data = "<html><body>";
        for(int i = 0; i < results.length; ++i) {
            data += results[i];
            data += "<br/>";
        }
        data += "</body></html>";
        //添加到Label中
        this.jLabels[0].setText(data);

        if(this.service.equalsRondom(input)) {
            JOptionPane.showMessageDialog(this, "恭喜你，猜对了" + (100 - MAXCOUNT * count) + "分");
            this.status = false;
            //清空文本框中的数据
            this.clearTextFiled();
        }

        //判断是否到达最大次数
        if(count == MAXCOUNT) {
            //已到达最大次数
            String str = "<html><body>很遗憾，游戏结束<br/>正确的随机数为：" + this.service.getRandom() + "</body></html>";
            JOptionPane.showMessageDialog(this, str);
            this.status = false;
            this.clearTextFiled();
        }

    }
}
