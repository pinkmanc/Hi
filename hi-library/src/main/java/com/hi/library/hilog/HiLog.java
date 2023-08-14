package com.hi.library.hilog;

import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.NonNull;

import com.hi.library.hilog.utils.HiStackTraceUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author JessPinkman
 * @date 2023-08-09/16:55
 **/
public class HiLog {
    private static final String HI_LOG_PACKAGE ;

    static {
        String className=HiLog.class.getName();
        HI_LOG_PACKAGE=className.substring(0,className.lastIndexOf(".")+1);
    }
    public static void v(Object...objects){
        log(HiLogType.V,objects);
    }
    public static void d(Object... objects){
        log(HiLogType.D,objects);
    }
    public static void i(Object... objects){
        log(HiLogType.I,objects);
    }
    public static void w(Object... objects){
        log(HiLogType.W,objects);
    }
    public static void e(Object... objects){
        log(HiLogType.E,objects);
    }
    public static void a(Object... objects){
        log(HiLogType.A,objects);
    }
    static void log(@Type int type,Object...objects){
        log(type,HiLogManager.getInstance().getConfig().getGlobalTag(),objects);
    }
    static void log(@Type int type,String tag,@NonNull Object...objects){
        log(HiLogManager.getInstance().getConfig(), type,tag,objects);
    }
    public static void log(@NonNull HiLogConfig config, @Type int type, @NonNull String tag, @NonNull Object...objects){
        if (!config.enable()){;
            return;
        }
        StringBuilder stringBuilder=new StringBuilder();
        if (config.addThreadInfo()){
            String threadInfo=HiLogConfig.HI_THREAD_FORMATTER.format(Thread.currentThread());
            stringBuilder.append(threadInfo).append("\n");
        }
        if (config.addStackTraceInfo()){

            String stackTrace= HiLogConfig.HI_STACK_TRACE_FORMATTER.format(HiStackTraceUtil.getCropRealStackTrack(new Throwable().getStackTrace(),HI_LOG_PACKAGE,config.stackTraceDepth()));
            stringBuilder.append(stackTrace).append("\n");
        }
        List<HiLogPrinter> printers=config.getGlobalPrinters()!=null? Arrays.asList(config.getGlobalPrinters()): HiLogManager.getInstance().getPrinters();
        if (printers==null){
            return;
        }
        stringBuilder.append(parserObjects(objects,config));
        for (HiLogPrinter printer:printers
             ) {
            printer.print(type,tag,stringBuilder);

        }
    }
    private static String parserObjects(@NonNull Object[] contents,@NonNull HiLogConfig config){
        if(config.injectJsonParser()!=null){
            return config.injectJsonParser().toJson(contents);
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (Object  o:contents){
            stringBuilder.append(o.toString()).append(";");
        }
        if(stringBuilder.length()>0){
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        return stringBuilder.toString();
    }
}
