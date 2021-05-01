package com.swheaqni;

import java.util.LinkedList;
import java.util.Scanner;

public class Playlist {
    private static Scanner scanner=new Scanner(System.in);
    private static String name="";
    public static LinkedList<Song> playlist= new LinkedList<>();

    public Playlist() {
        System.out.println("Enter the name of the Playlist  ");
        scanner.next();
        name =scanner.nextLine();
    }

    public String getName() {
        return name;
    }
    public static  Playlist createNewPlaylist(){
        return new Playlist();
    }
}
