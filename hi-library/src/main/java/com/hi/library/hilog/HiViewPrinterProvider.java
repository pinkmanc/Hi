package com.hi.library.hilog;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hi.library.R;
import com.hi.library.hilog.utils.HiDisplayUtil;


/**
 * @author JessPinkman
 * @date 2023-08-02/15:21
 **/
public class HiViewPrinterProvider {
    private FrameLayout rootView;
    private View floatingView;
    private RecyclerView recyclerView;
    private static final String TAG_FLOATING_VIEW="TAG_FLOATING_VIEW";
    private static final String TAG_LOG_VIEW="TAG_LOG_VIEW";
    private FrameLayout logView;

    public HiViewPrinterProvider(FrameLayout rootView, RecyclerView recyclerView) {
        this.rootView = rootView;
        this.recyclerView = recyclerView;
    }
    public void showFloatingView(){
        if (rootView.findViewWithTag(TAG_FLOATING_VIEW)!=null){
            return;
        }
        FrameLayout.LayoutParams params=new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity= Gravity.BOTTOM|Gravity.END;
        params.bottomMargin= HiDisplayUtil.dp2px(100,recyclerView.getResources());
        View floatingView=genFloatingView();
        rootView.addView(floatingView,params);

    }
    public void closeFloatingView(){
        rootView.removeView(genFloatingView());
    }
    private View genFloatingView(){
        if (floatingView!=null){
            return floatingView;
        }
        TextView textView=new TextView(rootView.getContext());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    showLogView();
            }

        });
        textView.setText(R.string.hilog);
        textView.setTag(TAG_FLOATING_VIEW);
        textView.setBackgroundColor(Color.BLACK);
        textView.setAlpha(1);
        return textView;
    }
    private void showLogView() {
        if(rootView.findViewWithTag(TAG_LOG_VIEW)!=null){
            return;
        }
        FrameLayout.LayoutParams params=
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, HiDisplayUtil.dp2px(160,rootView.getResources()));
        params.gravity=Gravity.BOTTOM;
        logView= (FrameLayout) genLogView();
        rootView.addView(logView,params);

    }

    private FrameLayout genLogView() {
        if (logView!=null){
            return logView;
        }
        FrameLayout logView=new FrameLayout(rootView.getContext());
        logView.setTag(TAG_LOG_VIEW);
        logView.setBackgroundColor(Color.BLACK);
        logView.addView(recyclerView);
        FrameLayout.LayoutParams closeViewParams= new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        closeViewParams.gravity=Gravity.END;
        TextView closeView=new TextView(rootView.getContext());
        closeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeLogView();
            }

        });
        closeView.setText(R.string.close);
        logView.addView(closeView,closeViewParams);
        return logView;
    }
    public void closeLogView() {
        rootView.removeView(logView);
    }
}
