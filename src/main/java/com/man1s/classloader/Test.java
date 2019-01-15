package com.man1s.classloader;

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
