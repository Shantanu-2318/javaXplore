package com.swheaqni;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String , StockItems> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }
     public  int addStock(StockItems item) {
        if (item != null) {
            StockItems inStock = list.getOrDefault(item.getName(), item);
            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
     }

     public int sellStock(String item, int quantity){
        StockItems instock = list.getOrDefault(item, null);

        if ((instock != null) && (instock.quantityInStock() >= quantity) && (quantity > 0)){
            return quantity;
        }
        return 0;
     }

     public StockItems get( String key){
        return list.get(key);
     }

     public Map<String , StockItems> Items(){
        return Collections.unmodifiableMap(list);
     }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItems> item : list .entrySet()){
            StockItems stockItems = item.getValue();
            double itemValue = stockItems.getPrice() * stockItems.quantityInStock();

            s = s + item.getKey() + " : There are " + stockItems.quantityInStock() + " in stock. value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }
        return s += "Total stock value " + String.format("%.2f",totalCost) + "\n";
    }
}
