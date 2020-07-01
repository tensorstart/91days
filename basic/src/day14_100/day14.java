package day14_100;

/**
 * ClassName:day14
 * Package:day14_100
 * Discription:
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * @Data:2020/6/14 13:51
 */
public class day14 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (q == null && p != null))
            return false;
        if (p.val!=q.val)
            return false;
        if ((p.left == null && q.left != null) || (p.right == null && q.right != null)
                || (q.left == null && p.left != null) || (q.right == null && p.right != null))
            return false;
        return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
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
