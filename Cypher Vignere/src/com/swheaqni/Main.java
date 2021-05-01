package com.swheaqni;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        File in =  new File("D:\\Workspace\\Java\\IdeaProjects\\Output\\Dictionaries\\Danish");
        InputStreamReader r = new InputStreamReader(new FileInputStream(in));
        System.out.println(r.getEncoding());
    }
}

