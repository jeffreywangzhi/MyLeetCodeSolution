/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        maxDepth(root, res);
        return res[0];
    }

    private int maxDepth(TreeNode node, int[] res) {
        if (node == null) return 0;
        int left = maxDepth(node.left, res);
        int right = maxDepth(node.right, res);
        res[0] = Math.max(res[0], left + right);
        return Math.max(left, right) + 1;
    }
}