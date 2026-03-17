package com.luoyu.algorithm.videoPractice;

import java.util.Arrays;

/**
 * @author Yang QingBo
 * {@code @date} 2026-03-17 17:14
 */

// 有序数组中找<=num的最右位置
public class Video006_3_Practice {
    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTime = 50000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * N);
            int[] ints = randomArray(n, V);
            int num = (int) (Math.random() * V);
            Arrays.sort(ints);
            if (check(ints, num) != findRight(ints, num)) {
                System.out.println("出错了！");

            }
            if (i == testTime - 1) {
                    System.out.println("找："+num);
                    System.out.println(Arrays.toString(ints));
                    System.out.println("findRight：" + findRight(ints, num));
                    System.out.println("findRight：" + ints[findRight(ints, num)]);
                    System.out.println("check：" + check(ints, num));
                    System.out.println("check：" + ints[check(ints, num)]);
            }

        }
        System.out.println("测试结束");
    }

    // 为了验证
    private static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }

    // 为了验证
    // 保证 arr 有序才能使用该方法
    private static int check(int[] arr, int num) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= num) {
                return i;
            }
        }
        return -1;
    }

    private static int findRight(int[] arr, int num) {
        int l = 0, r = arr.length - 1, mid, ans = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (arr[mid] <= num) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
