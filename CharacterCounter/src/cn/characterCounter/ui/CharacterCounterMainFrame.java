package cn.characterCounter.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 朱潇翔 on 2017/1/19.
 */
public class CharacterCounterMainFrame extends JFrame {
    public CharacterCounterMainFrame() {
        super();
        this.init(); //界面初始化

        this.addComponent(); //添加组件

    }

    private void addComponent() {
        //创建一个用来在主界面上方显示的面板
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 1));
        //上面表格显示：请选择一段文字or请输入一段文字

        //---------------上方
        JPanel upPanel = new JPanel();

        //---------------下方
        JPanel downPanel = new JPanel();
        //downPanel.setLayout(new GridLayout(1, 3));
        //添加单选按钮，默认为文件上传
        JRadioButton fileUPload = new JRadioButton("文件上传", false);
        JRadioButton fileInput = new JRadioButton("文件输入", true);
        //添加单选按钮组
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(fileUPload);
        buttonGroup.add(fileInput);

        downPanel.add(fileUPload);
        downPanel.add(fileInput);
        downPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        //int x = 0;
        //upPanel.setBackground(Color.PINK);
        JLabel jLabel =  jLabel = new JLabel("请输入一段文字");
//        if(fileUPload.isSelected()) {
//            x = 1;
//        }
//        else {
//            //jLabel = new JLabel("请选择一段文字l");
//            x = 2;
//        }

        jLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        upPanel.add(jLabel);
        upPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        jPanel.add(upPanel, BorderLayout.NORTH);

        jPanel.add(downPanel, BorderLayout.SOUTH);


        //设置jPanel在主界面中的显示位置
        this.add(jPanel, BorderLayout.NORTH);

    }

    private void init() {
        //this.setTitle("fucang");
        //设置窗口大小
        this.setSize(500, 600);
        //设置窗口显示位置：居中
        this.setLocation(433, 84);
        //设置窗口大小为固定大小
        this.setResizable(false);
        //设置窗口的默认关闭动作
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
