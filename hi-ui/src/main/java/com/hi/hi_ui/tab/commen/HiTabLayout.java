package com.hi.hi_ui.tab.commen;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface HiTabLayout<Tab extends ViewGroup, D> {
    Tab findTab(@NonNull D data);
    void addTabSelectedChangeListener(OnTabSelectedListener<D> listener);
    void defaultSelected(@NonNull D defaultInfo);
    interface OnTabSelectedListener<D>{
        void onTabSelectedChange(int index, @Nullable D preInfo,@NonNull D nextInfo);

    }

}
