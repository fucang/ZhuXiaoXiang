package cn.itcast.csz.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 朱潇翔 on 2016/12/12.
 */

/*
* 父类，主界面类，完成游戏界面的处理
* 继承于java的窗体类JFrame，代表的是一个界面
* */
public abstract class CSZFrame extends JFrame {
    //成员变量
    protected JTextField[] jTextFields = new JTextField[4]; //4个文本输入框
    protected JButton jButton = new JButton("确定");
    protected JLabel[] jLabels = new JLabel[2]; //两个标签

    public CSZFrame() {
        //初始化init()
        this.init();

        //添加组件addComponent()
        this.addComponent();

        //为组件添加监听器addListener()
        this.addListener();
    }

    /*
    * 初始化：init()
    *   1、设置宽高
    *   2、设置显示位置
    *   3、设置标题
    *   4、设置是否可以修改宽高
    * */
    public void init() {
        this.setSize(300, 300);//设置宽高
        this.setLocation(500, 200); ///设置显示位置，尽量居中
        this.setTitle("浮滄的猜数字游戏"); //设置标题
        this.setResizable(false); //设置不可以改变窗口的大小
    }

    /*
    * 添加组件：addComponent()
    *   1、设置布局（3个面板）
    *   2、添加四个单行文本框
    *   3、添加一个按钮
    *   4、添加两个Label，设置字体
    *       标签一：显示结果
    *       标签二：显示提示信息
    * */
    private void addComponent() {
        //设置布局（3个面板）
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();

        //设置面板布局，采用边框布局方式
        this.add(jPanel1, BorderLayout.NORTH);//上面
        this.add(jPanel2); //默认添加到中间显示
        this.add(jPanel3,BorderLayout.SOUTH);//下面

        //添加四个文本输入框
        for(int i = 0; i < this.jTextFields.length; ++i) {
            //创建每一个文本输入框
            this.jTextFields[i] = new JTextField(3); //设置宽度为3
            this.jTextFields[i].setFont(new Font("宋体", 1, 18)); //0：普通  1：加粗  2：倾斜
            //将文本输入框添加到主面板上
            jPanel1.add(this.jTextFields[i]);
        }
        //添加一个按钮
        jPanel1.add(this.jButton);

        //添加两个标签
        for(int i = 0; i < this.jLabels.length; ++i) {
            //创建每一个标签
            this.jLabels[i] = new JLabel();
            this.jLabels[i].setFont(new Font("宋体", 1, 14)); //设置字体
        }
        //将标签添加到中间和下面的面板中
        //标签一：显示结果
        jPanel2.add(this.jLabels[0]);
        //标签二：显示提示信息
        jPanel3.add(this.jLabels[1]);
        //为标签二设置提示信息
        //换行需要使用html语言中的代码
        this.jLabels[1].setText("<html><body>A：代表数字出现，而且位置正确<br/>B：代表数字出现，但是位置错误</body></html>");
    }

    /*
    * 为组件添加监听器：addListener()
    *   1、获取数据并校验getInputAndValidate()
    *   2、条用核心业务run()
    *   3、异常处理，对话框提示
    * */
    private void addListener() {
        //设置按钮监听
        this.jButton.addActionListener(new ActionListener() {
            @Override
            //匿名内部类的方式
            //当点击按钮时的点击操作
            public void actionPerformed(ActionEvent e) {
                try {
                    //1、获取数据并校验getInputAndValidate()
                    String input = getInputAndValidate();

                    //2、调用核心代码run()
                    run(input);

                } catch (NumberFormatException ex) {
                    //不是正常的数字字符
                    JOptionPane.showMessageDialog(CSZFrame.this, "请输入正确的数字");
                } catch (RuntimeException ex) {
                    //数据重复输入
                    JOptionPane.showMessageDialog(CSZFrame.this, "数字重复输入");
                }
            }
        });
    }

    //抽象方法，具体代码由子类完成
    public abstract void run(String input);

    /*
    * 获取并验证：getInputAndValidate()
    *   1、获取每个文本框中的数据
    *   2、将字符串转化为数字
    *   3、判断结果随机数中是否包含文本框中的数据，如果包含，抛异常
    *   4、添加到结果数据
    * */
    private String getInputAndValidate() throws NumberFormatException, RuntimeException {
        //定义一个变量，用来记录数字
        String result = "";
        for(int i = 0; i < this.jTextFields.length; ++i) {
            String input = this.jTextFields[i].getText(); //获取到当前文本输入框中的数据
            //将当前的字符转化为数字，目的是为了检查字符是否为数字
            //转化的过程中如果不是数字字符，转换会报错（异常）
            if(input.length() != 1 || input.compareTo("0") < 0 || input.compareTo("9") > 0) {
                throw new NumberFormatException();
            }
            //int inputNum = Integer.parseInt(input); //NumberFormatException异常

            //判断结果数据中是否包含重复数字
            if(result.contains(input)) {
                //如果包含，抛出异常
                throw new RuntimeException("数字重复输入");
            }
            //将结果添加到结果字符串
            result += input;
        }
        return result; //返回输入的数据
    }

    //清空文本框中的数据clearTextField()
    public void clearTextFiled() {
        for(int i = 0; i < this.jTextFields.length; ++i) {
            this.jTextFields[i].setText("");
        }
    }

}
