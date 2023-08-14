package com.hi.library.hilog;

/**
 * @author JessPinkman
 * @date 2023-08-09/17:10
 **/
public abstract class HiLogConfig {
    public static final int MAX_LEN=512;
    static HiThreadFormatter HI_THREAD_FORMATTER=new HiThreadFormatter();
    static HiStackElementFormatter HI_STACK_TRACE_FORMATTER=new HiStackElementFormatter();
    public String getGlobalTag(){
        return "HI";
    }
    public boolean enable(){
        return false;
    }
    public boolean addThreadInfo(){
        return false;
    }
    public boolean addStackTraceInfo(){
        return false;
    }
    public HiLogPrinter getGlobalPrinters(){
        return null;
    }

    public JsonParser injectJsonParser() {
        return null;
    }
}
