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
    public static ArrayList<String> lineToList(String str){
        String[] arr = str.split("\n");
        return arrayToList(arr);

    }

    public static ArrayList<String> arrayToList(String[] arr){
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0 ; i < arr.length;i++)
            list.add(arr[i]);
        return list;
    }
}
