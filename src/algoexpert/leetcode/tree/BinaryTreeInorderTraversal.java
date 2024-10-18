package algoexpert.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                null, new TreeNode(2, new TreeNode(3, null, null), null));
        inorderTraversal(root);

    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }

    private static void traverse(TreeNode root, List<Integer> list){
        if (root == null) return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);

    }
}



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {

      }
      TreeNode(int val) {
          this.val = val;
      }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}