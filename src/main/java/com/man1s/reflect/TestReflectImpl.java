package com.man1s.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

/**
 * Title:TestReflectImpl
 * Description:
 * Company:北京华宇元典信息服务有限公司
 *
 * @author:wangjiyu
 * @version:1.0
 * @date:2019/2/15 17:18
 */
public class TestReflectImpl {
    public static void main(String[] args) {
        Integer[] a = {6, 5, 4};
        Integer[] b = {7, 5, 4};
        Integer[] c = {8, 5, 4};

        LinkedHashMap map = new LinkedHashMap();
        map.put("key1", "va");
        map.put("key2", "va");
        Object obj = new TestReflectImpl();
        for (Method m : obj.getClass().getDeclaredMethods()) {
            try {
                if (m.getName().equals("test")) {
                    m.invoke(obj, null);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }

    public static void test() {
        System.out.println("testing........");
    }

}
