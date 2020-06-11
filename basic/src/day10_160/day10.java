package day10_160;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName:day10
 * Package:day10_160
 * Discription:
 *
 * @Data:2020/6/11 11:04
 */
public class day10 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while (headB!=null){
            if (set.contains(headB)) return headB;
            headB=headB.next;
        }
        return null;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
