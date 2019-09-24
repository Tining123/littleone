package com.tining.littleone.tools.log;

public abstract class Log {
    ///默认消息等级
    public int defaultLevel = 0;

    /*
    *@Author Tining
    *@Description 返回默认消费等级
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
    public abstract void log(Exception e);

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
}
