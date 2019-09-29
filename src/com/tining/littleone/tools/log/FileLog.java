package com.tining.littleone.tools.log;

import com.tining.littleone.tools.FileTools;
import com.tining.littleone.tools.Tools;

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

    ///文件大小乘积倍数基数
    public int sizebase = 1024;

    @Override
    public void log(String msg, int msgLevel) {
        //检测文件大小是否过大
        if(getSize().length() > limit * sizebase){
            //如果过大则修改文件名
        }
        FileTools.writeAppend(defaultPath,msg);
    }

    @Override
    public String getSize() {
        return FileTools.size(defaultPath) + "";
    }

    @Override
    public void balanceSize() {

    }
}
