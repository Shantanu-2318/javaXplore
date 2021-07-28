package com.swheaqni;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BreakCypher {
    private static char e;
    private int key;

    public BreakCypher(Path path) {

        countShift();
        Cypher cypher=new Cypher(key);
        cypher.decrypt(path);
    }

    private void countShift(){
        int shift=(e-'e');
        if (shift<0){
            shift+=26;
        }
        key=shift;
    }

//    public void eyeCrack(String string){
//        for (int i = 1; i < 25; i++) {
//            System.out.println(decrypt(new StringBuilder(string),i));
//        }
//    }

}
