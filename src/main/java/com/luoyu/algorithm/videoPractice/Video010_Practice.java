package com.luoyu.algorithm.videoPractice;

/**
 * @author Yang QingBo
 * {@code @date} 2026-03-26 22:31
 */

// 将两个升序链表合并为一个新的 升序 链表并返回
// 新链表是通过拼接给定的两个链表的所有节点组成的
// 测试链接 : https://leetcode.cn/problems/merge-two-sorted-lists/
public class Video010_Practice {

    public static class ListNode {
        Integer val;
        ListNode next;

        ListNode(Integer val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(Integer val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 合并两个有序链表
    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        // 非空判断
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        // 创建虚拟头节点
        ListNode dummyHead = new ListNode(0);
        // 创建一个 cur 指针，用来拼接新链表
        ListNode cur = dummyHead;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummyHead.next;
    }

    // 链表反转方法
    public static void traverse(ListNode head) {
        if (head == null) {
            System.err.println("head is null");
            return;
        }
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.val+" -> ");
            curr = curr.next;
        }
        System.out.println("null");

    }

    public static void main(String[] args) {
        // 链表1
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        System.out.print("链表1：");
        traverse(l1);

        // 链表2
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        System.out.print("链表2：");
        traverse(l2);

        System.out.print("合并链表一和链表二：");
        ListNode newNode = mergeTwoLists(l1, l2);
        traverse(newNode);
    }
}
