package algoexpert.leetcode.tree;


//236. Lowest Common Ancestor of a Binary Tree
public class LowestCommonAncestorBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6,null,null),
                        new TreeNode(2,
                                new TreeNode(7, null, null),
                                new TreeNode(4, null, null))),
                new TreeNode(1,
                        new TreeNode(0, null, null),
                        new TreeNode(8, null, null)));


        //System.out.println(lowestCommonAncestor(root, TreeNode.valueOf(7), TreeNode.valueOf(4)));
        System.out.println(lowestCommonAncestor(root, TreeNode.valueOf(5), TreeNode.valueOf(4)));

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode != null && rightNode != null) { //q=5 , p=8 --> 3
            return root;
        }

        if (leftNode == null) { //if we get val from right but from left = null
            return rightNode;
        } else {//if we get val from left but from right = null q=5 , p=4 --> 5
            return leftNode;
        }
    }
}
