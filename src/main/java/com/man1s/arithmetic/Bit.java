package com.man1s.arithmetic;

/**
 * Title:Bit
 * Description:
 * Company:北京华宇元典信息服务有限公司
 *
 * @author:wangjiyu
 * @version:1.0
 * @date:2019/3/25 18:03
 */
public class Bit {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long b = 2;
        for (int i = 0; i < 1000000000; i++) {
            long l = (i * 1000000000 + i) % b;
        }
        System.out.println(System.currentTimeMillis() - start);


        long middle = System.currentTimeMillis();
        long bb = 1;
        for (int i = 0; i < 1000000000; i++) {
            long l = (i * 1000000000 + i) & bb;

        }
        System.out.println(System.currentTimeMillis() - middle);
    }
}
