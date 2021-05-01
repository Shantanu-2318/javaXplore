package com.swheaqni;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class BreakCypher2Key {
    private static char e1;
    private static char e2;
    private int key1;
    private int key2;

    public BreakCypher2Key(Path path) {
        Letters count1=new Letters();
        Letters count2=new Letters();
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String half1 = Letters.split(line, 0);
                count1.countLetters(half1);
                String half2 = Letters.split(line, 1);
                count2.countLetters(half2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        e1=count1.maxOccur();
        key1=countShift(e1);
        e2=count2.maxOccur();
        key2=countShift(e2);
        System.out.println(key1+" , "+key2);
        Cypher2Key cypher=new Cypher2Key(key1,key2);
        cypher.decrypt(path);
    }

    private int countShift(char e){
        int shift=(e-'e');
        if (shift<0){
            shift+=26;
        }
        return shift;
    }

    public static void main(String[] args) {
        Path path= Paths.get("text.txt");
        BreakCypher2Key a=new BreakCypher2Key(path);
    }

}
