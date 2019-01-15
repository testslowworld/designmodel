package com.man1s.jvm;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Title:VisualVM
 * Description:
 * Company:北京华宇元典信息服务有限公司
 *
 * @author:wangjiyu
 * @version:1.0
 * @date:2018/11/14 13:55
 */
public class VisualVM {
    private static List<Double> doubles = new ArrayList<>();

    private static void addDouble(int size) {
        Class clazz = doubles.getClass();
        try {
            Field f = clazz.getDeclaredField("elementData");
            f.setAccessible(true);
            Object obj = f.get(doubles);
            obj.hashCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Long start = System.currentTimeMillis();
        for (int t = 0; t < size; t++) {
            doubles.add(Math.random());
            if (t % 100 == 0) {
                System.out.println(t);
            }
            try {
//                Thread.sleep(10);
            } catch (Exception e) {

            }

        }
        System.out.println();
        System.out.println("用时," + (System.currentTimeMillis() - start));
        System.out.println(doubles.get(size - 10000));
        System.out.println("point 2");
    }


    public static void main(String[] args) {
        System.out.println("point 1");
        addDouble(10000000);
        System.out.println("point 3");
    }


}
