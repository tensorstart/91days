package da16_94;

import java.util.*;

/**
 * ClassName:三色法遍历二叉树
 * Package:day_16_94
 * Discription:
 *给定一个二叉树，返回它的中序 遍历。
 * @Data:2020/6/16 16:08
 */
public class three_color {
    public static List<Integer> inorderTraversal(TreeNode root) {
        final int white=0;
        final int gray=1;
        List<Integer> res=new ArrayList<>();
        Object[] tuple=new Object[2];
        Stack<Object[]> stack=new Stack<>();
        //Map<Integer,TreeNode> map=new HashMap<>();//存关系，可以用Object类的数组，但是取出的时候要强转
        tuple[0]=white;
        tuple[1]=root;
        stack.add(tuple);
        while(!stack.isEmpty()){  //    栈空跳出循环
            tuple=stack.pop();
            int color=(int)tuple[0];
            TreeNode node = (TreeNode)tuple[1];
            if (node==null) continue;
            if (color==white){
                stack.add(new Object[]{white, node.right});//因为使用stack做的，先进后出，所以先走右边

                stack.add(new Object[]{gray,node});

                stack.add(new Object[]{white,node.left});
            }
            if (color==gray)
                res.add(node.val);

        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.right =new TreeNode(2);
        root.right.left=new TreeNode(3);
        List<Integer> integers = inorderTraversal(root);
        System.out.println(integers);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}