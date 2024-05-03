package no09_자료구조구현.큐;

public class StackArray {
	// 배열로 구현 
    public static void main(String[] args) {
        int size = 5;
        StackA stack = new StackA(size);

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

class StackA {
    private int top;
    private int[] stackArr;
    private int size;

    public StackA(int size) {
        top = -1;
        this.stackArr = new int[size];
        this.size = size;
    }

    public void push(int val) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        stackArr[++top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return stackArr[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        }
        else {
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArr[i] + " ");
            }
        }
        System.out.println("");
    }
}