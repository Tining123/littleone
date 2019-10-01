package com.tining.littleone.tools.log;

import java.security.PublicKey;

/**
 * @ClassName ConsoleLog
 * @Description TODO
 * @Author Tining
 * @data 2019/9/30 7:30
 * @Version 1.0
 **/
public class ConsoleLog extends Log {

    ///当前最新日志
    public String recentLog = "";

    /*
    *@Author Tining
    *@Description 返回日志，只存储最新一条
    *@Date 2019/9/30 7:37 
    *@Param []
    *@return java.lang.String
    **/
    @Override
    public String getLog() {
        return recentLog;
    }

    /*
    *@Author Tining
    *@Description 执行日志输出
    *@Date 2019/9/30 7:37 
    *@Param [msg, msgLevel]
    *@return void
    **/
    @Override
    public void logAction(String msg, int msgLevel) {
        this.recentLog = msg;
        System.out.println(msg);
    }

    /*
    *@Author Tining
    *@Description 返回日志容量，本类中固定为0
    *@Date 2019/9/30 7:36 
    *@Param []
    *@return long
    **/
    @Override
    public long getSize() {
        return 0;
    }

    /*
    *@Author Tining
    *@Description 平衡日志容量，在本类中无具体作用
    *@Date 2019/9/30 7:36 
    *@Param []
    *@return void
    **/
    @Override
    public void balanceSize(String msg,int msgLevel) {
        return;
    }
}
