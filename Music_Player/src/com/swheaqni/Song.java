package com.swheaqni;

import java.util.Scanner;

public class Song {
    public static String Name="";
    public static double Duration=0.0;
    Scanner scanner=new Scanner(System.in);

    public Song() {
        System.out.println("Enter the name of the song");
        Name=scanner.nextLine();
        System.out.println("Enter the duration of the song");
        Duration=scanner.nextDouble();
    }

    public static Song createNewSong(){
        return new Song();
    }
}
