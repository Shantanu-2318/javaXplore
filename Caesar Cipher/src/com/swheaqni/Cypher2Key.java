package com.swheaqni;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Cypher2Key extends Cypher {
    private static String alpha = "abcdefghijklmnopqrstuvwxyz";
    private static int key2;

    public Cypher2Key(int key1, int key2) {
        super(key1);
        this.key2 = key2;
    }

    public void encrypt(Path path) {
        String fileName = "ENCRYPTED" + path.getFileName().toString();
        Path encryptedPath = Paths.get(path.toString(), "..", fileName);
        try (Scanner scanner = new Scanner(path)) {
            Files.createFile(encryptedPath);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String half1 = Letters.split(line, 0);
                String half2 = Letters.split(line, 1);
                half1 = encrypt(new StringBuilder(half1), super.key1);
                half2 = encrypt(new StringBuilder(half2), key2);
                line = Letters.merge(half1, half2) + "\n";
                Files.write(encryptedPath, line.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already ENCRYPTED at " + encryptedPath.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(StringBuilder string, int key) {
        super.setShift(key);
        String cypher;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    ch = Character.toLowerCase(ch);
                    string.setCharAt(i, Character.toUpperCase(super.alphaEncrypted.charAt(alpha.indexOf(ch))));
                } else {
                    string.setCharAt(i, super.alphaEncrypted.charAt(alpha.indexOf(ch)));
                }
            }
        }
        cypher = string.toString();
        return cypher;
    }

    public void decrypt(Path path) {
        String fileName = "DECRYPTED" + path.getFileName().toString();
        Path decryptedPath = Paths.get(path.toString(), "..", fileName);
        try (Scanner scanner = new Scanner(path)) {
            Files.createFile(decryptedPath);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String half1 = Letters.split(line, 0);
                String half2 = Letters.split(line, 1);
                half1 = decrypt(new StringBuilder(half1), super.key1);
                half2 = decrypt(new StringBuilder(half2), key2);
                line = Letters.merge(half1, half2) + "\n";
                Files.write(decryptedPath, line.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already DECRYPTED at " + decryptedPath.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String decrypt(StringBuilder cypher, int key1) {
        setShift(key1);
        String string;
        for (int i = 0; i < cypher.length(); i++) {
            char ch = cypher.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    ch = Character.toLowerCase(ch);
                    cypher.setCharAt(i, Character.toUpperCase(alphaDecrypted.charAt(alpha.indexOf(ch))));
                } else {
                    cypher.setCharAt(i, alphaDecrypted.charAt(alpha.indexOf(ch)));
                }
            }
        }
        string = cypher.toString();
        return string;
    }

    public static void main(String[] args) {
        Path path= Paths.get("text.txt");
        Cypher2Key a=new Cypher2Key(21,8);
        a.encrypt(path);
    }

}