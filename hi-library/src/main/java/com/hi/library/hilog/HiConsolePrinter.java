package com.hi.library.hilog;


import android.util.Log;

import androidx.annotation.NonNull;

/**
 * @author JessPinkman
 * @date 2023-08-12/14:47
 **/
public class HiConsolePrinter implements HiLogPrinter{
    @Override
    public void print( int type, String tag, @NonNull StringBuilder stringBuilder) {
        Log.println(type,tag,stringBuilder.toString());

    }
}
