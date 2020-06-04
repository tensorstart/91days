package day03;

import java.util.Arrays;

/**
 * ClassName:CustomStack
 * Package:day03
 * Discription:请你设计一个支持下述操作的栈。
 * <p>
 * 实现自定义栈类 CustomStack ：
 * <p>
 * CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
 * void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
 * int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。
 * void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
 * [[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
 * 输出：
 * [null,null,null,2,null,null,null,null,null,103,202,201,-1]
 * 解释：
 * CustomStack customStack = new CustomStack(3); // 栈是空的 []
 * customStack.push(1);                          // 栈变为 [1]
 * customStack.push(2);                          // 栈变为 [1, 2]
 * customStack.pop();                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
 * customStack.push(2);                          // 栈变为 [1, 2]
 * customStack.push(3);                          // 栈变为 [1, 2, 3]
 * customStack.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
 * customStack.increment(5, 100);                // 栈变为 [101, 102, 103]
 * customStack.increment(2, 100);                // 栈变为 [201, 202, 103]
 * customStack.pop();                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
 * customStack.pop();                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
 * customStack.pop();                            // 返回 201 --> 返回栈顶值 201，栈变为 []
 * customStack.pop();                            // 返回 -1 --> 栈为空，返回 -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-a-stack-with-increment-operation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Data:2020/6/3 10:24
 */
class CustomStack {
    private int maxsize;
    private int[] stack;
    private int rear = -1;

    public CustomStack(int maxSize) {
        maxsize = maxSize;
        stack = new int[maxsize];
    }


    public void push(int x) {
        if (rear < maxsize - 1) {
            rear++;
            stack[rear] = x;
        }
    }

    public int pop() {
        if (rear < 0) return -1;
        int popnum = stack[rear];
        rear--;
        return popnum;
    }

    public void increment(int k, int val) {
        if (k > stack.length) {
            for (int i = 0; i < stack.length; i++) {
                stack[i] += val;
            }
        } else {
            for (int i = 0; i <= k-1; i++) {
                stack[i] += val;
            }
        }
    }

    @Override
    public String toString() {
        return "CustomStack{" +
                "maxsize=" + maxsize +
                ", stack=" + Arrays.toString(stack) +
                ", rear=" + rear +
                '}';
    }
}

class impl_stack {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(4);
        stack.increment(8,10);
        System.out.println(stack.toString());
    }
}

/*
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */