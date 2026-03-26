package com.luoyu.algorithm.practice;

/**
 * @author Yang QingBo
 * {@code @date} 2026-03-25 20:00
 */

/**
 * 1. 基础增删（最常用）
 * addFirst(val)：头插
 * addLast(val)：尾插
 * add(index, val)：指定位置插
 * removeFirst()：删头
 * removeLast()：删尾
 * removeByIndex(index)：按索引删
 * removeByValue(val)：按值删
 */

/**
 * 2. 查询 / 工具
 * get(index)：取值
 * contains(val)：查是否存在
 * isEmpty()：判空
 * getSize()：长度
 * clear()：清空
 * traverse()：打印
 */

/**
 *  3. 面试核心算法
 *  reverseList()：迭代原地反转
 *  reverseByRecursion()：递归反转
 *  mergeTwoLists()：合并有序链表
 *  findMiddleNode()：找中间节点
 *  hasCycle()：判断链表有环
 */
public class MyLinkedList {
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.addList(1);
        list.addList(2);
        list.addList(3);
        list.addList(4);
        list.traverse(list);
        list.addList(5);
        list.traverse(list);
        list.add(1,18);
        list.traverse(list);
        System.out.print("删除第一个：");
        list.removeFirst();
        list.traverse(list);
        System.out.print("删除最后一个：");
        list.removeLast();
        list.traverse(list);
        System.out.print("删除指定索引：");
        list.removeByIndex(2);
        list.traverse(list);
        System.out.print("清空链表：");
        list.clear();
    }

    public ListNode head; // 头节点：链表的入口
    private int size; // 链表的长度

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    // 定义单链表节点
    public static class ListNode {
        public int val; // 当前节点的值
        public ListNode next; // 指向下一个节点的引用

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }



    // 链表遍历方法
    public void traverse(ListNode head) {
        ListNode cur = head;
        System.out.print("链表元素：");
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public void traverse(MyLinkedList list) {
        ListNode cur = list.head;
        System.out.print("链表元素：");
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    // 头插法
    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // 尾插法
    public void addList(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
        size++;
    }

    // 指定索引插入
    public void add(int index, int val) {
        // 边界判断
        if (index < 0 || index > size) {
            throw new RuntimeException("索引越界");
        }
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == size) {
            addList(val);
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        // newNode.next = cur.next;
        // cur.next = newNode;
        size++;
        // index 3  7
        //  0  1  2  3  4  5
        //  1  2  3  4  5  6
        //=>1  2  3->7->5
    }


    // 删除头节点
    public void removeFirst() {
        if (head == null) {
            throw new RuntimeException("空指针异常：链表为空！");
        }
        head = head.next;
        size--;
    }

    // 删除尾节点
    public void removeLast() {
        if (head == null) {
            throw new RuntimeException("空指针异常：链表为空！");
        }
        if (size == 1) {
            head = null;
            size = 0;
            return;
        }
        ListNode cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        size--;
    }

    // 指定索引删除
    public void removeByIndex(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("索引越界");
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size) {
            removeLast();
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;

        // index 3  7
        //  0  1  2  3  4  5
        //  1  2  3  4  5  6
        //->1  2->4->5
    }

    // 清空链表
    public void clear() {
        head = null;
        size = 0;
    }

}
