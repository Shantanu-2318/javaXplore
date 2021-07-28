package com.swheaqni;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Cypher {

    private static String alpha ="abcdefghijklmnopqrstuvwxyz";
    public   String alphaEncrypted;
    public   String alphaDecrypted;
    int key1;

    public Cypher() {
    }

    public Cypher(int key1) {
        this.key1=key1;
        setShift(key1);
    }

    public void setShift(int key1){
        alphaEncrypted = alpha.substring(key1) + alpha.substring(0, key1);
        alphaDecrypted = alpha.substring(26- key1) + alpha.substring(0,26- key1);
    }

    public void encrypt(Path path){
        String fileName="ENCRYPTED"+path.getFileName().toString();
        Path encryptedPath= Paths.get(path.toString(),"..",fileName);
        try(Scanner scanner=new Scanner(path)){
            Files.createFile(encryptedPath);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                line= encrypt(new StringBuilder(line))+"\n";
                Files.write(encryptedPath,line.getBytes(), StandardOpenOption.APPEND);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public  String encrypt(StringBuilder string){
        String cypher;
        for (int i=0;i<string.length();i++){
            char ch = string.charAt(i);
            if(Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    ch=Character.toLowerCase(ch);
                    string.setCharAt(i, Character.toUpperCase(alphaEncrypted.charAt(alpha.indexOf(ch))));
                } else  {
                    string.setCharAt(i, alphaEncrypted.charAt(alpha.indexOf(ch)));
                }
            }
        }
        cypher=string.toString();
        return cypher;
    }

    public void decrypt(Path path){
        String fileName="DECRYPTED"+path.getFileName().toString();
        Path decryptedPath= Paths.get(path.toString(),"..",fileName);
        try(Scanner scanner=new Scanner(path)){
            Files.createFile(decryptedPath);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                line= decrypt(new StringBuilder(line))+"\n";
                Files.write(decryptedPath,line.getBytes(), StandardOpenOption.APPEND);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private  String decrypt(StringBuilder cypher){
        String string;
        for (int i=0;i<cypher.length();i++){
            char ch = cypher.charAt(i);
            if(Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    ch=Character.toLowerCase(ch);
                    cypher.setCharAt(i, Character.toUpperCase(alphaDecrypted.charAt(alpha.indexOf(ch))));
                } else  {
                    cypher.setCharAt(i, alphaDecrypted.charAt(alpha.indexOf(ch)));
                }
            }
        }
        string=cypher.toString();
        return string;
    }

    public static void main(String[] args) {
        Path path= Paths.get("text.txt");
        Cypher a=new Cypher(15);
        a.encrypt(path);
    }

}
