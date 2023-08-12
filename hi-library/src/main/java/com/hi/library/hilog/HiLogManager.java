package com.hi.library.hilog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JessPinkman
 * @date 2023-08-10/9:47
 **/
public class HiLogManager {
    private HiLogConfig config;
    private static HiLogManager instance;
    @Nullable
    private List<HiLogPrinter> printers=new ArrayList<>();

    public HiLogManager(HiLogConfig config,@Nullable HiLogPrinter[] printers) {
        this.config = config;
        if (printers!=null){
            this.printers.addAll(Arrays.asList(printers));
        }
    }

    public HiLogConfig getConfig() {
        return config;
    }

    public static HiLogManager getInstance() {
        return instance;
    }
    public static void init(@NonNull HiLogConfig config,@NonNull HiLogPrinter...printers){
        instance=new HiLogManager(config,printers);

    }

    public List<HiLogPrinter> getPrinters(){
        return printers;
    }
    public void addPrinter(HiLogPrinter printer){
        printers.add(printer);
    }
    public void removePrinter(HiLogPrinter printer){
        if (printers!=null){
            printers.remove(printer);
        }
    }

}
