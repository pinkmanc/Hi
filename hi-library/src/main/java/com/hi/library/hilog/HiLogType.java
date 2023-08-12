package com.hi.library.hilog;

import android.util.Log;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author JessPinkman
 * @date 2023-08-09/17:27
 **/
public class HiLogType {
    public static final int V=Log.VERBOSE;
    public static final int D=Log.DEBUG;
    public static final int I=Log.INFO;
    public static final int W=Log.WARN;
    public static final int E=Log.ERROR;
    public static final int A=Log.ASSERT;
}
