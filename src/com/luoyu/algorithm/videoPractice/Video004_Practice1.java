package com.luoyu.algorithm.videoPractice;

import java.util.Arrays;

/**
 * @author Yang QingBo
 * {@code @date} 2026-03-15 20:18
 */

public class Video004_Practice1 {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 11, 6, 2, 8, 4, 3, 16, 5};
        selectionSort(arr);
        bubbleSort(arr);
        insertSort(arr);
    }

    // 交换两个数的位置
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 选择排序
    // 一句话总结：i -> n-1 位置上找到最小值放到 i 位置上  然后 i+1 -> n-1 上继续
    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int minIndex, i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        System.out.println("选择排序排序结果：" + Arrays.toString(arr));
    }

    // 冒泡排序
    // 一句话总结：0 -> i 范围上 最大的数一直向后冒 最终来到 i 位置上  然后 0 -> i-1 位置上继续
    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
        System.out.println("冒泡排序排序结果：" + Arrays.toString(arr));
    }

    // 插入排序
    // 一句话总结：0 -> i 范围上已经有序 新来的数字从右向左滑到不再小的位置插入  然后继续
    private static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
        System.out.println("插入排序排序结果：" + Arrays.toString(arr));
    }
}
