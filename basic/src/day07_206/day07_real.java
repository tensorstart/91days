package day07_206;

/**
 * ClassName:day07_real
 * Package:day07_206
 * Discription:反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @Data:2020/6/7 14:42
 */
public class day07_real {
    public ListNode reverseList(ListNode head) {
        if (head==null) return head;
        ListNode temp=null;//中间变量
        ListNode new_head=null;//新的头节点
        while (head.next!=null){
            temp=head;
            head=head.next;
            temp.next=new_head;
            new_head=temp;
        }
        return new_head;
    }

}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
