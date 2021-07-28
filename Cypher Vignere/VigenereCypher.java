package com.swheaqni;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class VigenereCypher {
    private final int[] key;
    private final Cypher[] ciphers;

    public VigenereCypher(int[] key) {
        this.key = key;
        ciphers=new Cypher[key.length];
        for (int i = 0; i < key.length; i++) {
            ciphers[i]=new Cypher(key[i]);
        }
    }

    private String readFile(Path path)
    {
        try{
            byte[] encoded = Files.readAllBytes(path);
            return new String(encoded, StandardCharsets.UTF_8);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void encrypt(Path path) {
        String input=readFile(path);
        String answer=encrypt(input);
        String fileName="ENCRYPTED"+path.getFileName().toString();
        Path encryptedPath= Paths.get(path.toString(),"..",fileName);
        try {
            Files.createFile(encryptedPath);
            Files.write(encryptedPath, answer.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public String encrypt(String input){
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            Cypher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.encrypt(c));
            i++;
        }
        return answer.toString();
    }

    public void decrypt(Path path) {
        String input=readFile(path);
        String answer=decrypt(input);
        String fileName="DECRYPTED"+path.getFileName().toString();
        Path decryptedPath= Paths.get(path.toString(),"..",fileName);
        try{
            Files.createFile(decryptedPath);
                Files.write(decryptedPath,answer.toString().getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public String decrypt(String input){
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (long j=0; j<input.length();j++) {
            char c=input.charAt(i);
            int cipherIndex = i % ciphers.length;
            Cypher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.decrypt(c));
            i++;
        }
        return answer.toString();
    }

    public static void main(String[] args) {

    }

}
