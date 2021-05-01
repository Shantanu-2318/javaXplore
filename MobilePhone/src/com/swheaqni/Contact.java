package com.swheaqni;

public class Contact {
    private String Name="";
    private int Number;

    public Contact(String name, int number) {
        Name = name;
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public int getNumber() {
        return Number;
    }
    public static Contact createNewContact(String name,int number){
        return new Contact(name,number);
    }
}
