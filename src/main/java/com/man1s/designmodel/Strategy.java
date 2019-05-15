package com.man1s.designmodel;

public class Strategy {
    public static void main(String[] args) {
        CashContext context = new CashContext();
        context.initCashType("reduce");
        double result = context.cal(200, 10);
        System.out.println(result);
    }
}

class CashContext {
    private SuperCash cash;

    public void initCashType(String type) {
        switch (type) {
            case "reduce":
                cash = new FullReduce(200, 50);
                break;
            case "charge":
                cash = new DiscountCash(0.8);
                break;

        }
    }

    public double cal(double firstText, double secText) {
        return cash.cal(firstText, secText);
    }
}

