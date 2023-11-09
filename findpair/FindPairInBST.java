package com.findpair;
import java.util.HashSet;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class FindPairInBST {

    public static boolean findPair(TreeNode root, int target) {
        HashSet<Integer> set = new HashSet<>();
        return findPairUtil(root, target, set);
    }

    public static boolean findPairUtil(TreeNode root, int target, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }

        int complement = target - root.val;
        if (set.contains(complement)) {
            return true;
        }

        set.add(root.val);

        return findPairUtil(root.left, target, set) || findPairUtil(root.right, target, set);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        int target = 10;

        if (findPair(root, target)) {
            System.out.println("Pair with sum " + target + " found in the BST.");
        } else {
            System.out.println("Pair with sum " + target + " not found in the BST.");
        }
    }
}
