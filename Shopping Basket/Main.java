package com.swheaqni;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItems temp = new StockItems("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItems("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItems("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItems("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItems("vase", 8.76, 40);
        stockList.addStock(temp);

        temp = new StockItems("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItems("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItems("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItems("cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItems("door", 72.95, 4);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s : stockList.Items().keySet()) {
            System.out.println(s);
        }
    }
}
