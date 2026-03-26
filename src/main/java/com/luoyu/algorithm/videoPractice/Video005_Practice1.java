package com.luoyu.algorithm.videoPractice;

import java.util.Arrays;

/**
 * @author Yang QingBo
 * {@code @date} 2026-03-16 21:16
 */

/*
    对数器练习
 */
public class Video005_Practice1 {
    public static void main(String[] args) {
        // 随机数组长度
        int N = 200;
        // 随机数组范围
        int V = 1000;
        // 测试次数
        int testTimes = N * V;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            // 随机一个数组长度 范围在 0 -> N-1
            int n = (int) (Math.random() * N);

            int[] arr = randomArray(n, V);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            if (i == 0){
                System.out.println(n);
                System.out.println(Arrays.toString(arr));
                System.out.println(arr.length);
            }
            selectionSort(arr1);
            bubbleSort(arr2);
            insertSort(arr3);
            if(!sameArray(arr1,arr2) || !sameArray(arr1,arr3)){
                System.out.println("出错了！");
            }
        }

    }

    // 随机得到一个数组
    // 数组长度为 n
    // 数组范围为 1-v
    private static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v + 1);
        }
        return arr;
    }

    private static int[] copyArray(int[] arr) {
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }

    private static boolean sameArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        if (n != arr2.length) return false;
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // 交换两个数字
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 选择排序
    // 一句话总结：在 i -> n-1 上找到最小值放到 i 位置上 然后在 i+1 -> n-1 继续
    private static void selectionSort(int[] arr) {
        // 非空判断
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int minIndex, i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    // 冒泡排序
    // 一句话总结：在 0 -> i 上范围上最大数一直往后冒 最终来到 i 位置上  然后在 0 -> i-1 继续
    private static void bubbleSort(int[] arr) {
        // 非空判断
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
    }


    // 插入排序
    // 一句话总结：在 0 -> i 上已经有序的数组 新来的数字从右向左滑不再小的位置插入
    private static void insertSort(int[] arr) {
        // 非空判断
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

}
