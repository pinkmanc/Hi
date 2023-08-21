package com.hi.hi_ui.tab.commen;

import androidx.annotation.NonNull;
import androidx.annotation.Px;

public interface HiTab <D> extends HiTabLayout.OnTabSelectedListener<D>{
    void setHiTabInfo(@NonNull D data);
    void resetHeight(@Px int height);

}
