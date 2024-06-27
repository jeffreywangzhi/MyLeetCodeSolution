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
    public boolean isBalanced(TreeNode root) {
        if ( checkDepth(root) == -1 ) return false;
        else return true;
    }
    private int checkDepth(TreeNode root) {
        if ( root == null ) return 0;
        int left = checkDepth(root.left);
        if ( left == -1 ) return -1;
        int right = checkDepth(root.right);
        if ( right == -1 ) return -1;
        int diff = Math.abs(left-right);
        if ( diff > 1 ) return -1;
        else return 1 + Math.max(left,right);
    }
}