package com.linkedList;

public class ReverseLinkedList {


    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static ListNode midleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode mergeTwoSortedLinkedList(ListNode l1, ListNode l2) {
        //inplace without create a duplicate node
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode result = l1;
        while (l1 != null && l2 != null) {
            ListNode temp = null;
            while (l1 != null && l1.val <= l2.val) {
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;

            //swapping
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        return result;
    }

    public static ListNode removeNthNodeFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    // Qn delete the given node when head is not given
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
    }

    public static ListNode addTwonumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry ==1){
            int sum = 0;
            if (l1 != null){
                sum+=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                sum += l2.val;
                l2=l2.next;
            }
            sum+=carry;
            carry = sum/10;
            ListNode node = new ListNode(sum %10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
