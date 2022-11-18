package min_stack;

import java.util.LinkedList;
import java.util.Stack;


public class MinStack {

    static class StackNode {
        int val;
        StackNode prev;
        StackNode minprev;

        StackNode(int v) {
            val = v;
        }
    }

    StackNode head = null;
    StackNode tail = null;

    StackNode currentMin = null;

    public MinStack() {
    }

    public void push(int val) {
        if (null == head) {
            head = new StackNode(val);
            tail = head;
            currentMin = tail;
        } else {
            StackNode newtail = new StackNode(val);
            newtail.prev = tail;
            tail = newtail;
        }
        if (tail.val < currentMin.val) {
            tail.minprev = currentMin;
            currentMin = tail;
        }
    }

    public void pop() {
        if (tail == currentMin) {
            currentMin = tail.minprev;
        }
        tail = tail.prev;
        if (tail == null) {
            head = null;
        }
    }

    public int top() {
        return tail.val;
    }

    public int getMin() {
        return currentMin.val;
    }
}
