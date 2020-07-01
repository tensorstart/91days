package day16_513;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:day16
 * Package:day16_513
 * Discription:
 *给定一个二叉树，在树的最后一行找到最左边的值。
 * @Data:2020/6/16 21:06
 */
public class day16 {
    public static int findBottomLeftValue(TreeNode root) {
        if (root==null) throw new RuntimeException("空树");
        int res=0;
        ArrayList<TreeNode> line =new ArrayList<>();
        ArrayList<ArrayList<TreeNode>> allline=new ArrayList<>();
        line.add(root);
        while (line.size()!=0){
//            ArrayList<TreeNode> curline=new ArrayList<>();
            ArrayList<TreeNode> curline = (ArrayList<TreeNode>) line.clone();//深拷贝列表
            line.clear();
            for (TreeNode treeNode : curline) {
                if (treeNode==null) continue;
                if (treeNode.left!=null) line.add(treeNode.left);
                if (treeNode.right!=null) line.add(treeNode.right);
            }
            allline.add(curline);
        }
        if (allline.size()!=0) {
            ArrayList<TreeNode> treeNodes = allline.get(allline.size() - 1);
            res=treeNodes.get(0).val;
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.right =new TreeNode(2);
        root.right.left=new TreeNode(3);
        int integers = findBottomLeftValue(root);
        System.out.println(integers);
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
