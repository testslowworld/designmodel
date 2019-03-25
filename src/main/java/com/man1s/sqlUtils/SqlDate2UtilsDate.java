package com.man1s.sqlUtils;

/**
 * Title:SqlDate2UtilsDate
 * Description:
 * Company:北京华宇元典信息服务有限公司
 *
 * @author:wangjiyu
 * @version:1.0
 * @date:2019/2/11 11:01
 */
public class SqlDate2UtilsDate {
    private static void test() {
        System.out.println("sqlDate... " + new java.sql.Date(10000).toString());
        System.out.println("utilsDate... " + new java.util.Date(10000).toString());


        System.out.println("sqlTime... " + new java.sql.Time(10000).toString());
        System.out.println("utilsDate... " + new java.util.Date(10000).toString());


        System.out.println("sqlTimestamp... " + new java.sql.Timestamp(10000).toString());
        System.out.println("utilsDate... " + new java.util.Date(10000).toString());

        long time = 1001;
        System.out.println((time / 1000) * 1000);

    }

    public static void main(String[] args) {
        test();
    }

}
