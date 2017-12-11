package com.dream.java.algorithm;

/**
 * https://github.com/Blankj/awesome-java-leetcode/blob/master/note/007/README.md.
 * <p>
 * Created by william on 12/11/17.
 */

public class A002_ReverseInteger {


    public static void main(String[] args) {
        A002_ReverseInteger reverseInteger = new A002_ReverseInteger();
        int reverseNum = reverseInteger.reverse(1256789);
        System.out.println( "reverseInteger = " + reverseNum);
    }

    public int reverse(int x) {
        long res = 0;
        for (; x != 0; x /= 10) {
            res = res * 10 + x % 10;
        }
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }

}
