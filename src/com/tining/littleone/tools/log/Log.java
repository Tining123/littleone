package com.tining.littleone.tools.log;

import com.tining.littleone.tools.Tools;

/**
 * @InterfaceName Log
 * @Description 日志工具类的接口
 * @Author Tining
 * @data 2019/9/18 1:20
 * @Version 1.0
 **/
public interface Log extends Tools {
    
    /*
    *@Author Tining
    *@Description 记录日志
    *@Date 2019/9/18 1:47
    *@Param [obj]
    *@return void
    **/
    public void log(Object obj);
}
