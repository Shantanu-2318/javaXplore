package com.swheaqni;


public class Stuffing {

    private static Items Lettuce=new Items("Lettuce",5);
    private static Items Cheese=new Items("Cheese",15);
    private static Items Chicken=new Items("Chicken",25);
    private static Items Paneer=new Items("Paneer",10);
    private static Items Onion=new Items("Onion",5);
    private static Items Tomato=new Items("Tomato",5);
    private static Items Egg=new Items("Egg",10);
    private static Items BellPeppers=new Items("BellPeppers",5);

    public static int PriceStuffing(int choice){
        switch(choice){
            case 1 : return Lettuce.getPrice();
            case 2 : return Cheese.getPrice();
            case 3 : return Chicken.getPrice();
            case 4 : return Paneer.getPrice();
            case 5 : return Onion.getPrice();
            case 6 : return Tomato.getPrice();
            case 7 : return Egg.getPrice();
            case 8 : return BellPeppers.getPrice();
        }
        return -1;
    }
}


