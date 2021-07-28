package com.swheaqni;

import java.nio.file.Path;

public class BreakCypher {
    private  char e;
    private char common;
    private int key;

    public BreakCypher() {

    }

    public BreakCypher(String string,char common) {
        this.common=common;
        e=maxOccur(string);
        key=shift();
    }

    public int shift(){
        int shift=(e-common);
        if (shift<0){
            shift+=26;
        }
        return shift;
    }

    public char maxOccur(String string){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] count=new int[26];
        for (int i=0;i<string.length();i++){
            char ch = string.charAt(i);
            ch=Character.toLowerCase(ch);
            if (alpha.indexOf(ch) != -1){
                count[alpha.indexOf(ch)]++;
            }
        }
        int max=0;
        int index=0;
        for (int i = 0; i < count.length; i++) {
            if (count[i]>max){
                max=count[i];
                index=i;
            }
        }
        return (char)(index+97);
    }

    public int getKey() {
        return key;
    }
}
