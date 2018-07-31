package com.javasoso.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 直接排序的改进版，非稳定排序算法
 */
public class ShellSort implements Sort {
    @Override
    public long doSort(int[] arr) {
        long n = 0;
        // 计算增量
        // 常用的h序列由Knuth提出，该序列从1开始，通过如下公式产生：h = 3 * h +1
        // 反过来程序需要反向计算h序列，应该使用：h=(h-1)/3
        int h = arr.length;

        while (h > 1) {
            //设置新的增量
            h = h / 3 + 1;

            for (int i = 0; i < arr.length; i++) {
                //进行插入排序
                for (int j = i; j > h - 1; j -= h) {
                    n++;
                    if (arr[j] < arr[j - h]) {
                        int tmp = arr[j - h];
                        arr[j - h] = arr[j];
                        arr[j] = tmp;
                    }
//                    System.out.println(String.format("第%d次：%s", n, Arrays.toString(arr)));
                }
            }

        }
        return n;

    }

    public static void main(String[] args) {
        int arr[] = {7, 6, 5,1,10 ,0,4, 3, 2, 1};
        arr = SortRunner.initArray(25,25);
        Sort sort = new ShellSort();
        sort.doSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
