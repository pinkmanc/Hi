package com.hi.library.hilog;


import static com.hi.library.hilog.HiLogConfig.MAX_LEN;

import android.util.Log;

import androidx.annotation.NonNull;

/**
 * @author JessPinkman
 * @date 2023-08-12/14:47
 **/
public class HiConsolePrinter implements HiLogPrinter{
    @Override
    public void print( int type, String tag, @NonNull StringBuilder stringBuilder) {
        String printString=stringBuilder.toString();
        int len=printString.length();
        int countOfSub=len/MAX_LEN;
        if(countOfSub>0){
            int index=0;
            for (int i = 0; i < countOfSub; i++) {
                Log.println(type,tag,printString.substring(index,index+MAX_LEN));
                index+=MAX_LEN;
            }
            if (index!=len){
                Log.println(type,tag,printString.substring(index,len));

            }
        }else {
            Log.println(type,tag,printString);
        }

    }
}
