package com.swheaqni;

import java.util.ArrayList;
import java.util.Scanner;

public class Album {
    private static Scanner scanner=new Scanner(System.in);
    private static String name="";
    public static ArrayList<Song> album =new ArrayList<Song>();

    public Album() {
        System.out.println("Enter the name of the Album");
        name =scanner.nextLine();
        System.out.println("name done");
        addSong();
    }

    public String getName() {
        return name;
    }

    public static void addSong(){

        album.add(Song.createNewSong());
    }

    public ArrayList<Song> getAlbum() {
        return album;
    }

    public static Album createNewAlbum(){
        return new Album();
    }

    public static void showSongs(){
        int n=0;
        for(Song i : album){
            System.out.println(++n+". "+i.Name);
        }
    }
}
