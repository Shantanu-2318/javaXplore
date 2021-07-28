package com.swheaqni;

import java.util.ArrayList;

public class Mobilephone {
    private ArrayList <Contact> PhoneBook=new ArrayList<Contact>();
    public boolean addContact(Contact contact) {
        if (searchContacts(contact.getName())!=null){
            System.out.println("Contact already exists");
            return false;
        }
        else {
            PhoneBook.add(contact);
            return true;
        }
    }
    public boolean removeContacts(String name){
        for (Contact i : PhoneBook){
            if(i.getName()==name){
                PhoneBook.remove(i);
                return true;
            }
        }
            System.out.println("Contact does not exists");
        return false;
    }
    public boolean editContacts(Contact contact ,Contact newcontact){
        for (Contact i : PhoneBook){
            if(i==contact){
                PhoneBook.set(PhoneBook.indexOf(i),newcontact);
                return true;
            }
        }
        System.out.println("Contact does not exists");
        return false;
    }
    public int findContacts(int number){
        for (Contact i : PhoneBook){
            if(i.getNumber()==number){
                System.out.println("Name : "+i.getName());
                System.out.println("Number : "+i.getNumber());
                return 0;
            }
        }
        System.out.println("Contact not found in the contact list");
        return -1;
    }
    public Contact searchContacts(String name){
        for (Contact i : PhoneBook){
            if(i.getName()==name){
                return i;
            }
        }
        return null;
    }
    public int findContacts(String name){
        for (Contact i : PhoneBook){
            if(i.getName()==name){
                System.out.println("Name : "+i.getName());
                System.out.println("Number : "+i.getNumber());
                return 0;
            }
        }
        System.out.println("Contact not found in the contact list");
        return -1;
    }
}
