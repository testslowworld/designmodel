package com.man1s.designmodel;


class Client {
    public static void main(String[] args) {
        SuperCash cash = SimpleFactory.getCash("reduce");
        double total = cash.cal(10, 20);
        System.out.println(total);
    }
}

public class SimpleFactory {
    public static SuperCash getCash(String op) {
        if ("dsicount".equals(op)) {
            return new DiscountCash(0.7);
        } else if ("reduce".equals(op)) {
            return new FullReduce(200, 50);
        }
        return null;
    }

}

interface SuperCash {
    double cal(double firstText, double sec);
}

class DiscountCash implements SuperCash {
    double discount;

    public DiscountCash(double discount) {
        this.discount = discount;
    }

    @Override
    public double cal(double firstText, double sec) {
        return firstText * sec * discount;
    }
}

class FullReduce implements SuperCash {
    double full;
    double reduce;

    @Override
    public double cal(double firstText, double sec) {
        Double reduce = Math.floor(firstText * sec / full);
        return firstText * sec - reduce * this.reduce;
    }

    public FullReduce(double full, double reduce) {
        this.full = full;
        this.reduce = reduce;
    }
}

