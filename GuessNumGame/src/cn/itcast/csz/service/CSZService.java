package cn.itcast.csz.service;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 朱潇翔 on 2016/12/12.
 */
/*
* 游戏核心业务处理
* */
public class CSZService {
    private int count; //游戏猜过的次数
    private final int MAXCOUNT = 10;
    private String[] results = new String[MAXCOUNT]; //分析结果的数据
    private String random; //随机数

    /*
    * 生成四位随机数：init()
    *   1、次数清零
    *   2、结果数据初始化
    *   3、产生没有重复数字的四位随机数
    * */

    public CSZService() {

    }
    public void init() {
        //游戏已进行次数初始化
        this.count = 0;
        //分析结果初始化
        for(int i = 0; i < this.results.length; ++i) {
            this.results[i] = "";
        }
        /*
        * 产生随机数:
        *   1、准备好0~9之间的10个数
        *   2、随机产生数字，从箱子中跳出对应数字（eg：福利彩票）
        *       产生四个
        * */
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i = 0; i < 10; ++i) {
            arrayList.add(i+"");
        }
        //清空原有的随机数
        this.random = "";
        Random rand = new Random();
        //产生随机数
        for(int i = 0; i < 4; ++i) {
            //rand.nextInt(10) 产生0~9之间的一个随机数
            String data = arrayList.remove(rand.nextInt(10-i)); //从箱子中随机的弹出一个数字
            this.random += data;
        }
        //System.out.println(this.random);
    }

    /*
    * 比较输入的数是否正确
    * */
    public boolean equalsRondom(String input) {
        return this.random.equals(input);
    }

    /*
    * 生成0A0B
    * */
    public void createResult(String input) {
        int countA = 0; //记录数字位置正确的个数
        int countB = 0;
        for(int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);//获取输入数字的每位input[i]
            if(this.random.contains(ch+"")) {
                //判断大字符串是否包含小字符串
                if(this.random.charAt(i) == ch) {
                    ++countA;
                }
                else {
                    ++countB;
                }
            }
        }
        //拼接结果 1>：1234--xAxB
        String result = countA + "A" + countB + "B";
        this.results[this.count++] = this.count + ">：" + input + "--" + result;
    }
     /*
    * 获得游戏进行的次数
    * */
    public int getCount() {
        return this.count;
    }

    public int getMaxCount() {
        return this.MAXCOUNT;
    }

    public String[] getResults() {
        return this.results;
    }

    public String getRandom() {
        return this.random;
    }
  }
