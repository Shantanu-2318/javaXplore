package com.swheaqni;

public class HealthyBurger extends BaseBurger {

    public HealthyBurger() {
        super.StuffingChoice = "";
        super.price = 35;
    }

    public void makeBurger(){
        System.out.println("\nChoose any 6 Stuffing :");
        Menu.PrintStuffingMenu();
        int choice;
        for (int i=1;i<=6;i++){
            choice=scanner.nextInt();
            super.StuffingChoice+=choice;
        }
        printOrder();
        System.out.println("\nPlease Pay : "+getPrice());
    }
}
