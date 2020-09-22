package JavaCore.collection.tree;

public class TreeMirror {
    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3,
                                        new TreeNode(5),
                                        new TreeNode(6)
                                ),
                                new TreeNode(4,
                                        new TreeNode(1),
                                        new TreeNode(3)
                                )
                        ),
                        new TreeNode(2,
                                new TreeNode(4,
                                        new TreeNode(3),
                                        new TreeNode(1)
                                ),
                                new TreeNode(3,
                                        new TreeNode(6),
                                        new TreeNode(5)
                                )
                        )
                );

        System.out.println(root.isSymmetric(root));
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public boolean isSymmetric(TreeNode root){
           if (root == null) {
               return true;
           }
           return isSymmetricInternal(root.left, root.right);
        }

        public boolean isSymmetricInternal(TreeNode tn1, TreeNode tn2){

            if (tn1 == null && tn2 == null) return true;
            if (tn1 == null || tn2 == null) return false;

            return (tn1.val == tn2.val)
                    && isSymmetricInternal(tn1.left, tn2.right)
                    && isSymmetricInternal(tn1.right, tn2.left);
        }
    }
}
