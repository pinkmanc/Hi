package com.hi.library.hilog.utils;

import java.util.Arrays;

/**
 * @author JessPinkman
 * @date 2023-08-12/15:18
 **/
public class HiStackTraceUtil {
    public static StackTraceElement[] getCropRealStackTrack(StackTraceElement[] stackTrace,String ignorePackage){
        return getRealStackTrace(stackTrace,ignorePackage);
    }
    private static StackTraceElement[] getRealStackTrace(StackTraceElement[] stackTrace,String ignorePackage){

        int ignoreDepth=0;
        int allDepth=stackTrace.length;
        String className;
        for (int i = allDepth-1; i>0 ; i--) {
            className=stackTrace[i].getClassName();
            if(ignorePackage!=null&&className.startsWith(ignorePackage)){
                ignoreDepth=i+1;
                break;
            }
        }
        int realDepth=allDepth-ignoreDepth;
        StackTraceElement[] realStack=new StackTraceElement[realDepth];
        System.arraycopy(stackTrace,ignoreDepth,realStack,0,realDepth);
        return realStack;

    }

}
