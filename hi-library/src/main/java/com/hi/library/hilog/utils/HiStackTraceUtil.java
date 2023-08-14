package com.hi.library.hilog.utils;

import java.util.Arrays;

/**
 * @author JessPinkman
 * @date 2023-08-12/15:18
 **/
public class HiStackTraceUtil {
    public static StackTraceElement[] getCropRealStackTrack(StackTraceElement[] stackTrace,String ignorePackage,int maxDepth){
        return cropStackTrace(getRealStackTrace(stackTrace,ignorePackage),maxDepth);
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
    private static StackTraceElement[] cropStackTrace(StackTraceElement[] callStack,int maxDepth){
        int realDepth=callStack.length;
        if(maxDepth>0){
            realDepth=Math.min(maxDepth,realDepth);
        }
        StackTraceElement[] realStack=new StackTraceElement[realDepth];
        System.arraycopy(callStack,0,realStack,0,realDepth);
        return realStack;
    }
}