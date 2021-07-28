package com.swheaqni;

import java.util.*;

public class BaseBurger {
    static Scanner scanner = new Scanner(System.in);
    String StuffingChoice="";
    public int price=35;
    protected BaseBurger() {
        makeBurger();
    }

    public void makeBurger(){
        System.out.println("\nChoose any 4 Stuffing :");
        Menu.PrintStuffingMenu();
        int choice;
        for (int i=1;i<=4;i++){
            choice=scanner.nextInt();
            StuffingChoice+=choice;
        }

        printOrder();
        System.out.println("\nPlease Pay Rs."+getPrice());
    }

    public void printOrder(){
        System.out.println("\nYour Order is :");
        System.out.println(Menu.SelectBurger(Main.choice) + " : "  + price);
        System.out.println("\nWith Stuffings :");
        for (int i=0; i<StuffingChoice.length();i++) {
            System.out.println(Menu.SelectStuffings(Integer.parseInt(StuffingChoice.substring(i,i+1))) + " : " +
                                Stuffing.PriceStuffing(Integer.parseInt(StuffingChoice.substring(i,i+1))) );
        }
    }

    public int getPrice() {
        for (int i=0; i<StuffingChoice.length();i++) {
            price+=Stuffing.PriceStuffing(Integer.parseInt(StuffingChoice.substring(i,i+1)));
        }
        return price;
    }
}
