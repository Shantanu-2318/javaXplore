package com.swheaqni;

public class StockItems implements Comparable<StockItems> {
    private final String name;
    private double price;
    private int quantityStock = 0;

    public StockItems(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public StockItems(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice(double price){
        if (price > 0.0){
            this.price = price;
        }
    }

    public void adjustStock(int quantity){
        int newquantity = this.quantityStock + quantity;
        if (newquantity >=0){
            this.quantityStock = newquantity;
        }
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItems.equals");
        if (obj == this){
            return true;
        }

        if ((obj == null) || (obj.getClass() != this.getClass())){
            return false;
        }

        String objName = ((StockItems) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }

    @Override
    public int compareTo(StockItems o) {
        System.out.println("Entering StockItems.compareTo");
        if (this == o){
            return 0;
        }

        if (o != null){
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }
}
