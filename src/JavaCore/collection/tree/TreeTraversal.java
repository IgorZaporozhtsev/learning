package JavaCore.collection.tree;

import JavaCore.collection.stack.SimpleStack;

public class TreeTraversal {
    public static void main(String[] args) {
        Tree root =
                new Tree(20,
                        new Tree(7,
                                new Tree(4, null,
                                        new Tree(6)),
                                new Tree(9)),

                        new Tree(35,
                                new Tree(31,
                                        new Tree(28), null),
                                new Tree(40,
                                        new Tree(38),
                                        new Tree(52))));

        //System.out.println(root.sum());
        System.out.println(sumDeep(root));
    }

    //recursion
    static class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }

        public int sum() {
            int sum = value;

            if (left != null){
                sum += left.sum(); //рекурсивно вызываем сумму на каждом ребре
            }

            if (right != null) {
                sum += right.sum();
            }

            return sum;
        }
    }

    //iterate
    public static int sumDeep(Tree root) {
        SimpleStack<Tree> stack = new SimpleStack<>();
        stack.push(root);

        int sum = 0;

        while (!stack.isEmpty()) {
            Tree node = stack.pop();

            System.out.println(node.value);

            sum = sum + node.value;

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return sum;


    }

}
