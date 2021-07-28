package com.swheaqni;

import java.util.Scanner;

public class Main {

    static String[] braille=new String[27];
    static String cap;

    static{
        braille[0]="000000";//space
        braille[1]="100000";//a
        braille[2]="110000";//b
        braille[3]="100100";//c
        braille[4]="100110";//d
        braille[5]="100010";//e
        braille[6]="110100";//f
        braille[7]="110110";//g
        braille[8]="110010";//h
        braille[9]="010100";//i
        braille[10]="010110";//j
        braille[11]="101000";//k
        braille[12]="111000";//l
        braille[13]="101100";//m
        braille[14]="101110";//n
        braille[15]="101010";//o
        braille[16]="111100";//p
        braille[17]="111110";//q
        braille[18]="111010";//r
        braille[19]="011100";//s
        braille[20]="011110";//t
        braille[21]="101001";//u
        braille[22]="111001";//v
        braille[23]="010111";//w
        braille[24]="101101";//x
        braille[25]="101111";//y
        braille[26]="101011";//z
        cap="000001";
    }

    public static String solution(String string){
        String braille="";
        for (int i=0 ; i < string.length() ; i++){
            braille = braille + translate(string.charAt(i));
        }
        return braille;
    }

    public static String translate(char c){
        int ascii = c;
        if(ascii>=95 && ascii<=122){
            return braille[ascii-96];
        }else if(ascii>=65 && ascii<=90){
            return cap+braille[ascii-64];
        }else if(ascii==32){
            return braille[0];
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input=scanner.nextLine();
        System.out.println(solution(input));
    }
}
