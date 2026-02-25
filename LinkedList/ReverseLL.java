package com.QnSolving;

import java.util.Stack;

public class ReverseLL {

    private Node head;

    public static void main(String[] args) {
        ReverseLL reverseLL = new ReverseLL();
        reverseLL.addFirst(5);
        reverseLL.addFirst(2);
        reverseLL.addFirst(3);
        reverseLL.addFirst(1);
        reverseLL.display();
        Solution solution = new Solution();
        Node temp =solution.fn2(reverseLL.head);
        while (temp!=null){
            System.out.print(temp.value+" -> ");
            temp=temp.next;
        }
        System.out.print("END");
    }

    static class Solution{
        //approach 1 using stack
        public Node fn(Node head){
            Node temp = head;
            Stack<Integer> stack = new Stack<>();
            while (temp!=null){
                stack.push(temp.value);
                temp=temp.next;
            }
            Node temp1 = head;
            while (temp1!=null){
                temp1.value = stack.peek();
                stack.pop();
                temp1=temp1.next;
            }
            return head;
        }

        //optimized approach
        public Node fn2(Node head){
            if (head==null || head.next==null){
                return head;
            }
            Node prev = null;
            Node temp = head;
            Node front;
            while (temp!=null){
                front = temp.next;
                temp.next=prev;
                prev=temp;
                temp=front;
            }
            return prev;
        }

    }

    public void display(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.value+" -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }

    public void addFirst(int value){
        Node node = new Node(value);
        if (head==null){
            head=node;
            return;
        }
        node.next=head;
        head=node;
    }

    private class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
