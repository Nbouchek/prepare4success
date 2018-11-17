package com.ucandoit2.nacer.collections;

public class GenericsDemo {
    public static void main(String[] args) {
        CacheAny<String> myGenericsMessage = new CacheAny<>();
        myGenericsMessage.add("TT");
        System.out.println((myGenericsMessage.getT()));

        CacheAny<Integer> myGenericsNumber = new CacheAny<>();
        myGenericsNumber.add(12);
        System.out.println((myGenericsNumber.getT()));
    }
}

class CacheAny <T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void add(T t) {
        this.setT(t);
    }
}