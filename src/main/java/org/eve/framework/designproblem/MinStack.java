package org.eve.framework.designproblem;

/**
 * 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * ->push(x) -- 将元素 x 推入栈中。
 * ->pop() -- 删除栈顶的元素。
 * ->top() -- 获取栈顶元素。
 * ->getMin() -- 检索栈中的最小元素。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/24/design/59/
 *
 * @author jc
 * @date 2019/9/22 10:18
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        //--> 返回 -3.
        System.out.println(minStack.getMin());
        minStack.pop();
        //--> 返回 0.
        System.out.println(minStack.top());
        //--> 返回 -2.
        System.out.println(minStack.getMin());
    }

    private int[] stack;
    private int min = Integer.MAX_VALUE;
    private int top = 0;
    private int capacity = 16;

    public MinStack() {
        stack = new int[capacity];
    }

    public void push(int x) {
        top++;
        if (top + 1 >= capacity) {
            int[] newStack = new int[capacity * 2];
            System.arraycopy(stack, 0, newStack, 0, capacity);
            capacity = capacity * 2;
            stack = newStack;
        }
        stack[top] = x;
        if (x < min) {
            min = x;
        }
    }

    public void pop() {
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return min;
    }
}
