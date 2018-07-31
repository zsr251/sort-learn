package com.javasoso.sort;

import java.util.Arrays;

/**
 * 简单选择排序
 * 算法复杂度：O(n²)
 */
public class SimpleSelectionSort implements Sort {

    @Override
    public long doSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            throw new RuntimeException("原始数组错误");
        }
        // 比较次数
        long n = 0;
        // 外层循环 几次循环说明选择出多少个最小数
        // length-1 是因为只剩下一个数字的情况下是不需要排序的，可节省一趟
        for (int i = 0; i < arr.length - 1; i++) {
            // 默认当前就是最小数
            int min = arr[i];
            // 内层循环 最小数与哪些数做对比
            // i + 1 是因为在i之前的数都是已经排好的最小数，没必要进行比较
            for (int j = i + 1; j < arr.length; j++) {
                // 记录执行排序次数
                n++;
                int a = arr[j];
                // 如果最小值大于对比的值 则交换
                if (min > a) {
                    arr[i] = a;
                    arr[j] = min;
                    min = a;
                }
                System.out.println(String.format("第%d次：%s", n, Arrays.toString(arr)));
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int arr [] = {4,3,2,1};
        Sort sort = new SimpleSelectionSort();
        sort.doSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
