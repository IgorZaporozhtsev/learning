package algoexpert.leetcode.tree;

//235. Lowest Common Ancestor of a Binary Search Tree
public class LowestCommonAncestorBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0,null,null),
                        new TreeNode(4,
                                new TreeNode(3, null, null),
                                new TreeNode(5, null, null))),
                new TreeNode(8,
                        new TreeNode(7, null, null),
                        new TreeNode(9, null, null)));

        System.out.println(lowestCommonAncestor(root, TreeNode.valueOf(3), TreeNode.valueOf(7)));

    }

    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
