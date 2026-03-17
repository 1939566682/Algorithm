package com.luoyu.algorithm.videoPractice;

/**
 * @author Yang QingBo
 * {@code @date} 2026-03-17 17:14
 */

// 峰值元素是指其值严格大于左右相邻值的元素
// 给你一个整数数组 nums，已知任何两个相邻的值都不相等
// 找到峰值元素并返回其索引
// 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
// 你可以假设 nums[-1] = nums[n] = 无穷小
// 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
// 测试链接 : https://leetcode.cn/problems/find-peak-element/
public class Video006_4_Practice {
    class Solution {
        public int findPeakElement(int[] arr) {
            int n = arr.length;
            if (n == 0) {
                return 0;
            }

            if (arr[0] > arr[1]) {
                return 0;
            }
            if (arr[n - 2] > arr[n - 1]) {
                return n - 1;
            }

            int l = 1, r = n - 2, ans = -1, mid;
            while (l <= r) {
                mid = (l + r) / 2;
                if (arr[mid - 1] > arr[mid]) {
                    r = mid - 1;
                } else if (arr[mid + 1] > arr[mid]) {
                    l = mid + 1;
                } else {
                    ans = mid;
                    break;
                }
            }
            return ans;
        }
    }
}
