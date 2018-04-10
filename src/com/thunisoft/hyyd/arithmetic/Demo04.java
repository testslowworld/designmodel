package com.thunisoft.hyyd.arithmetic;

public class Demo04 {
    //abbbaaaccccccd
    public static void main(String[] args) {
        String str = "abbbaaaccccccd";
        String[] array = new String[10];
        char[] s = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (s.length > i + 1 && s[i] == s[i + 1]) {
                i++;
                count++;
            }
            if (array[count] != null) {
                array[count] += "," + s[i];
            } else {
                array[count] = s[i] + "";
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(i + "==" + array[i]);
        }
    }

}
