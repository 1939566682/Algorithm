package com.luoyu.algorithm.videoPractice;

/**
 * @author Yang QingBo
 * {@code @date} 2026-03-26 20:19
 */

// 链表的原地反转
// 反转单链表测试链接 : https://leetcode.cn/problems/reverse-linked-list/
public class Video009_Practice {

    // 链表节点类
    public static class ListNode {
        public Integer val;
        public ListNode next;

        public ListNode(Integer val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(Integer val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 链表反转方法
    public static ListNode reverse(ListNode head) {
        // 非空判断
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null; // 前一个节点（初始 null）
        ListNode curr = head; // 当前节点（从头开始）
        ListNode next; // 临时保存下一个节点（防止丢链表）
        // 循环做 4 件事：保存 next → 反转指针 → pre 后移 → cur 后移

        // 遍历整个链表
        while (curr != null) {
            // 1. 保存下一个节点
            next =curr.next;
            // 2. 反转当前节点的指针
            curr.next = prev;
            // 3. pre 向后移动
            prev = curr;
            // 4. cur 向后移动
            curr = next;
        }
        return prev;
    }

    // 链表遍历方法
    public static void traverse(ListNode head) {
        if (head == null) {
            System.err.println("head is null");
            return;
        }
        System.out.print("链表元素：");
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        traverse(head);
        ListNode newNode = reverse(head);
        traverse(newNode);
    }
}
