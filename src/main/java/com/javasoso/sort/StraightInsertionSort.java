package com.javasoso.sort;

/**
 * 直接插入排序
 * 算法复杂度：O(n²)
 */
public class StraightInsertionSort implements Sort {
    @Override
    public long doSort(int[] arr) {
        long n = 0;
        for (int i = 1; i < arr.length; i++) {
            // 当前需要插入的
            int a = arr[i];

            for (int j = i - 1; j >= 0; j--) {
                // 记录执行排序次数
                n++;
                int b = arr[j];
                // 如果需要插入的值小于 当前值 则应该应插入的位置在前面
                if (a < b) {
                    // 如果已经是第一个了 则把当前值向后移动一位 插入值直接插入到0位置
                    if (j == 0) {
                        arr[j + 1] = b;
                        arr[j] = a;
                    } else {
                        // 当前值向后移动一位，为了更直观原位置用-1代替
                        arr[j + 1] = b;
                        arr[j] = -1;
                    }
//                    System.out.println(String.format("第%d次：%s", ++n, Arrays.toString(arr)));
                } else {
                    // 如果要插入的值大于或者等于当前值，则要把需要插入的值插入到当前值得后边
                    // 由于是已经排好序的，则不用判断之后的顺序 直接跳出内循环
                    arr[j + 1] = a;
//                    System.out.println(String.format("第%d次：%s", ++n, Arrays.toString(arr)));
                    // 已排好
                    break;
                }


            }

        }

        return n;
    }
}
