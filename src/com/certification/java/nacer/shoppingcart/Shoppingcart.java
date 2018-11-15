package com.certification.java.nacer.shoppingcart;

public class Shoppingcart {
    public static void main(String[] args) {
        String customerName = "Muhammad Ibraheem";
        String firstName;
        int spaceindex;
        StringBuilder sb;
        // get the index of the space character " "
        spaceindex = customerName.indexOf(" ");

        // Use the substring method to locate the surname
        firstName = customerName.substring(0, spaceindex);
        System.out.println(firstName);

        // instantiate and initialize sb to the firstName
        sb = new StringBuilder(firstName);
        sb.append(" Ibraheem");
        System.out.println(sb);
    }
}