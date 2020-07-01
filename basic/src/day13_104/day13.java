package day13_104;

/**
 * ClassName:day13
 * Package:day13_104
 * Discription:二叉树的最大深度
 *
 * @Data:2020/6/14 11:44
 */
public class day13 {
    public int maxDepth(TreeNode root) {
        int depth=1;
        if (root==null) return 0;
        else if (root.left==null&&root.right==null) return 1;
        else {
            depth=depth+Math.max(maxDepth(root.left),maxDepth(root.right));
        }
        return depth;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
