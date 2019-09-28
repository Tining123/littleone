package com.tining.codetools;

import com.tining.littleone.tools.StringTools;
import com.tining.littleone.tools.TimeTools;

import java.util.ArrayList;

/**
 * @ClassName GetSetGenerator
 * @Description 配置器生成工具
 * @Author Tining
 * @data 2019/9/26 0:24
 * @Version 1.0
 **/
public class GetSetGenerator {

    /*
    *@Author Tining
    *@Description 执行构造
    *@Date 2019/9/26 0:47
    *@Param [str]
    *@return java.lang.String
    **/
    public static void main(String[] arg){
        String get = "///默认消息规模限制\n" +
                "    protected int limit = 500;\n" +
                "\n" +
                "    ///默认消息等级顺序反馈\n" +
                "    protected boolean isOrderLevel = true;\n" +
                "\n" +
                "    ///默认消息多层反馈模式\n" +
                "    protected boolean isLayerModel = true;\n" +
                "\n" +
                "    ///默认消息反馈等级\n" +
                "    protected int defaultReadLevel = 0;";
        System.out.println(generateGS(get));
    }

    /*
    *@Author Tining
    *@Description 生成类属性的get，set配置器
    *@Date 2019/9/26 0:47 
    *@Param [str]
    *@return java.lang.String
    **/
    public static String generateGS(String str){
        String result = "";
        //字符串列表化
        ArrayList<String> list = StringTools.lineToList(str);
        list = StringTools.cleanListOut(list);
        //每两行为单位一次调整
        for(int i = 0 ; i < list.size();i=i+2){
            //取得属性具体描述
            String descrip = list.get(i).replaceAll("///","");
            //取得声明行数组
            String[] arr = list.get(i+1).split(" ");
            result += buildSingleGS(descrip,arr);
        }
        return result;
    }
    
    /*
    *@Author Tining
    *@Description 构建单个属性的构造器
    *@Date 2019/9/26 0:47 
    *@Param [des, arr]
    *@return java.lang.String
    **/
    public static String buildSingleGS(String des, String[] arr){
        String result = "";
        //取出类型
        String type = arr[1];
        //取出名称
        String name = arr[2];
        //清除名称前缀
        String originName = name;
        if(name.indexOf("is") == 0){
            if(name.charAt(2)!=  name.toLowerCase().charAt(2)){
                name = name.replaceFirst("is","");
            }
        }
        //提升名称第一个字母
        String first = name.charAt(0) + "";
        String upfirst = first.toUpperCase();
        name = name.replaceFirst(first,upfirst);
        //加上取出器注释
        String preix = "/*\n" +
                "*@Author Tining\n" +
                "*@Description 返回" + des + "\n" +
                "*@Date "+ TimeTools.getNow() +"\n" +
                "*@Param void\n" +
                "*@return " + type + "\n" +
                "**/";
        //先构造取出器Get
        result = preix + result;
        result += "public " + type + " get"+ upfirst +"()" + "\n{return this."+originName+";}" +"\n";
        result += "\n";
        //构造设置器
        preix = "/*\n" +
                "*@Author Tining\n" +
                "*@Description 设置" + des + "\n" +
                "*@Date "+ TimeTools.getNow() +"\n" +
                "*@Param " + type + "\n" +
                "*@return void\n" +
                "**/";
        result += "public " + type + " set"+ upfirst +"("+ type + " " + name + ")" + "\n{this."+originName+" = "+originName+";}" +"\n";
        result += "\n";
        return result;
    }

}