package algoexpert.leetcode.tree;


//226. Invert Binary Tree
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1,null,null),
                        new TreeNode(3, null, null)),
                new TreeNode(7,
                        new TreeNode(6, null, null),
                        new TreeNode(9, null, null)));

//        TreeNode root = new TreeNode(4,
//                new TreeNode(2,null, null),
//                new TreeNode(7,null, null));

        TreeNode treeNode = invertTree(root);
        System.out.println(treeNode);
    }



    static public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


}
