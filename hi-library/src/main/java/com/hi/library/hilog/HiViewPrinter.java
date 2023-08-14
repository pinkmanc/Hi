package com.hi.library.hilog;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hi.library.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JessPinkman
 * @date 2023-08-14/9:13
 **/
public class HiViewPrinter implements HiLogPrinter{
    private RecyclerView recyclerView;
    public LogAdapter adapter;
    private HiViewPrinterProvider viewProvider;
    @Override
    public void print(int type, String tag, @NonNull StringBuilder stringBuilder) {
        adapter.addItem(new HiLogMo(System.currentTimeMillis(),type,tag,stringBuilder.toString()));
        recyclerView.scrollToPosition(adapter.getItemCount()-1);

    }
    public HiViewPrinter(Activity activity) {
        FrameLayout rootView=activity.findViewById(android.R.id.content);
        recyclerView=new RecyclerView(activity);
        adapter=new LogAdapter(LayoutInflater.from(recyclerView.getContext()));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        viewProvider=new HiViewPrinterProvider(rootView,recyclerView);
    }
    @NonNull
    public HiViewPrinterProvider getViewProvider(){
        return viewProvider;
    }
    private static class LogAdapter extends RecyclerView.Adapter<LogViewHolder>{
        public LogAdapter(LayoutInflater layoutInflater) {
            this.layoutInflater = layoutInflater;
        }
        void addItem(HiLogMo logItem){
            logs.add(logItem);
            notifyItemInserted(logs.size()-1);
        }

        private LayoutInflater layoutInflater;
        private List<HiLogMo> logs=new ArrayList<>();

        @NonNull
        @Override
        public LogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView=layoutInflater.inflate(R.layout.hilog_item,parent,false);
            return new LogViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull LogViewHolder holder, int position) {
            HiLogMo logItem=logs.get(position);
            int color=getHighlightColor(logItem.level);
            holder.tagView.setTextColor(color);
            holder.messageView.setTextColor(color);

            holder.tagView.setText(logItem.getFlattened());
            holder.messageView.setText(logItem.log);
        }

        @Override
        public int getItemCount() {
            return logs.size();
        }
        private int getHighlightColor(int logLevel){
            int highLight;
            switch (logLevel){
                case HiLogType.V:
                    highLight=0xffbbbbbb;
                    break;
                case HiLogType.D:
                    highLight=0xffffffff;
                    break;
                case HiLogType.I:
                    highLight=0xff6a8759;
                    break;
                case HiLogType.W:
                    highLight=0xffbbb529;
                    break;
                case HiLogType.E:
                    highLight=0xffff6b68;
                    break;
                default:
                    highLight=0xffffff00;
                    break;
            }
            return highLight;
        }
    }
    private static class LogViewHolder extends RecyclerView.ViewHolder{
        TextView tagView;
        TextView messageView;
        public LogViewHolder(@NonNull View itemView) {
            super(itemView);
            tagView=itemView.findViewById(R.id.tag);
            messageView=itemView.findViewById(R.id.message);
        }
    }


}
