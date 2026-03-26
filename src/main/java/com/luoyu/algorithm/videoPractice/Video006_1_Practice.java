package com.luoyu.algorithm.videoPractice;

import java.util.Arrays;

/**
 * @author Yang QingBo
 * {@code @date} 2026-03-17 17:05
 */

// 有序数组中是否存在一个数字
public class Video006_1_Practice {
    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTime = 500000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * N);
            int[] ints = randomArray(n, V);
            int num = (int) (Math.random() * V);
            Arrays.sort(ints);
            if (check(ints, num) != binarySearch(ints, num)) {
                System.out.println("出错了！");
                if (i == 1) {
                    System.out.println();
                    System.out.println("check:" + check(ints, num));
                    System.out.println("binarySearch:" + binarySearch(ints, num));
                }
            }
        }
        System.out.println("测试结束");
    }

    // 为了验证
    private static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v);
        }
        return arr;
    }

    // 为了验证
    // 保证 arr 有序才能使用该方法
    private static boolean check(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    // 保证 arr 有序才能使用该方法
    private static boolean binarySearch(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int l = 0, r = arr.length - 1, m;
        while (l <= r) {
            m = l + ((r - l) / 2);
            if (arr[m] == num) {
                return true;
            } else if (arr[m] < num) {
                l = m + 1;
            } else if (arr[m] > num) {
                r = m - 1;
            }
        }
        return false;
    }
}
