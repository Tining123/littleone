package com.tining.littleone.tools.log;

import com.tining.littleone.tools.TimeTools;

import java.sql.Time;

/**
 * @ClassName FileTools
 * @Description 针对于字符串操作的工具类
 * @Author Tining
 * @data 2019/9/18 0:35
 * @Version 1.0
 **/
public abstract class Log {

    ///判断消息等级相等
    public MsgLevelCompare equal = (msgLevel ,defaultLevel) -> msgLevel == defaultLevel;

    ///判断消息等级高于
    public MsgLevelCompare higherthan = (msgLevel ,defaultLevel) -> msgLevel >= defaultLevel;

    ///判断消息等级低于
    public MsgLevelCompare lowerthan = (msgLevel ,defaultLevel) -> msgLevel <= defaultLevel;

    ///默认消息记录等级
    public int defaultLevel = 0;

    ///默认消息规模限制
    public int limit = 500;

    ///默认消息等级顺序反馈
    public boolean isOrderLevel = true;

    ///默认消息多层反馈模式
    public boolean isLayerModel = true;

    ///默认消息反馈等级
    public int defaultReadLevel = 0;

    ///最新日志时间戳
    public String logTimeIndex = "";
    
    /*
    *@Author Tining
    *@Description 获取最新日志时间戳
    *@Date 2019/9/30 7:26 
    *@Param []
    *@return java.lang.String
    **/
    public String getLogTimeIndex(){return this.logTimeIndex;}
    
    /*
    *@Author Tining
    *@Description 设置最新日志时间戳
    *@Date 2019/9/30 7:25 
    *@Param [logTimeIndex]
    *@return void
    **/
    public void setLogTimeIndex(String logTimeIndex){this.logTimeIndex = logTimeIndex;}

    /*
    *@Author Tining
    *@Description 获取默认消息反馈等级
    *@Date 2019/9/30 4:31 
    *@Param []
    *@return int
    **/
    public int getDefaultReadLevel(){return this.defaultReadLevel;}

    /*
    *@Author Tining
    *@Description 设置默认消息反馈等级
    *@Date 2019/9/30 4:30 
    *@Param [defaultReadLevel]
    *@return void
    **/
    public void setDefaultReadLevel(int defaultReadLevel){this.defaultReadLevel = defaultReadLevel;}

    /*
    *@Author Tining
    *@Description 获取是否设置使用多层消息反馈模式
    *@Date 2019/9/30 4:26 
    *@Param []
    *@return boolean
    **/
    public boolean getLayerModel(){return this.isLayerModel;}
    
    /*
    *@Author Tining
    *@Description 设置是否使用消息多层反馈模式
    *@Date 2019/9/30 4:26 
    *@Param [isLayerModel]
    *@return boolean
    **/
    public void setLayerModel(Boolean isLayerModel){this.isLayerModel = isLayerModel;}

    /*
    *@Author Tining
    *@Description 返回是否设置等级顺序反馈
    *@Date 2019/9/30 4:24 
    *@Param []
    *@return boolean
    **/
    public boolean getOrderLevel(){return this.isOrderLevel;}
    
    /*
     *@Author Tining
     *@Description 设置是否等级顺序反馈
     *@Date 2019/9/19 22:32
     *@Param void
     *@return int
     **/
    public void setOrderLevel(boolean isOrderLevel){this.isOrderLevel = isOrderLevel;}

    /*
     *@Author Tining
     *@Description 返回消息规模限制
     *@Date 2019/9/19 22:32
     *@Param void
     *@return int
     **/
    public int getLimit(){return this.limit;}

    /*
     *@Author Tining
     *@Description 设置消息规模限制
     *@Date 2019/9/19 22:32
     *@Param int
     *@return void
     **/
    public void setLimit(int limit){this.limit = limit;}

    /*
    *@Author Tining
    *@Description 返回默认消息等级
    *@Date 2019/9/19 22:32
    *@Param []
    *@return int
    **/
    public int getDefaultLevel(){return  this.defaultLevel;}

    /*
    *@Author Tining
    *@Description 设置默认消息等级
    *@Date 2019/9/19 22:33
    *@Param [level]
    *@return void
    **/
    public void setDefaultLevel(int level){this.defaultLevel = level;}

    /*
    *@Author Tining
    *@Description 默认构造函数
    *@Date 2019/9/19 23:01 
    *@Param []
    *@return 
    **/
    public Log(){}

    /*
    *@Author Tining
    *@Description 设置默认消息级别的构造函数
    *@Date 2019/9/19 23:02 
    *@Param [defaultLevel]
    *@return 
    **/
    public Log(int defaultLevel){this.defaultLevel = defaultLevel;}
    
    /*
     *@Author Tining
     *@Description 记录日志，采用异常类型
     *@Date 2019/9/18 1:47
     *@Param [obj]
     *@return void
     **/
    public void log(Exception e){e.printStackTrace();}

    /*
     *@Author Tining
     *@Description 记录日志，采用字符串消息
     *@Date 2019/9/18 1:47
     *@Param [obj]
     *@return void
     **/
    public void log(String msg){log(msg,this.defaultLevel);}

    /*
     *@Author Tining
     *@Description 记录日志，采用字符串消息，并且设定消息等级
     *@Date 2019/9/18 1:47
     *@Param [obj]
     *@return void
     **/
    public void log(String msg, int msgLevel){
        String timeIndex = TimeTools.getNow();
        logTimeIndex = timeIndex;
        msg = buildMessage(msg,msgLevel,timeIndex);
        if(!msgPass(msgLevel)){
            System.out.println(msg);
            return;
        }
        if(getSize()>limit)
            balanceSize(msg,msgLevel);
        logAction(msg,msgLevel);
    }

    /*
    *@Author Tining
    *@Description 消息过滤函数
    *@Date 2019/9/30 7:11 
    *@Param [msgLevel]
    *@return boolean
    **/
    public boolean msgPass(int msgLevel){
        MsgLevelCompare mlc = equal;
        if(isLayerModel)
            mlc = equal;
        else if(isOrderLevel)
            mlc = lowerthan;
        else mlc = higherthan;

        return mlc.levelSolve(msgLevel,defaultLevel);
    }

    /*
    *@Author Tining
    *@Description 构造消息前缀
    *@Date 2019/9/30 4:52
    *@Param []
    *@return java.lang.String
    **/
    public String buildMessage(String msg, int msgLevel, String timeStr){
        String result = timeStr + "|level " + msgLevel + "|" + msg;
        return result;
    }
    
    /*
    *@Author Tining
    *@Description 获取日志
    *@Date 2019/9/30 4:57 
    *@Param []
    *@return java.lang.String
    **/
    public abstract String getLog();
    
    /*
    *@Author Tining
    *@Description 日志记录执行
    *@Date 2019/9/30 4:15 
    *@Param [msg, msgLevel]
    *@return void
    **/
    public abstract void logAction(String msg,int msgLevel);

    /*
     *@Author Tining
     *@Description 返回当前日志规模
     *@Date 2019/9/18 1:47
     *@Param void
     *@return String
     **/
    public abstract long getSize();

    /*
     *@Author Tining
     *@Description 修剪当前日志规模
     *@Date 2019/9/18 1:47
     *@Param void
     *@return void
     **/
    public abstract void balanceSize(String msg, int msgLevel);

    /**
     * @InterfaceName MsgCompare
     * @Description 针对于消息等级过滤操作
     * @Author Tining
     * @data 2019/9/18 0:35
     * @Version 1.0
     **/
    public interface MsgLevelCompare{
        /*
        *@Author Tining
        *@Description 等级操作函数
        *@Date 2019/9/30 7:01 
        *@Param [msgLevel]
        *@return boolean
        **/
        boolean levelSolve(int msgLevel, int defaultLevel);
    }
}
