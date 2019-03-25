package com.man1s.classloader;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Title:Test
 * Description:
 * Company:北京华宇元典信息服务有限公司
 *
 * @author:wangjiyu
 * @version:1.0
 * @date:2018/12/29 13:30
 */
public class Test {

    public static void main(String[] args) {
        Map<String, String> strMap = new HashMap<String, String>();
        String tempStr = "";
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            strMap.put(String.valueOf(i), String.valueOf(i + 1));
        }
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Iterator<String> ketIter = strMap.keySet().iterator();
            while (ketIter.hasNext()) {
                tempStr = ketIter.next();
                tempStr = strMap.get(tempStr);
            }
        }
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            for (String key : strMap.keySet()) {
                tempStr = key;
                tempStr = strMap.get(key);
            }
        }
        long t2 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Iterator<Map.Entry<String, String>> strMapItor = strMap.entrySet().iterator();
            while (strMapItor.hasNext()) {
                Map.Entry<String, String> entry = strMapItor.next();
                tempStr = entry.getKey();
                tempStr = entry.getValue();
            }
        }
        long t3 = System.currentTimeMillis();
        System.out.println("Time0--" + (t0 - ts));
        System.out.println("Time1--" + (t1 - t0));
        System.out.println("Time2--" + (t2 - t1));
        System.out.println("Time3--" + (t3 - t2));

    }

    
    //intern  取出常量池中的对象
    public static void testIntern() {
        String str1 = "str";
        String str2 = new String("str");
        String str3 = new String("str");
        System.out.println(str1 == str2.intern());
        System.out.println(str1.intern() == str2.intern());
        System.out.println(str3.intern() == str2.intern());
    }


}
