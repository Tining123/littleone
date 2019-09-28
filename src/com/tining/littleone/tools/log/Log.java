package com.tining.littleone.tools.log;

/**
 * @ClassName FileTools
 * @Description 针对于字符串操作的工具类
 * @Author Tining
 * @data 2019/9/18 0:35
 * @Version 1.0
 **/
public abstract class Log {
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
    public abstract void log(String msg, int msgLevel);

    /*
     *@Author Tining
     *@Description 返回当前日志规模
     *@Date 2019/9/18 1:47
     *@Param void
     *@return String
     **/
    public abstract String getSize();

    /*
     *@Author Tining
     *@Description 修剪当前日志规模
     *@Date 2019/9/18 1:47
     *@Param void
     *@return void
     **/
    public abstract void balanceSize();
}
