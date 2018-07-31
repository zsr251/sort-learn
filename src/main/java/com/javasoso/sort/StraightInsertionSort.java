package com.javasoso.sort;

import java.util.Arrays;

/**
 * 直接插入排序
 * 算法复杂度：O(n²)
 */
public class StraightInsertionSort implements Sort {
    @Override
    public long doSort(int[] arr) {
        int n = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                n++;
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }

//                System.out.println(String.format("第%d次：%s", n, Arrays.toString(arr)));
            }

        }
        return n;
    }

    public static void main(String[] args) {
        int arr [] = {5,4,3,2,1};
        Sort sort = new StraightInsertionSort();
        sort.doSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
