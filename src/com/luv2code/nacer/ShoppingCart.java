package com.luv2code.nacer;

public class ShoppingCart {
    public static void main(String[] args) {
        String custName = "Muhammad";
        String itemDesc = "shirt";
        String message;

        int quantity = 3;
        double price = 29.99;
        double tax = 1.10;
        double total;

        message = custName + " wants to purchase " + quantity + " " + itemDesc + " at " + price;
        System.out.println(message);

        total = quantity * price * tax;
        System.out.println("Muhammads' total: " + total);
    }
}
