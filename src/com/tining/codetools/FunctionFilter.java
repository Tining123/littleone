package com.tining.codetools;

import com.tining.littleone.tools.StringTools;

import java.util.ArrayList;

/**
 * @ClassName FunctionFilter
 * @Description 过滤出函数声明的工具
 * @Author Tining
 * @data 2019/9/26 0:24
 * @Version 1.0
 **/
public class FunctionFilter {

    public static ArrayList<String> functionFilter(String str){
        //改编成list
        ArrayList<String> get = StringTools.lineToList(str);
        //取出空值项
        get = StringTools.cleanBlankLine(get);
        //取出注释
    }
}
