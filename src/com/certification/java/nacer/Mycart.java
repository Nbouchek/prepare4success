package com.certification.java.nacer;

public class Mycart {
    public static void main(String[] args) {
        String custName = "Muhammad";
        String message;

        String[] items = {"Shirt", "Socks", "Scarf", "Belt"};

        message = custName + " wants to purchase " + items.length + " items.";
        System.out.println(message);

        System.out.println("Items purchased: ");
        for (String item : items) {
            System.out.print(item + ", ");
        }
    }
}
