package com.hi.library.hilog;

/**
 * @author JessPinkman
 * @date 2023-08-12/12:55
 **/
public class HiThreadFormatter implements HiLogFormatter<Thread>{

    @Override
    public String format(Thread data) {
        return "THREAD:\n"+data.getName();
    }
}
