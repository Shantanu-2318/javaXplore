package com.swheaqni;

public class Menu {
    public void PrintBurgerMenu(){
        System.out.println("1.Base Burger\n" +
                "2.Healthy Burger\n" +
                "3.Deluxe Burger\n");
    }
    public static void PrintStuffingMenu(){
        System.out.println("1.Lettuce\n" +
                "2.Cheese\n" +
                "3.Chicken\n" +
                "4.Paneer\n" +
                "5.Onion\n" +
                "6.Tomato\n" +
                "7.Egg\n" +
                "8.BellPeppers\n");
    }

    public static void PrintBeverageMenu(){
        System.out.println("1.Coffee\n" +
                "2.Pepsi\n" +
                "3.Limca\n" +
                "4.Coke\n" +
                "5.Mirinda\n");
    }

    public static String SelectBurger(int Choice){
        switch(Choice){
            case 1 : return "BaseBurger";
            case 2 :return "HealthyBurger";
            case 3 :return "DeluxeBurger";
        }
        return "";
    }
    public static String SelectStuffings(int Choice){
        switch(Choice){
            case 1 : return "Lettuce";
            case 2 : return "Cheese";
            case 3 : return "Chicken";
            case 4 : return "Paneer";
            case 5 : return "Onion";
            case 6 : return "Tomato";
            case 7 : return "Egg";
            case 8 : return "BellPeppers";
        }
        return "";
    }

    public static String SelectBeverage(int Choice){
        switch(Choice){
            case 1 : return "Coffee";
            case 2 : return "Pepsi";
            case 3 : return "Limca";
            case 4 : return "Coke";
            case 5 : return "Mirinda";
        }
        return "";
    }

}
