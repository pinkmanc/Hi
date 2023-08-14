package com.hi.library.hilog;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author JessPinkman
 * @date 2023-08-02/14:50
 **/
public class HiLogMo {
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    public long timeMillis;
    public int level;
    public String tag;
    public String log;

    public HiLogMo(long timeMillis, int level, String tag, String log) {
        this.timeMillis = timeMillis;
        this.level = level;
        this.tag = tag;
        this.log = log;
    }
    public String flattenedLog(){
        return getFlattened()+"\n"+log;
    }
    public String getFlattened(){
        return format(timeMillis)+' '+tag+' '+ levelConvert(level);
    }
    public String format(long timeMillis){
        return sdf.format(timeMillis);
    }
    public String levelConvert(int level){
        switch (level) {
            case 2:
                return "VERBOSE:";
            case 3:
                return "DEBUG:";
            case 4:
                return "INFO:";
            case 5:
                return "WARN:";
            case 6:
                return "ERROR:";
            case 7:
                return "ASSERT:";
            default:
                return "UNKNOWN:";
        }
    }

}
