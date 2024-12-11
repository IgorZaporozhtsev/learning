package algoexpert.leetcode.tree;

class TreeNode {
    protected int val;
    protected TreeNode left;
    protected TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    static TreeNode valueOf(int value) {
        return new TreeNode(value);
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
