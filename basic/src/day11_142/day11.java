package day11_142;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName:day11
 * Package:day11_142
 * Discription:
 *
 * @Data:2020/6/11 21:41
 */
public class day11 {
    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeset=new HashSet<>();//创建hash表
        if (head==null||head.next==null) return null;//判断是不是空表或者只有一个元素
        while (true){
            nodeset.add(head);//死循环将节点加入hash表
            head=head.next;
            if (head==null||nodeset.contains(head))//如果有节点为空（非环形）或者哈希表中有
                break;//相同值（环形链表的第一个值），跳出循环
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(3);
        listNode.next.next=new ListNode(5);
        listNode.next.next.next=listNode;
        ListNode listNode1 = detectCycle(listNode);
        System.out.println(listNode1);
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