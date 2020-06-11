package day08_430;

import java.util.Stack;

/**
 * ClassName:day08
 * Package:day08_430
 * Discription:
 *
 * @Data:2020/6/8 20:22
 */
public class day08 {
    public Node flatten(Node head) {
        Node temp = head;
        Stack<Node> stack = new Stack<>();
        while (temp != null ) {
            if (temp.child == null) {
                if (temp.next == null && !stack.isEmpty()) {
                    Node tail = stack.pop();
                    temp.next = tail;
                    tail.prev = temp;
                }
                temp = temp.next;
            } else {
                if (temp.next != null)
                    stack.add(temp.next);
                temp.next = temp.child;
                temp.child = null;
                temp.next.prev = temp;
                temp = temp.next;
            }

        }
        return head;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
