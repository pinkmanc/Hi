package com.hi.library.hilog;

import androidx.annotation.NonNull;

public interface HiLogPrinter {
    void print(int type,String tag,@NonNull StringBuilder stringBuilder);
}
