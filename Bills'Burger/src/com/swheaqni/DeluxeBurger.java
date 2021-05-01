package com.swheaqni;

import java.util.Scanner;

public class DeluxeBurger extends BaseBurger {
    public DeluxeBurger() {
        super.StuffingChoice = "";
        super.price = 35;
    }

    public void makeBurger(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose any 4 Stuffing :");
        Menu.PrintStuffingMenu();
        int choice;
        for (int i=1;i<=4;i++){
            choice=scanner.nextInt();
            super.StuffingChoice+=choice;
        }
        System.out.println("Choose any one Beverage : ");
        Menu.PrintBeverageMenu();
        int choiceBeverage = scanner.nextInt();
        printOrder();
        System.out.println("\nWith Beverage : \n" + Menu.SelectBeverage(choiceBeverage) +
                            " : " + Beverages.PriceBeverage(choiceBeverage));
        price += Beverages.PriceBeverage(choiceBeverage);
        System.out.println("\nPlease Pay : "+getPrice());
    }
}
