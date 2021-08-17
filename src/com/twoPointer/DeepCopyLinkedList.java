package com.twoPointer;

public class DeepCopyLinkedList {
    public static Node deepCopy(Node head) {
        Node itr = head;
        Node front = head;

        //creating copy of each nodes
        while (itr != null) {
            front = itr.next;

            Node copy = new Node(itr.val);
            itr.next = copy;

            copy.next = itr.next;

            itr = front;
        }

        //pointing the random pointer

        itr = head;
        while (itr != null) {
            if (itr.next.random != null) {
                itr.next.random = itr.random.next;
            }
            itr = itr.next.next;
        }

        //restoring to original list
        itr = head;
        Node pseudoNode = new Node(0);
        Node copy = pseudoNode;
        while (itr != null) {
            front = itr.next.next;

            // Extracting the copy
            copy.next = itr.next;
            copy = copy.next;

            //restoring the original list
            itr.next = front;
            itr = front;
        }
        return pseudoNode.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
