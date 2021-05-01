package com.swheaqni;

public class Account
{
    private int account_number;
    private int balance;
    private String name;
    private String email;
    private int phone_number;

    public Account() {
        this.account_number = 0;
        this.balance = 0;
        this.name = "";
        this.email = "";
        this.phone_number = 0;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public int getAccount_number() {
        return account_number;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone_number() {
        return phone_number;
    }
    public void deposit(int  Amount){
        this.balance=this.balance+Amount;
    }

    public void withdraw(int Amount){
        if(Amount>this.balance){
            System.out.println("Balance not sufficient");
        }else{
            this.balance=this.balance-Amount;
        }
    }
}
