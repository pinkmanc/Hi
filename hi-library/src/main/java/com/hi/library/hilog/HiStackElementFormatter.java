package com.hi.library.hilog;

/**
 * @author JessPinkman
 * @date 2023-08-12/12:59
 **/
public class HiStackElementFormatter implements HiLogFormatter<StackTraceElement []>{

    @Override
    public String format(StackTraceElement[] data) {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0,len=data.length;i<len; i++) {
            if(i==0){
                stringBuilder.append("STACK_TRACE:\n");
            }
            if(i!= len -1){
                stringBuilder.append("\t├─ ");
                stringBuilder.append(data[i].toString());
                stringBuilder.append("\n");

            }else {
                stringBuilder.append("\t└─ ");
                stringBuilder.append(data[i].toString());
            }

        }
        return stringBuilder.toString();
    }
}
