package com.swheaqni;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Cypher {

    private  String alpha ="abcdefghijklmnopqrstuvwxyz";
    public   String alphaEncrypted;
    public   String alphaDecrypted;
    int key;

    public Cypher() {
    }

    public Cypher(int key) {
        this.key = key;
        setShift(key);
    }

    public void setShift(int key1){
        alphaEncrypted = alpha.substring(key1) + alpha.substring(0, key1);
        alphaEncrypted+=alphaEncrypted.toUpperCase();
        alphaDecrypted = alpha.substring(26- key1) + alpha.substring(0,26- key1);
        alphaDecrypted+=alphaDecrypted.toUpperCase();
        alpha+=alpha.toUpperCase();
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

    public String encrypt(StringBuilder string){

        for (int i=0;i<string.length();i++){
            char ch = string.charAt(i);
            if(Character.isLetter(ch)) {
                string.setCharAt(i,encrypt(ch));
            }
        }
        return string.toString();
    }

    public  char encrypt(char c){
        if (Character.isLetter(c)){
            c=alphaEncrypted.charAt(alpha.indexOf(c));
        }
        return c;
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

    public  String decrypt(StringBuilder cypher){

        for (int i=0;i<cypher.length();i++){
            char ch = cypher.charAt(i);
            if(Character.isLetter(ch)) {
                cypher.setCharAt(i,decrypt(ch));
            }
        }
        return cypher.toString();
    }

    public  char decrypt(char c){
        try{
            if (Character.isLetter(c)){
                c=alphaDecrypted.charAt(alpha.indexOf(c));
            }
        }catch (StringIndexOutOfBoundsException e){

        }
        return c;
    }

    public static void main(String[] args) {
        Path path= Paths.get("text.txt");
        Cypher a=new Cypher(2);
        a.encrypt(path);
    }

}
