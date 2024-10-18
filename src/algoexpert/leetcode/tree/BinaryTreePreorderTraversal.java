package algoexpert.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    //144.binary tree preorder traversal
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,null,null),
                        new TreeNode(5,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null))),
                new TreeNode(3,
                        null,
                        new TreeNode(8,
                                new TreeNode(9, null, null),
                                null)));

        System.out.println(preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    private static void traversal(TreeNode root, List<Integer> list){
        if (root == null) return;
        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }
}



