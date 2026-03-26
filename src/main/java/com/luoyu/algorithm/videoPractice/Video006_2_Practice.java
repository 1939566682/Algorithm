package com.luoyu.algorithm.videoPractice;

import java.util.Arrays;

/**
 * @author Yang QingBo
 * {@code @date} 2026-03-17 17:13
 */

// 有序数组中找>=num的最左位置
public class Video006_2_Practice {
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
            if (check(ints, num) != findLeft(ints, num)) {
                System.out.println("出错了！");
                if (i == 1) {
                    System.out.println();
                    System.out.println("check:" + check(ints, num));
                    System.out.println("findLeft:" + findLeft(ints, num));
                }
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
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }

    // 保证 arr 有序才能使用该方法
    private static int findLeft(int[] arr, int num) {
        int l = 0, r = arr.length - 1,mid,ans = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if(arr[mid] >= num){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

}
