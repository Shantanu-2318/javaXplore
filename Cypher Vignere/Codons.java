package com.swheaqni;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Codons {
    private HashMap<String,Integer> map;
    private Path path;
    private String strand ="";

    public Codons(Path path) {
        this.path = path;
        createStrand();
    }

    private void createStrand(){
        try(Scanner scanner=new Scanner(path)){
            while (scanner.hasNextLine()){
                strand = strand + scanner.nextLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void createCodons(int frame){
        String codon="";
        map=new HashMap<>();
        try {
            for (int i = frame; i < strand.length(); ) {
                codon = "" + strand.charAt(i++) + strand.charAt(i++) + strand.charAt(i++);
                if (map.containsKey(codon)) {
                    map.put(codon, map.get(codon) + 1);
                } else {
                    map.put(codon, 1);
                }
            }
        }catch (IndexOutOfBoundsException e){

        }
    }

    public void printCodons(){
        try {
            pattern();
            for (String string : map.keySet()) {
                System.out.println(string + " occurred " + map.get(string) + " times.");
            }
            pattern();
        }catch (NullPointerException e){
            System.out.println("First create codons");
        }
    }

    public void maxCodons() {
        String maxCodons = "";
        int max = 0;
        try {
            for (String string : map.keySet()) {
                if (map.get(string) > max) {
                    maxCodons = string;
                    max = map.get(string);
                }
            }
            pattern();
            System.out.println(maxCodons+" occurred "+max+" times.");
            pattern();
        }catch (NullPointerException e){
            System.out.println("First create codons");
        }
    }

    public void uniqueCodons(){
        pattern();
        System.out.println(map.size() + " unique codons.");
        pattern();
    }

    public void printCodons(int start,int end){
        try {
            pattern();
            for (String string : map.keySet()) {
                if (map.get(string)>=start && map.get(string)<=end){
                    System.out.println(string + " occurred " + map.get(string) + " times.");
                }
            }
            pattern();
        }catch (NullPointerException e){
            System.out.println("First create codons");
        }
    }

    void pattern(){
        System.out.println("\n****************************************************\n");
    }

    public static void main(String[] args) {
        //Path path= Paths.get("dnaMystery2.txt");
        //Codons codons=new Codons(path);
//        codons.createCodons(0);
//        codons.uniqueCodons();;
//        codons.maxCodons();
//        codons.createCodons(1);
//        codons.uniqueCodons();;
//        codons.maxCodons();
//        codons.createCodons(2);
//        codons.uniqueCodons();
//        codons.maxCodons();
//        codons.printCodons(7,7);
    }

}
