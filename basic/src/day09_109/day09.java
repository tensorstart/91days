package day09_109;

/**
 * ClassName:day09
 * Package:day09_109
 * Discription:
 *
 * @Data:2020/6/9 21:02
 */
public class day09 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null)return null;
        if (head.next==null)return new TreeNode(head.val);//如果链表只有一个值，返回这个节点的树
        ListNode fast=head;//快节点
        ListNode slow=head;//慢节点
        ListNode temp=head;//中间节点的前一个，用来断开
        while (fast!=null&&fast.next!=null){//快慢指针找中点
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode treehead = new TreeNode(slow.val);//树的根节点
        while (temp.next!=slow)
            temp=temp.next;//找到中点的前一个节点，断开它
        temp.next=null;
        treehead.left=sortedListToBST(head);//向左递归
        treehead.right=sortedListToBST(slow.next);//向右递归
        return treehead;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
