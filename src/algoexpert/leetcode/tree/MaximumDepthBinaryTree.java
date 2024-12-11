package algoexpert.leetcode.tree;


//104. Maximum Depth of Binary Tree
public class MaximumDepthBinaryTree {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
