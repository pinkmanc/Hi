package com.hi.library.hilog.utils;

import java.util.Arrays;

/**
 * @author JessPinkman
 * @date 2023-08-12/15:18
 **/
public class HiStackTraceUtil {
    public static  StackTraceElement[] getCropRealStackTrace(StackTraceElement[] stackTraceElements,String ignorePackageName,int maxDepth){
        return cropStackTraceElement(getRealStackTraceElement(stackTraceElements,ignorePackageName),maxDepth);
    }
    private static StackTraceElement[] getRealStackTraceElement(StackTraceElement[] stackTraceElements,String ignorePackageName){
        int realDepth=0;
        for (StackTraceElement stack:stackTraceElements
        ) {
            if (ignorePackageName!=null&&!stack.getClassName().startsWith(ignorePackageName)){
                realDepth= Arrays.asList(stackTraceElements).indexOf(stack);
                break;
            }
        }
        StackTraceElement[] realStack=new StackTraceElement[realDepth];
        System.arraycopy(stackTraceElements,0,realStack,0,realDepth);
        return realStack;
    }
   public static StackTraceElement[] cropStackTraceElement(StackTraceElement[] stackTraceElements,int maxDepth){
        int realDepth=stackTraceElements.length;
        if (stackTraceElements.length>0){
            realDepth=Math.min(realDepth,maxDepth);
        }
        StackTraceElement[] realStack=new StackTraceElement[realDepth];
        System.arraycopy(stackTraceElements,0,realStack,0,realDepth);
        return realStack;
    }
}
