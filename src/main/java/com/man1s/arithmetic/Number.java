package com.man1s.arithmetic;

/**
 * Title:Number
 * Description:
 * Company:北京华宇元典信息服务有限公司
 *
 * @author:wangjiyu
 * @version:1.0
 * @date:2018/12/21 18:14
 */
public class Number {
    public static void main(String[] args) {
        //
        test();
    }

    private static void test() {
        Integer i = new Integer(127);
        Integer ib = 127;
        System.out.println(i == ib);
    }
}
