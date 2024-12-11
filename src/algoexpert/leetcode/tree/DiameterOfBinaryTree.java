package algoexpert.leetcode.tree;

public class DiameterOfBinaryTree {

    static int diameter = 0; /// pay attention

    public static void main(String[] args) {
                TreeNode root = new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                new TreeNode(5, null, null)),
                        new TreeNode(3, null, null));

        System.out.println(diameterOfBinaryTree(root));

    }

    static public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0; // Reset diameter before calculation
        calculateHeight(root);
        return diameter;
    }

    static private int calculateHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Update the diameter if the current path is the longest found
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height of the subtree rooted at the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}


