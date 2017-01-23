package cn.itcast.picture.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by 朱潇翔 on 2016/12/13.
 */
/*
* 主界面类：加载拼图图片和样式图片
* */
public class PictureMainFrame extends JFrame {
    private JRadioButton addNumInfo;  //数字提示
    private JRadioButton clearNumInfo;  //清除提示
    private PictureCanvas pictureCanvas; //拼图区
    private PicturePreview picturePreview;  //预览区
    private JComboBox<String> jComboBox;   //下拉框
    private JTextField step;    //游戏步数
    private JTextField pictureName; //图片名称
    private JButton startButton; //开始按钮

    private String[] items = {"浮滄", "钟楼"};

    //构造函数
    public PictureMainFrame() {
        super(); //写不写都会调用
        this.init(); //界面初始化

        this.addComponent(); //添加组件

        addPreviewImage(); //添加预览图片与拼图图片

        addActionListener(); //为组件添加事件监听
    }

    //为组件添加事件监听
    private void addActionListener() {
        this.addNumInfo.addActionListener(new ActionListener() {
            //点击数字提示时调用
            @Override
            public void actionPerformed(ActionEvent e) {
                //完成数字提示
                pictureCanvas.reLoadPictureAddNumber();
            }
        });

        this.clearNumInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //清除数字提示
                pictureCanvas.reLoadPictureClearNumber();
            }
        });

        this.jComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //下拉框

                //获取到选择的图片的序号
                int num = jComboBox.getSelectedIndex();
                //更新预览区
                PictureCanvas.pictureID = num + 1; //更新图片ID
                picturePreview.repaint(); //重新绘制预览区

                //更新拼图区
                pictureCanvas.reLoadPictureClearNumber();

                //更新游戏状态区
                pictureName.setText("图片名称：" + jComboBox.getSelectedItem()); //设置图片名称
                PictureCanvas.stepNum = 0;
                step.setText("游戏步数：" + PictureCanvas.stepNum); //游戏步数清零

                //更新游戏按钮区：将按钮区选择为清除提示
                clearNumInfo.setSelected(true);

            }
        });

        this.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //游戏步数清零并将游戏状态区的步数更新
                PictureCanvas.stepNum = 0;
                step.setText("游戏步数：" + PictureCanvas.stepNum); //游戏步数清零

                //随机打乱游戏拼图区



            }
        });

    }

    //添加预览图片与拼图图片
    private void addPreviewImage() {
        //创建一个面板
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(1, 2)); //设置布局为表格布局

        //------------------------------
        //-----------------------拼图区
        pictureCanvas = new PictureCanvas();
        pictureCanvas.setBorder(new TitledBorder("拼图区")); //设置边框


        //-----------------------图片预览区
        picturePreview = new PicturePreview();
        picturePreview.setBorder(new TitledBorder("预览区")); //设置边框



        //将拼图区与图片预览区添加到中间面板中
        panel.add(pictureCanvas, BorderLayout.WEST); //左边
        panel.add(picturePreview, BorderLayout.EAST); //右边



        //将面板显示在主界面中
        this.add(panel, BorderLayout.CENTER); //居中显示
    }

    /*
    * 添加组件
    * */
    private void addComponent() {
        //创建一个用来在主界面上方显示的面板，面板中包含按钮区和游戏状态区
        JPanel panel = new JPanel(); //创建一个面板
        //panel.setBackground(Color.PINK); //设置游戏面板的背景色

        panel.setLayout(new GridLayout(1, 2));//元素布局方式为表格方式
        //左面表格存放按钮区，右面表格存放状态区

        //-------------------------------------------------------------
        //创建左面按钮区的面板
        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(new TitledBorder("游戏按钮")); //添加边框
        leftPanel.setBackground(Color.PINK);//设置背景色
        //添加按钮

        //添加单选按钮，默认为清除提示
        addNumInfo = new JRadioButton("数字提示", false);
        clearNumInfo = new JRadioButton("清除提示", true);
        //添加单选按钮组，数字提示按钮和清除提示按钮是单选
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(addNumInfo);
        buttonGroup.add(clearNumInfo);

        //添加下拉框
        jComboBox = new JComboBox<String>(this.items);

        //添加开始按钮
        startButton = new JButton("Start");

        //为按钮设置背景色
        addNumInfo.setBackground(Color.PINK);
        clearNumInfo.setBackground(Color.PINK);
        startButton.setBackground(Color.PINK);

        //添加组件到左面板中,面板中不能直接添加按钮组
        leftPanel.add(addNumInfo);
        leftPanel.add(clearNumInfo);
        leftPanel.add(new JLabel("                   选择图片："));
        leftPanel.add(jComboBox);
        leftPanel.add(startButton);


        //将左子面板添加到面板中
        panel.add(leftPanel, BorderLayout.WEST); //左面

        //-------------------------------------------------------
        //创建右面状态区的面板
        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new TitledBorder("游戏状态")); //添加边框
        rightPanel.setBackground(Color.PINK);//设置背景色
        rightPanel.setLayout(new GridLayout(1, 2)); //设置布局为表格布局

        //添加组件图片名称
        pictureName = new JTextField("图片名称：" + this.jComboBox.getSelectedItem());
        //添加组件步数
        step = new JTextField("游戏步数：" + PictureCanvas.stepNum);

        //设置文本框为不可编辑
        pictureName.setEditable(false);
        step.setEditable(false);

        //把组件添加到游戏状态面板中
        rightPanel.add(pictureName, BorderLayout.WEST);
        rightPanel.add(step, BorderLayout.EAST);



        //将右子面板添加到面板中
        panel.add(rightPanel, BorderLayout.EAST); //右面

        //设置panel在主界面中的显示位置（在上方中显示）
        this.add(panel, BorderLayout.NORTH);

    }

     /*
    * 界面初始化
    * */
    private void init() {
        //设置窗口标题
        this.setTitle("浮滄的拼图游戏");
        //设置窗口大小
        this.setSize(1000, 720);
        //设置窗口显示位置
        this.setLocation(160, 10);
        //设置窗口为固定大小
        this.setResizable(false);
        //设置窗口的默认关闭操作
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
