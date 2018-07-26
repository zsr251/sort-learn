package com.javasoso.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 执行排序
 */
public class SortRunner {
    public static void main(String[] args) {
        // 初始化无序数组
        int[] arr = initArray(100000, 100000);
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------");

        // 初始化排序方式
        Sort sort = null;

        // 冒泡排序
        sort = new BubbleSort();
        int[] arr1 = Arrays.copyOf(arr, arr.length);
//        System.out.println(Arrays.toString(arr1));
        // 执行排序
        long t1 = sort(arr1, sort);
//        System.out.println(Arrays.toString(arr1));
        System.out.println("-----------------");

        // 简单选择排序
        sort = new SimpleSelectionSort();
        int[] arr2 = Arrays.copyOf(arr, arr.length);
//        System.out.println(Arrays.toString(arr2));
        // 执行排序
        long t2 = sort(arr2, sort);
//        System.out.println(Arrays.toString(arr2));
        System.out.println("-----------------");

        // 直接插入排序
        sort = new StraightInsertionSort();
        int[] arr3 = Arrays.copyOf(arr, arr.length);
//        System.out.println(Arrays.toString(arr3));
        // 执行排序
        long t3 = sort(arr3, sort);
//        System.out.println(Arrays.toString(arr3));


        System.out.println("数组长度：" + arr.length);
    }

    /**
     * 进行排序
     *
     * @param arr 原数组
     * @return 执行了多少次
     */
    public static long sort(int[] arr, Sort sort) {
        if (arr == null || arr.length < 1) {
            throw new RuntimeException("原始数组错误");
        }
        if (sort == null) {
            throw new RuntimeException("无排序方式");
        }
        long startTime = System.currentTimeMillis();
        System.out.println(String.format("-------排序开始 开始时间【%dms】-------", startTime));
        long n = sort.doSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("-------排序结束 结束时间【%dms】排序次数【%d】耗时【%dms】-------", endTime, n, endTime - startTime));
        return endTime - startTime;
    }

    /**
     * 初始化生成一个乱序的数组
     *
     * @return
     */
    public static int[] initArray(int minLen, int maxLen) {
        Random r = new Random(System.currentTimeMillis());
        int n = r.nextInt(maxLen) % (maxLen - minLen + 1) + minLen;
        int[] arr = new int[n];
        int l = 2 * maxLen;
        while (n-- > 0) {
            arr[n] = r.nextInt(l);
        }
        return arr;
    }


}
