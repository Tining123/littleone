package com.tining.littleone.tools;

import java.util.ArrayList;

/**
 * @ClassName FileTools
 * @Description 针对于字符串操作的工具类
 * @Author Tining
 * @data 2019/9/18 0:35
 * @Version 1.0
 **/
public class StringTools extends Tools{
    /*
    *@Author Tining
    *@Description 把字符串按行转成list
    *@Date 2019/9/19 22:09 
    *@Param [str]
    *@return java.util.ArrayList<java.lang.String>
    **/
    public static ArrayList<String> lineToList(String str){
        String[] arr = str.split("\n");
        return arrayToList(arr);

    }

    /*
     *@Author Tining
     *@Description 把list按行转成转换成字符串
     *@Date 2019/9/19 22:09
     *@Param [java.util.ArrayList<java.lang.String>]
     *@return String
     **/
    public static String listToLine(ArrayList<String> list){
        String line = "";
        for(int i = 0 ; i < list.size();i++)
        {
            line+= list.get(i);
            line+="\n";
        }
        return line;
    }

    /*
     *@Author Tining
     *@Description 把字符串数组按行转成转换成字符串
     *@Date 2019/9/19 22:09
     *@Param [String[]]
     *@return String
     **/
    public static String listToLine(String[] arr){
        return listToLine(arrayToList(arr));
    }

    /*
    *@Author Tining
    *@Description 把数组转换成list
    *@Date 2019/9/19 22:11
    *@Param [arr]
    *@return java.util.ArrayList<java.lang.String>
    **/
    public static ArrayList<String> arrayToList(String[] arr){
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0 ; i < arr.length;i++)
            list.add(arr[i]);
        return list;
    }

}
