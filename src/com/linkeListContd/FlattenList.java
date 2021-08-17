package com.linkeListContd;

public class FlattenList {
    public static Node mergeTwoLists(Node a, Node b){
        Node temp = new Node(0);
        Node res = temp;
        while (a!=null&&b!= null){
            if (a.data < b.data){
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            }
            else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }
        if (a!=null){
            temp.bottom = a;
        }else {
            temp.bottom = b;
        }
        return res.bottom;
    }
    public static Node flatten(Node root){
        if (root==null || root.next == null){
            return root;
        }
        root.next = flatten(root.next);
        root = mergeTwoLists(root, root.next);
        return root;
    }
}
class Node{
    int data;
    Node next;
    Node bottom;
    Node(){
    }
    Node(int data){
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
    Node(int data, Node next){
        this.data = data;
        this.next = next;
        this.bottom = null;
    }
    Node(int data, Node next, Node bottom){
        this.data = data;
        this.next = next;
        this.bottom = bottom;
    }
}
