package com.swheaqni;

public class Beverages {
    private static Items Coffee=new Items("Coffee",50);
    private static Items Pepsi=new Items("Pepsi",30);
    private static Items Limca=new Items("Limca",30);
    private static Items Coke=new Items("Coke",30);
    private static Items Mirinda=new Items("Mirinda",30);

    public static void PrintBeverageMenu(){
        System.out.println("1.Coffee\n" +
                            "2.Pepsi\n" +
                            "3.Limca\n" +
                            "4.Coke\n" +
                            "5.Mirinda\n");
    }

    public static int PriceBeverage(int choice){
        switch(choice){
            case 1 : return Coffee.getPrice();
            case 2 : return Pepsi.getPrice();
            case 3 : return Limca.getPrice();
            case 4 : return Coke.getPrice();
            case 5 : return Mirinda.getPrice();
        }
        return -1;
    }

}
