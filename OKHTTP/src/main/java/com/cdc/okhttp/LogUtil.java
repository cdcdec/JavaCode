package com.cdc.okhttp;


import java.util.logging.Logger;

public class LogUtil {
    private static Logger logger=Logger.getLogger("cdcOkHttp");

    public static void w(String str){
        logger.warning(str);

    }
}
