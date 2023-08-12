package com.hi.library.hilog;

import androidx.annotation.NonNull;

/**
 * @author JessPinkman
 * @date 2023-08-12/12:51
 **/
public interface HiLogFormatter<T> {
    public String format(T data);
}
