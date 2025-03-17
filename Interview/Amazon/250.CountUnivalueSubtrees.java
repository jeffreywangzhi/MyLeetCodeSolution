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
    private int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return res;
    }
    private boolean helper(TreeNode root) {
        if ( root == null ) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if ( left && right ) {
            if ( root.left != null && root.val != root.left.val ) return false;
            if ( root.right != null && root.val != root.right.val ) return false;
            res++;
            return true;
        }
        return false;
    }
}