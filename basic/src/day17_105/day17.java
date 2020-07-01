package day17_105;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:day17
 * Package:day17_105
 * Discription:
 *
 * @Data:2020/6/17 17:19
 */
public class day17 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return findroot(preorder,inorder,0,preorder.length-1,0,inorder.length-1,map);
    }


    public TreeNode findroot(int[] preorder, int[] inorder, int preorderleft, int preorderright,int inorderleft,
                         int inorderright,Map<Integer,Integer> map) {
        if (preorderleft>preorderright) return null;
        int rootval=preorder[preorderleft];
        TreeNode root=new TreeNode(rootval);
        int inorder_root_index=map.get(rootval);
        int common_length=inorder_root_index-inorderleft;

        root.left=findroot(preorder,inorder,preorderleft+1,preorderleft+common_length,inorderleft,
                inorder_root_index-1,map);

        root.right=findroot(preorder,inorder,preorderleft+common_length+1,preorderright,
                inorder_root_index+1,inorderright,map);
        return root;
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
