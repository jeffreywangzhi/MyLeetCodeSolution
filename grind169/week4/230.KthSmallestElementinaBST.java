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
class Solution {
    int k = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return helper(root);
    }
    private int helper(TreeNode root) {
        if ( root == null ) return -1;
        int val = helper(root.left);
        if ( k == 0 ) return val;
        if ( --k == 0 ) return root.val;
        return helper(root.right);
    }
}