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

    ///判断字符串互相包含
    public static StringCompare with = (str1,str2) -> str1.contains(str2);

    ///判断字符串不互相包含
    public static StringCompare without = (str1,str2) -> !str1.contains(str2);

    ///判断字符串相等
    public static StringCompare is = (str1, str2) -> str1.trim() == str2.trim();

    ///判断字符串互相不相等
    public static StringCompare isnot = (str1, str2) -> str1.trim() != str2.trim();

    /*
    *@Author Tining
    *@Description 替换掉最后一个符合的字符串
    *@Date 2019/9/26 23:39
    *@Param [text, regex, replacement]
    *@return java.lang.String
    **/
    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)"+regex+"(?!.*?"+regex+")", replacement);
    }

    /*
    *@Author Tining
    *@Description 剪切出符合两端字符串中间的内容
    *@Date 2019/9/26 23:40 
    *@Param [begin, end, str]
    *@return java.lang.String
    **/
    public static String cutInner(String begin,String end,String str){
        int beginindex = str.indexOf(begin);
        int endindex = str.indexOf(end);
        String get = str.substring(beginindex+begin.length(),endindex);
        return get;
    }

    /*
    *@Author Tining
    *@Description 清除list中的空白行和每一行前后空白
    *@Date 2019/9/26 3:12 
    *@Param [list]
    *@return java.util.ArrayList<java.lang.String>
    **/
    public static ArrayList<String> cleanListOut(ArrayList<String> list){
        list = trimList(list);
        list = cleanBlankLine(list);
        return list;
    }

    /*
    *@Author Tining
    *@Description 清除list中每一项的前后空白
    *@Date 2019/9/26 3:04 
    *@Param [list]
    *@return java.util.ArrayList<java.lang.String>
    **/
    public static ArrayList<String> trimList(ArrayList<String> list){
        for(int i = 0 ; i< list.size();i++)
        {list.set(i,list.get(i).trim());}
        return list;
    }

    /*
    *@Author Tining
    *@Description 清除list中的空白项
    *@Date 2019/9/26 2:59
    *@Param [list]
    *@return java.util.ArrayList<java.lang.String>
    **/
    public static ArrayList<String> cleanBlankLine(ArrayList<String> list){
        return cleanListIs(list,"");
    }

    /*
    *@Author Tining
    *@Description 清除list中不是str的项
    *@Date 2019/9/26 23:53
    *@Param [list, str]
    *@return java.util.ArrayList<java.lang.String>
    **/
    public static ArrayList<String> cleanListIsNot(ArrayList<String> list, String str){
        return cleanlist(list,lineToList(str),isnot);
    }

    /*
     *@Author Tining
     *@Description 清除list中不是str的项
     *@Date 2019/9/26 23:53
     *@Param [list, str]
     *@return java.util.ArrayList<java.lang.String>
     **/
    public static ArrayList<String> cleanListIsNot(ArrayList<String> list, ArrayList<String> strlist){
        return cleanlist(list,strlist,isnot);
    }

    /*
    *@Author Tining
    *@Description 清除列表中是str的项
    *@Date 2019/9/26 23:53
    *@Param [list, str]
    *@return java.util.ArrayList<java.lang.String>
    **/
    public static ArrayList<String> cleanListIs(ArrayList<String> list, String str){
        return cleanlist(list,lineToList(str),is);
    }

    /*
     *@Author Tining
     *@Description 清除列表中是str的项
     *@Date 2019/9/26 23:53
     *@Param [list, str]
     *@return java.util.ArrayList<java.lang.String>
     **/
    public static ArrayList<String> cleanListIs(ArrayList<String> list, ArrayList<String> strlist){
        return cleanlist(list,strlist,is);
    }

    /*
    *@Author Tining
    *@Description 清除list中不含有str的项
    *@Date 2019/9/26 23:53
    *@Param [list, str]
    *@return java.util.ArrayList<java.lang.String>
    **/
    public static ArrayList<String> cleanListWithout(ArrayList<String> list, String str){
        return cleanlist(list,lineToList(str),without);
    }

    /*
     *@Author Tining
     *@Description 清除list中不含有str的项
     *@Date 2019/9/27 2:48
     *@Param [list, strlist]
     *@return java.util.ArrayList<java.lang.String>
     **/
    public static ArrayList<String> cleanListWithout(ArrayList<String> list, ArrayList<String> strlist){
        return cleanlist(list,strlist,without);
    }



    /*
    *@Author Tining
    *@Description 清除list中含有str的项
    *@Date 2019/9/27 0:39
    *@Param [list, str]
    *@return java.util.ArrayList<java.lang.String>
    **/
    public static ArrayList<String> cleanListWith(ArrayList<String> list, String str){
        return cleanlist(list,lineToList(str),with);
    }

    /*
     *@Author Tining
     *@Description 清除list中含有str的项
     *@Date 2019/9/27 0:39
     *@Param [list, str]
     *@return java.util.ArrayList<java.lang.String>
     **/
    public static ArrayList<String> cleanListWith(ArrayList<String> list, ArrayList<String> strlist){
        return cleanlist(list,strlist,with);
    }

    /*
    *@Author Tining
    *@Description 将符合条件的字段从list删除
    *@Date 2019/9/29 2:07
    *@Param [list1, list2, sc]
    *@return java.util.ArrayList<java.lang.String>
    **/
    public static ArrayList<String> cleanlist(ArrayList<String> list1,ArrayList<String> list2, StringCompare sc){
        for(int i = 0 ; i< list1.size();i++){
            for(int j =0 ; j < list2.size();j++)
            if(sc.solve(list1.get(i),list2.get(j))){
                list1.remove(i);
                i--;
            }
        }
        return list1;
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

    /**
     * @InterfaceName StringCompare
     * @Description 对于双字符串操作的函数委托
     * @Author Tining
     * @data 2019/9/18 0:35
     * @Version 1.0
     **/
    public interface StringCompare{
        boolean solve(String str1,String str2);
    }
}
