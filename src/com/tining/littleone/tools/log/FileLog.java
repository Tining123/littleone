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

    @Override
    public void log(String msg, int msgLevel) {
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
