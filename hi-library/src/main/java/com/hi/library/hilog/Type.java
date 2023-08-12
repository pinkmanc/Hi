package com.hi.library.hilog;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({HiLogType.V,HiLogType.D,HiLogType.I,HiLogType.W,HiLogType.E,HiLogType.A})
public @interface Type {
}
