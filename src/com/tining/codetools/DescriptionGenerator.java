package com.tining.codetools;

import com.tining.littleone.tools.StringTools;
import com.tining.littleone.tools.TimeTools;

/**
 * @ClassName DescriptionGenerator
 * @Description 注释生成工具
 * @Author Tining
 * @data 2019/9/26 0:24
 * @Version 1.0
 **/
public class DescriptionGenerator {

    /*
    *@Author Tining
    *@Description 执行生成
    *@Date 2019/9/27 0:09
    *@Param [arg]
    *@return void
    **/
    public static void main(String[] arg){
        System.out.println(classDesGenerator(""));
        System.out.println();
        System.out.println(functionDesGenerator("public static String functionDesGenerator(String functionclaim){"));
    }

    /*
    *@Author Tining
    *@Description 生成类注释
    *@Date 2019/9/27 0:09 
    *@Param [classname]
    *@return java.lang.String
    **/
    public static String classDesGenerator(String classname){
        String prefix = "/**\n" +
                " * @ClassName " + classname + "\n" +
                " * @Description \n" +
                " * @Author Tining\n" +
                " * @data " + TimeTools.getNow() + "\n" +
                " * @Version 1.0\n" +
                " **/";
        return prefix;
    }

    /*
    *@Author Tining
    *@Description 生成函数注释
    *@Date 2019/9/27 0:09 
    *@Param [functionclaim]
    *@return java.lang.String
    **/
    public static String functionDesGenerator(String functionclaim){
        //取消掉静态符
        functionclaim = functionclaim.replaceAll(" static","");
        //分隔出各个部分
        String[] arr = functionclaim.split(" ");
        //取出参数
        String cutStr = StringTools.cutInner("(",")", functionclaim);
        //加工参数
        String paramline = "[]";
        if(cutStr.trim().length() != 0) {
            //取出参数
            String[] param = cutStr.split(",");
            //制作参数行
            paramline = "[";
            for (int i = 0; i < param.length; i++) {
                paramline += param[i].split(" ")[1].trim() + ", ";
            }
            paramline = paramline + "]";
        }

        String prefix = "/*\n" +
                "    *@Author Tining\n" +
                "    *@Description \n" +
                "    *@Date " + TimeTools.getNow() + " \n" +
                "    *@Param " + paramline + "\n" +
                "    *@return " + arr[1] + "\n" +
                "    **/";
        return prefix;
    }
}
