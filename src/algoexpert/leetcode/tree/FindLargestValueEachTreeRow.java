package algoexpert.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//515. Find Largest Value in Each Tree Row
public class FindLargestValueEachTreeRow {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5,null,null),
                        new TreeNode(3, null, null)),
                new TreeNode(2,
                        null,
                        new TreeNode(9, null, null)));

        System.out.println(largestValues(root)); //1,3,9

    }


    static public List<Integer> largestValues(TreeNode root) {
        List<Integer> largest_vals = new ArrayList<>();
        depthFirstSearch(root, largest_vals, 0);
        return largest_vals;
    }

    static void depthFirstSearch(TreeNode root, List<Integer> largest_vals, int level){
        if (root == null) return;

        if (level == largest_vals.size()){
            largest_vals.add(root.val);
        } else {
            Integer levelValue = largest_vals.get(level);
            int max = Math.max(levelValue, root.val);
            largest_vals.set(level, max);
        }

        depthFirstSearch(root.left, largest_vals, level + 1);
        depthFirstSearch(root.right, largest_vals, level + 1);
    }
}
