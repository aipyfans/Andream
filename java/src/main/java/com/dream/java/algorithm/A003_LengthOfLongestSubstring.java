package com.dream.java.algorithm;

/**
 * https://github.com/Blankj/awesome-java-leetcode/blob/master/note/003/README.md
 * <p>
 * Created by william on 2018-01-08.
 */

public class A003_LengthOfLongestSubstring {


    public static void main(String[] args) {
        A003_LengthOfLongestSubstring reverseInteger = new A003_LengthOfLongestSubstring();
        int lengthOfLongestSubstring = reverseInteger.lengthOfLongestSubstring("aba");
        System.out.println("lengthOfLongestSubstring = " + lengthOfLongestSubstring);
    }

    /**
     * 题意是计算不带重复字符的最长子字符串的长度，开辟一个 hash 数组来存储该字符上次出现的位置，
     * 比如 hash[a] = 3 就是代表 a 字符前一次出现的索引在 3，遍历该字符串，获取到上次出现的最大索引（只能向前，不能退后）
     * 与当前的索引做差获取的就是本次所需长度，从中迭代出最大值就是最终答案.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;

        int preP = 0, max = 0;
        int[] hash = new int[128];

        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (hash[c] > preP) {
                preP = hash[c];
            }
            int length = i - preP + 1;
            hash[c] = i + 1;
            if (length > max) max = length;
        }
        return max;
    }

}
