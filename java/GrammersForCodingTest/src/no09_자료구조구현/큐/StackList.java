package no09_자료구조구현.큐;

import java.util.EmptyStackException;

public class StackList {
    public static void main(String[] args) {
        StackB stack = new StackB();

        stack.push(1);
        stack.printStack();
        stack.push(2);
        stack.printStack();
        stack.push(3);
        stack.printStack();
        stack.pop();
        stack.printStack();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }    
}

class StackB {
    private Node top;

    public void push(int val) {
        Node node = new Node(val);
        node.next = top;
        top = node;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node node = top;
        int data = node.data;
        top = top.next;
        node = null;
        return data;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        }
        else {
            Node node = this.top;

            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println("");
        }
    }
}