package com.swheaqni;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
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

    Letters(String string) {
        Scanner scanner = new Scanner(string);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            countLetters(line);
        }
    }

    public  void countLetters(String string){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        count=new int[26];
        for (int i=0;i<string.length();i++){
            char ch = string.charAt(i);
            ch=Character.toLowerCase(ch);
            if (alpha.indexOf(ch) != -1){
                count[alpha.indexOf(ch)]++;
            }
        }
    }

    public void countWords(String string, HashSet<String> wordSet){
        String[] words=string.split("\\W+");
        int count=0;
        for (String s : words) {

            if (!s.isEmpty()&&!s.isBlank()) {
                if (wordSet.contains(s)){
                    count++;
                }
            }

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

    public static void main(String[] args) {

    }

}
