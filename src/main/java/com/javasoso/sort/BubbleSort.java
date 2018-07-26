package com.javasoso.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 算法复杂度：O(n²)
 */
public class BubbleSort implements Sort {

    /**
     * 执行排序
     *
     * @param arr 原始数组
     * @return
     */
    @Override
    public long doSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            throw new RuntimeException("原始数组错误");
        }
        // 比较次数
        long n = 0;
        // 外层循环 决定两两交换需要几趟。跑几趟就说明有几个最大数被选出，
        // length-1 是因为只剩下一个数字的情况下是不需要排序的，可节省一趟
        for (int i = 0; i < arr.length - 1; i++) {
            // 内层循环 决定一趟内两两比较交换多少次
            // length-1  是因为我们需要比较后一个数值的大小，避免数组越界
            // length-i 优化了 已排序的部分不再对比 i是跑了第几趟 即 已有几个已完成排序的数组
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 记录执行排序次数
                n++;
                // 使用了两个缓存变量 是为了代码可读性。实际排序可只是用一个缓存变量 或不命名变量直接做交换
                // 如：a b交换 a=a+b;b=a-b;a=a-b; 或 a^=b;b^=a;a^=b;
                int a = arr[j];
                int b = arr[j + 1];
                // 如果前一个值比后一个值大，则交换
                if (a > b) {
                    arr[j] = b;
                    arr[j + 1] = a;
                }
//                System.out.println(String.format("第%d次：%s", ++n, Arrays.toString(arr)));
            }
        }
        return n;
    }

}
