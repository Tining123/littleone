package com.tining.littleone.tools.log;

import com.tining.littleone.tools.*;

import java.io.File;

/**
 * @ClassName FileLog
 * @Description TODO
 * @Author Tining
 * @data 2019/9/29 3:39
 * @Version 1.0
 **/
public class FileLog extends Log {

    ///默认存储文件路径
    public String defaultPath = "log.txt";

    /*
    *@Author Tining
    *@Description 构造函数
    *@Date 2019/9/30 4:44 
    *@Param []
    *@return 
    **/
    public FileLog(){
        this.limit = this.getLimit() * 1024;
    }

    /*
    *@Author Tining
    *@Description 获取日志
    *@Date 2019/9/30 4:59 
    *@Param []
    *@return java.lang.String
    **/
    @Override
    public String getLog() {
        return FileTools.read(defaultPath);
    }

    /*
    *@Author Tining
    *@Description 执行日志记录
    *@Date 2019/9/30 4:05 
    *@Param [msg, msgLevel]
    *@return void
    **/
    @Override
    public void logAction(String msg, int msgLevel) {
        FileTools.writeAppend(defaultPath,msg);
    }

    /*
    *@Author Tining
    *@Description 返回日志文件大小
    *@Date 2019/9/30 4:05 
    *@Param []
    *@return java.lang.String
    **/
    @Override
    public long getSize() {
        return FileTools.size(defaultPath);
    }

    /*
    *@Author Tining
    *@Description 平衡大小
    *@Date 2019/9/30 4:06 
    *@Param []
    *@return void
    **/
    @Override
    public void balanceSize(String msg,int msgLevel) {
        //如果过大则修改文件名
        //构建文件名
        String innerfix = TimeTools.getDigitNow() + MathTools.getRandomInt(1000,9999);
        String postfix = RegexTools.getFileType(defaultPath);
        String newname = defaultPath.replaceAll(postfix,innerfix) + postfix;

        FileTools.renameFile(defaultPath,newname);
    }
}
