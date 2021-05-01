package com.swheaqni;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class BreakVigenere {
    private static final HashMap<String, HashSet<String>> dictionaries=new HashMap<>();
    private final Path path;
    private final StringBuilder input;
    static {
        File[] file=new File("D:\\Workspace\\Java\\IdeaProjects\\Output\\Dictionaries").listFiles();
        for (File f : file) {
            Path p=Paths.get(f.getAbsolutePath());
            String fileName=p.getFileName().toString();
            HashSet<String> words=new HashSet<>();
            try(Scanner scanner=new Scanner(p)){
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    words.add(line.toLowerCase());
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            dictionaries.put(fileName,words);
            System.out.println(fileName + " added to dictionary");
        }

    }

     BreakVigenere(Path path) {
        this.path=path;
        input=new StringBuilder(readFile(path));
        breakForAllLanguages(input.toString());
    }

    private void breakForAllLanguages(String encrypted){
        String decrypted="";
        String decryptedText="";
        String textLanguage="";
        int max=0;
        for (String language : dictionaries.keySet()) {
            decrypted=breakForLanguage(encrypted,dictionaries.get(language));
            int validWords=countWords(decrypted,dictionaries.get(language));
            if (validWords>max){
                max=validWords;
                decryptedText=decrypted;
                textLanguage=language;
            }
            System.out.println(language+" tested");
        }

        System.out.println("Text is in : "+textLanguage);

        String fileName="DECRYPTED"+path.getFileName().toString();
        Path decryptedPath= Paths.get(path.toString(),"..",fileName);
        try{
            Files.createFile(decryptedPath);
            Files.write(decryptedPath,decryptedText.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private String breakForLanguage(String encrypted , HashSet<String> dictionary){
        String string="";
        String decrypted="";
        char common=maxOccur(dictionary);
        int[] key;
        int max=0;
        for (int i = 2; i <= 100; i++) {
            key = tryKeyLength(i,common);
            VigenereCypher vigenereCypher = new VigenereCypher(key);
            string=vigenereCypher.decrypt(encrypted);
            int validWords=countWords(string,dictionary);
            if (validWords>max){
                max=validWords;
                decrypted=string;
            }
        }
          return decrypted;
    }

    private int[] tryKeyLength( int keyLength, char common){
        int[] key=new int[keyLength];
        for (int i = 0; i < keyLength; i++) {
            key[i]=new BreakCypher(slice(i,keyLength),common).getKey();
        }
        return key;
    }

    private static String readFile(Path path)
    {
        try{
            byte[] encoded = Files.readAllBytes(path);
            return new String(encoded, StandardCharsets.UTF_8).toLowerCase();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    private String slice( int start,int skip) {
        String slice = "";
        for (int i=start ; i < input.length(); i += skip) {
            slice += input.charAt(i);

        }
        return slice;
    }

    private  int countWords(String string, HashSet<String> wordSet){
        String[] words=string.split("\\W+");
        int count=0;
        for (String s : words) {

            if (!s.isEmpty()&&!s.isBlank()) {
                if (wordSet.contains(s)){
                    count++;
                }
            }

        }
        return  count;
    }

    public char maxOccur(HashSet<String> words){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] count=new int[26];
        for (String string : words){
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                ch = Character.toLowerCase(ch);
                if (alpha.indexOf(ch) != -1) {
                    count[alpha.indexOf(ch)]++;
                }
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
        Path path=Paths.get("secretmessage4.txt");
        BreakVigenere b=new BreakVigenere(path);
    }
}
