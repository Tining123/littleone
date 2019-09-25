package com.tining.littleone.tools;

import com.tining.littleone.tools.log.Log;

import java.io.*;

/**
 * @ClassName FileTools
 * @Description 针对于文件操作的工具类
 * @Author Tining
 * @data 2019/9/18 0:35
 * @Version 1.0
 **/
public class FileTools extends Tools{

    ///日志纪录类
    public static Log log;

    /*
    *@Author Tining
    *@Description 读取文件到字符串
    *@Date 2019/9/18 0:57
    *@Param [path]
    *@return java.lang.String
    **/
    public static String read(String path) {
        String text = null;
        try {
            // 在给定从中读取数据的文件名的情况下创建一个新 FileReader
            FileReader fr = new FileReader(path);
            // 创建一个使用默认大小输入缓冲区的缓冲字符输入流
            BufferedReader br = new BufferedReader(fr);
            String string = null;
            text = br.readLine();
            //如果为空返回空
            if (text == null)
                return text;
            text = "";
            while (null != (string = br.readLine())) {
                text += string;
            }
        } catch (Exception e) {
            if(log != null)
                log.log(e);
            else e.printStackTrace();
        }
        //确保此步已经返回非空
        return text;
    }

    /*
    *@Author Tining
    *@Description 写字符串到文件中，如果没有，则创建文件，这将会复写文件
    *@Date 2019/9/18 1:05
    *@Param [text, path]
    *@return void
    **/
    public static boolean write(String text,String path){
        File file = new File(path);
        FileWriter fw;
        //测试文件是否存在,如果不存在则创建
        try {
            if(!file.exists()) {
                    file.createNewFile();
            }
            fw = new FileWriter(file);
            fw.write(text);
        }catch (Exception e){
            log.log(e);
            return false;
        }
        return true;
    }

    /*
     *@Author Tining
     *@Description 追加写字符串到文件中，如果没有，则创建文件
     *@Date 2019/9/18 1:05
     *@Param [text, path]
     *@return void
     **/
    public static boolean writeAppend(String text,String path){
        File file = new File(path);
        FileWriter fw;
        BufferedWriter bw;
        //测试文件是否存在,如果不存在则创建
        if(!file.exists()) {
            try {
                file.createNewFile();
            }catch (Exception e){
                log.log(e);
                return false;
            }
        }
        try {
            fw = new FileWriter(file,true);
            fw.write(text);
        }catch (Exception e){
            log.log(e);
            return false;
        }
        return true;
    }

    public static boolean renameFile(String name, String newName){
        File file = new File(name);
        File newFile = new File(newName);
        return file.renameTo(newFile);
    }
}
