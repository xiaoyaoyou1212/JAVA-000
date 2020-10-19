/**
 * @Description: 编写四则运算、if条件判定、for循环功能，用来进行字节码分析
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @FileName: Hello
 * Copyright (C), 2015-2020
 */
public class Hello {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int count = 6;
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                System.out.println(add(a, b));
            } else if (i == 1) {
                System.out.println(subtract(a, b));
            } else if (i == 2) {
                System.out.println(multiply(a, b));
            } else if (i == 3) {
                System.out.println(divide(a, b));
            } else if (i == 4) {
                System.out.println(remainder(a, b));
            } else {
                System.out.println(negate(i));
            }
        }
    }

    /**
     * 加法
     *
     * @param a
     * @param b
     * @return
     */
    private static int add(int a, int b) {
        return a + b;
    }

    /**
     * 减法
     *
     * @param a
     * @param b
     * @return
     */
    private static int subtract(int a, int b) {
        return a - b;
    }

    /**
     * 乘法
     *
     * @param a
     * @param b
     * @return
     */
    private static int multiply(int a, int b) {
        return a * b;
    }

    /**
     * 除法
     *
     * @param a
     * @param b
     * @return
     */
    private static int divide(int a, int b) {
        return a / b;
    }

    /**
     * 取余
     *
     * @param a
     * @param b
     * @return
     */
    private static int remainder(int a, int b) {
        return a % b;
    }

    /**
     * 取反
     *
     * @param a
     * @return
     */
    private static int negate(int a) {
        return ~a;
    }
}
