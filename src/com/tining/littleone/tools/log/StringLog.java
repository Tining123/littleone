package com.tining.littleone.tools.log;

import com.tining.littleone.tools.StringTools;

/**
 * @ClassName StringLog
 * @Description 以字符串形式存储的日志
 * @Author Tining
 * @data 2019/9/30 7:39
 * @Version 1.0
 **/
public class StringLog extends Log{

    ///存储日志的字符串
    public String logString = "";

    /*
     *@Author Tining
     *@Description 返回存储日志的字符串
     *@Date 2019/09/30 07:57:49
     *@Param void
     *@return String
     **/public String getLogString(){return this.logString;}

    /*
     *@Author Tining
     *@Description 设置存储日志的字符串
     *@Date 2019/09/30 07:57:49
     *@Param String
     *@return void
     **/
    public void setLogString(String logString){this.logString = logString;}

    /*
    *@Author Tining
    *@Description 返回当前日志字符串
    *@Date 2019/9/30 8:09 
    *@Param []
    *@return java.lang.String
    **/
    @Override
    public String getLog() {
        return this.logString;
    }

    /*
    *@Author Tining
    *@Description 记录当前日志
    *@Date 2019/9/30 8:09 
    *@Param [msg, msgLevel]
    *@return void
    **/
    @Override
    public void logAction(String msg, int msgLevel) {
        if(!StringTools.isStringEmpty(logString))
            logString +="\n";
        logString+=msg;
    }

    /*
    *@Author Tining
    *@Description 获取日志长度
    *@Date 2019/9/30 8:10 
    *@Param []
    *@return long
    **/
    @Override
    public long getSize() {
        return logString.length();
    }

    /*
    *@Author Tining
    *@Description 平衡文本，这个类的操作是折半
    *@Date 2019/9/30 8:14
    *@Param []
    *@return void
    **/
    @Override
    public void balanceSize(String msg,int msgLevel) {
        logString = logString.substring(logString.length() / 2, logString.length() - 1);
    }
}
