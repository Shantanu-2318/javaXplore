package com.swheaqni;

import java.util.Scanner;

public class Main {
     static int choice=0;
    public int SelectBurger(int Choice){
        switch(Choice){
            case 1 :BaseBurger NewBaseBurger = new BaseBurger();
                    return NewBaseBurger.getPrice();
            case 2 :HealthyBurger NewHealthyBurger = new HealthyBurger();
                    return NewHealthyBurger.getPrice();
            case 3 :DeluxeBurger NewDeluxeBurger = new DeluxeBurger();
                    return NewDeluxeBurger.getPrice();
        }
        return 0;
    }

    public static void main(String[] args) {
        Main main=new Main();
        Scanner scanner=new Scanner(System.in);
        Menu menu=new Menu();
        while (true){
            System.out.println("Choose a Burger :");
            menu.PrintBurgerMenu();
            choice = scanner.nextInt();
            main.SelectBurger(choice);
            System.out.println("\n*************************************************\n");
        }
    }
}
