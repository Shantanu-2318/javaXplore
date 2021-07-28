package com.swheaqni;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
	    Account acc1=new Account();
        System.out.println("Enter Account number");
        int account_number=s.nextInt();
        acc1.setAccount_number(account_number);
        System.out.println("Enter Balance");
        int balance=s.nextInt();
        acc1.setBalance(balance);
        s.nextLine();
        System.out.println("Enter name");
        String name=s.nextLine();
        acc1.setName(name);
        System.out.println("Enter email");
        String email=s.nextLine();
        acc1.setEmail(email);
        System.out.println("Enter phone number");
        int number=s.nextInt();
        acc1.setPhone_number(number);
        System.out.println("Account number is: "+acc1.getAccount_number());
        System.out.println("Balance is: "+acc1.getBalance());
        System.out.println("Name is: "+acc1.getName());
        System.out.println("Email is: "+acc1.getEmail());
        System.out.println("Phone number is: "+acc1.getPhone_number());
        while (true){
            System.out.println("Choose:\n1-Withdraw\n2-Deposit\n2-Exit");
            int Choice=s.nextInt();
            if(Choice==1){
                System.out.println("Enter amount");
                int Amount = s.nextInt();
                acc1.withdraw(Amount);
            }
            else if(Choice==2){
                System.out.println("Enter Amount");
                int Amount=s.nextInt();
                acc1.deposit(Amount);
            }else if(Choice==3){
                break;
            }
            else {
                System.out.println("Invalid Choice");
            }
        }
        System.out.println("Balance is: "+acc1.getBalance());
    }
}
