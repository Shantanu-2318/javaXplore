package com.swheaqni;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner=new Scanner(System.in);
    private static LinkedList<Playlist> myPlaylists=new LinkedList<Playlist>();
    private static LinkedList<Album> myAlbum=new LinkedList<Album>();
    private static  int  na=-1;
    private static  int np=-1;
    public static void main(String[] args) {
        System.out.println("Add an album");
        addAlbum();
        boolean exit=false;
        while(!exit){
            showAction();
            System.out.println("Choose an action :");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    addAlbum();
                    break;
                case 2:
                    addPlaylist();
                    break;
                case 4:
                    addSongsToAlbum();
                    break;
                case 3:
                    addSongsToPlaylist();
                    break;
                case 5:
                    showAlbum();
                    break;
                case 6:
                    showPlaylist();
                    break;
                case 7:
                    exit=true;
                    break;
            }
        }
    }
   public static void addAlbum(){
      myAlbum.add(Album.createNewAlbum());
      ++na;
   }
    public static void addSongsToAlbum(){
        Album.addSong();
    }
    public static void showAlbum(){
        int n=0;
        for(Album i: myAlbum){
            System.out.println(++n+". "+i.getName());
        }
    }
    public static void addPlaylist(){
        myPlaylists.add(Playlist.createNewPlaylist());
        ++np;
    }
    public static void showPlaylist(){
        int n=0;
        for(Playlist i: myPlaylists){
            System.out.println(++n+". "+i.getName());
        }
    }
    public static void addSongsToPlaylist(){
        myAlbum.get(selectAlbum()).showSongs();
        System.out.println("Select Songs");
        int choiceS=scanner.nextInt()-1;
        myPlaylists.get(np).playlist.add(myAlbum.get(selectAlbum()).album.get(choiceS));
    }
    public static int selectAlbum(){
        showAlbum();
        System.out.println("Select an album:");
        int choiceA=scanner.nextInt()-1;
        return choiceA;
    }
    public static int selectPlaylist(){
        showAlbum();
        System.out.println("Select an playlist:");
        int choiceP=scanner.nextInt()-1;
        return choiceP;
    }
    public static void showAction(){
        System.out.println("1-Add an Album\n" +
                "2-Add a Playlist\n" +
                "3-Add a song to current Playlist\n" +
                "4-Add a song to the current Album\n" +
                "5-Show all Albums\n" +
                "6-Show all Playlists\n" +
                "7-Exit");
    }
}
