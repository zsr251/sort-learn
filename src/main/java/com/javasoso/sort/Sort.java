package com.javasoso.sort;

/**
 * 排序接口
 */
public interface Sort {
    /**
     * 执行排序
     * @param arr
     * @return 执行了多少次
     */
     long doSort(int[] arr);
}
