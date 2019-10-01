package com.tining.littleone.tools.log;

import com.tining.littleone.tools.StringTools;
import com.tining.littleone.tools.TimeTools;

import java.util.ArrayList;

/**
 * @ClassName QueueLog
 * @Description 消息队列型日志
 * @Author Tining
 * @data 2019/9/30 4:22
 * @Version 1.0
 **/
public class QueueLog extends Log{

    ///日志载体列表
    ArrayList<String> logList = new ArrayList<>();

    /*
    *@Author Tining
    *@Description 获取日志
    *@Date 2019/9/30 5:00 
    *@Param []
    *@return java.lang.String
    **/
    @Override
    public String getLog() {
        return StringTools.listToLine(logList);
    }

    /*
    *@Author Tining
    *@Description 记录日志操作
    *@Date 2019/9/30 5:00 
    *@Param [msg, msgLevel]
    *@return void
    **/
    @Override
    public void logAction(String msg, int msgLevel) {
        logList.add(msg);
    }

    /*
    *@Author Tining
    *@Description 获取日志大小
    *@Date 2019/9/30 5:00 
    *@Param []
    *@return long
    **/
    @Override
    public long getSize() {
        return logList.size();
    }

    /*
    *@Author Tining
    *@Description 进行日志平衡
    *@Date 2019/9/30 5:01 
    *@Param []
    *@return void
    **/
    @Override
    public void balanceSize(String msg,int msgLevel) {
        if(logList.size() <= 0)
            return;
        logList.remove(0);
    }
}
