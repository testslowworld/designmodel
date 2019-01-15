package com.man1s.arithmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Demo03 {

    //{3，32，321}
    public static void main(String[] args) {
        int[] i = { 3, 34, 341 };
        System.out.println(PrintMinNumber(i));
    }

    public static String PrintMinNumber(int[] numbers) {
        String result = "";
        int length = numbers.length;
        if (length < 1) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String result1 = o1 + "" + o2;
                String result2 = o2 + "" + o1;
                return result1.compareTo(result2);
            }
        });
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            result += (iterator.next() + "");
        }
        return result;
    }

}
