package com.linkeListContd;

public class IntersectionPointOfTwoLinkedList {

    public static ListNode intersectionPoint(ListNode h1, ListNode h2) {
        if (h1 == null || h2 == null) {
            return null;
        }
        ListNode a = h1;
        ListNode b = h2;
        while (a != b) {
            a = a == null ? h2 : a.next;
            b = b == null ? h1 : b.next;
        }
        return a;
    }

    public static boolean isCyclePresent(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static ListNode reverseGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        ListNode nex = dummy;
        ListNode pre = dummy;

        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        while (count >= k) {
            cur = pre.next;
            nex = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -= k;
        }
        return dummy.next;
    }

    public static boolean isPalindrom(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        //finding middle of linkedlist
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reversing the right half
        slow.next = reverseList(slow.next);

        //move slow to right half
        slow = slow.next;

        //check if right half is equal to left half or not
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static ListNode FindStartingPoint(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode entry = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
            }
            return entry;
        }
        return null;
    }

    public static ListNode rotateLLByK(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode current = head;
        int len = 1;
        //computing the length
        while (current.next != null) {
            len++;
            current = current.next;
        }

        //go till that node
        current.next = head;
        k = k % len;
        k = len - k;
        while (k-- > 0) {
            current = current.next;
        }

        // make the node head and break connection
        head = current.next;
        current.next = null;

        return head;
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
