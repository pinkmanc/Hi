package com.hi.library.hilog;

/**
 * @author JessPinkman
 * @date 2023-08-12/12:59
 **/
public class HiStackElementFormatter implements HiLogFormatter<StackTraceElement []>{

    @Override
    public String format(StackTraceElement[] data) {
        StringBuilder stringBuilder=new StringBuilder();
        int len = data.length;
        int numDigits = String.valueOf(len).length();
        String format = "%0" + numDigits + "d";
        for (int i = 0; i < len; i++) {
            if(i==0){
                stringBuilder.append("STACK_TRACE:\n");
            }
            String formattedIndex = String.format(format, i + 1);
            if(i!= len -1){
                stringBuilder.append("\t├─ ").append(formattedIndex).append(" ").append(data[i].toString()).append("\n");
            }else {
                stringBuilder.append("\t└─ ").append(formattedIndex).append(" ").append(data[i].toString());
            }
        }
        return stringBuilder.toString();
    }
}
