package com.man1s.lambda;

/**
 * Title:Demo01
 * Description:
 * Company:北京华宇元典信息服务有限公司
 *
 * @author:wangjiyu
 * @version:1.0
 * @date:2019/1/23 14:05
 */
public class Demo01 {


}

class Hello {
    Runnable r1 = () -> {
        System.out.println(this);
    };  //lambda表达式

    Runnable r2 = new Runnable() {  //匿名内部类
        @Override
        public void run() {
            System.out.println(this);
            System.out.println(this.getClass());
        }
    };

    public String toString() {
        return "Hello, world";
    }

    public static void main(String... args) {
        Hello hello = new Hello();
        System.out.println(hello);
        hello.r1.run();   //输出 'Hello, world'
        hello.r2.run();   //输出 类似 'Hello$1@5b89a773' 的字符串
    }
}