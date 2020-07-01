package day15_129;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:day15
 * Package:day15_129
 * Discription:
 *给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Data:2020/6/15 10:33
 */
public class day15 {
    static List<Integer> list=new ArrayList<>();//存储根到叶子的值

//    public static void main(String[] args) {
//        TreeNode tree = new TreeNode(1);
//        tree.left=new TreeNode(2);
//        tree.right=new TreeNode(3);
//        tree.left.left=new TreeNode(6);
//        tree.left.right=new TreeNode(8);
//        int i = sumNumbers(tree);
//        System.out.println(i);
//    }
    public static int sumNumbers(TreeNode root) {
        if (root==null) return 0;//空树返回0
        int num=root.val;//记录根到当前节点的值
        int res=0;//结果
        leafnum(num, root);
        for (Integer integer : list) {
            res+=integer;
        }
        return res;
    }
    public static void leafnum(int num,TreeNode node){
        if (node.left==null&&node.right==null){//递归出口，当前节点是叶子
            list.add(num);//把值加入列表
            num/=10;//回溯
            return;
        }
        if (node.left!=null){//左子节点不为空，当前的值*10+左子节点的值，并且递归遍历左子节点
            leafnum(num*10+node.left.val,node.left);
        }
        if (node.right!=null)//右子节点不为空，当前的值*10+右子节点的值，并且递归遍历右子节点
            leafnum(num*10+node.right.val,node.right);

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
