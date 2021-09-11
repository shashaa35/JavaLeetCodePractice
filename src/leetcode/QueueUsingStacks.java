package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueUsingStacks {
    static class MyQueue {
        Stack<Integer> pushStack, popStack;
        /** Initialize your data structure here. */
        public MyQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
            Queue<Integer> q = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            pushStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (popStack.isEmpty()) {
                moveElementsFromPushToPopStack();
            }
            return popStack.pop();
        }

        void moveElementsFromPushToPopStack() {
            while (!pushStack.isEmpty())
                popStack.push(pushStack.pop());
        }

        /** Get the front element. */
        public int peek() {
            if (popStack.isEmpty()) {
                moveElementsFromPushToPopStack();
            }
            return popStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }
    }

    public static void main(String[] args) {
        //Your MyQueue object will be instantiated and called as such:
        MyQueue obj = new MyQueue();
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
//        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
//        System.out.println(param_3);
        System.out.println(param_4);

    }

}
