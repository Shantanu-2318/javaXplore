package com.swheaqni;
import java.util.*;
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Mobilephone mobilephone = new Mobilephone();

    public static void main(String[] args) {
        startPhone();
        printActions();
        boolean quit=false;
        while(!quit) {
            System.out.println("enter your choice:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    removeContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    editContact();
                    break;
                case 5:
                    quit = true;
            }
        }
    }
    private static void startPhone(){
        System.out.println("phone is starting...");
    }
    private static void printActions(){
        System.out.println("1- Add Contact\n" +
                "2- Remove Contact\n" +
                "3- Search Contact\n" +
                "4- Edit Contact\n" +
                "5- Exit\n");
    }
    private static void addContact(){
        System.out.println("enter new name: ");
        scanner.next();
        String newName=scanner.nextLine();
        System.out.println("enter new number: ");
        int newNumber=scanner.nextInt();
        if(mobilephone.addContact(Contact.createNewContact(newName,newNumber)))
        {
            System.out.println("Contact added successfully");
        }
        else{
            System.out.println("Contact already exists");
        }
    }
    private static void removeContact(){
        System.out.println("enter name of the contact to be removed: ");
        String name=scanner.nextLine();
        if(mobilephone.removeContacts(name)){
            System.out.println("contact removed successfully");
        }
        else{
            System.out.println("contact not found");
        }
    }
    private static void editContact(){
        System.out.println("Enter the name of the contact");
        scanner.nextLine();
        String name = scanner.nextLine();
        if(mobilephone.searchContacts(name)!=null) {
            System.out.println("Enter new Name :");
            String NewName = scanner.nextLine();
            System.out.println("Enter new Number :");
            int NewNumber = scanner.nextInt();
            mobilephone.editContacts(mobilephone.searchContacts(name), Contact.createNewContact(NewName, NewNumber));
        }
        else{
            System.out.println("contact not found");
        }
    }
    private static void searchContact(){
        System.out.println("1-search by name\n" +
                           "2-search by number");
        int choice=scanner.nextInt();
        switch (choice){
            case 1 :
                System.out.println("Enter name :");
                String name=scanner.nextLine();
                mobilephone.findContacts(name);
                break;
            case 2 :
                System.out.println("Enter number :");
                int number=scanner.nextInt();
                mobilephone.findContacts(number);
        }
    }
}
