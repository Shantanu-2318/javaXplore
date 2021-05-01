package com.swheaqni;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Letters {

    private int[] count;

     Letters(Path path) {
         count=new int[26];
        try(Scanner scanner=new Scanner(path)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                countLetters(line);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public Letters() {
        count=new int[26];
    }

    public  void countLetters(String string){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (int i=0;i<string.length();i++){
            char ch = string.charAt(i);
            ch=Character.toLowerCase(ch);
            if (alpha.indexOf(ch) != -1){
                count[alpha.indexOf(ch)]++;
            }
        }
    }

    public static String split(String string, int i) {
        String halfString = "";
        for (; i < string.length(); i += 2) {
            halfString += string.charAt(i);
        }
        return halfString;
    }

    public static String merge(String string1, String string2) {
        String fullString = "";
        int i = 0;
        try {
            for (; i < string1.length(); i++) {
                fullString += string1.charAt(i);
                fullString += string2.charAt(i);
            }
        } finally {
            return fullString;
        }
    }

    public char maxOccur(){
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

}
