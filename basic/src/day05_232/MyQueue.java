package day05_232;

import java.util.Stack;

/**
 * ClassName:MyQueue
 * Package:day05_232
 * Discription:使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Data:2020/6/5 10:33
 */
public class MyQueue {
    /** Initialize your data structure here. */
    private Stack<Integer> stackin;
    private Stack<Integer> stackout;
    public MyQueue() {
        this.stackin=new Stack<>();
        this.stackout=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackin.add(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop(){
        if (this.empty())throw new RuntimeException("空队列");
        if (!stackout.isEmpty())
            return stackout.pop();
        else {
            while (!stackin.isEmpty()){
                stackout.add(stackin.pop());
            }
            return stackout.pop();
        }

    }

    /** Get the front element. */
    public int peek() {
        if (this.empty())throw new RuntimeException("空队列");
        if (!stackout.isEmpty())
            return stackout.peek();
        else {
            while (!stackin.isEmpty()){
                stackout.add(stackin.pop());
            }
            return stackout.peek();
        }

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackout.isEmpty()&&stackin.isEmpty();
    }
}
class testMyQueue{
    public static void main(String[] args){
        MyQueue myQueue = new MyQueue();
        myQueue.push(2);
        myQueue.push(1);
        int pop = myQueue.pop();
        myQueue.push(1);
        myQueue.push(4);
        int pop1 = myQueue.pop();
        int peek = myQueue.peek();
        System.out.println(pop);
    }
}

/*
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

