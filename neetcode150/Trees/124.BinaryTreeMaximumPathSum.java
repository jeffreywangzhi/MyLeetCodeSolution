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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        res = Math.max(dfs(root,max),res);
        return res;
    }
    private int dfs(TreeNode root, int max) {
        if ( root == null ) return 0;
        int left = Math.max(dfs(root.left,max),0);
        int right = Math.max(dfs(root.right,max),0);
        res = Math.max(res,left+root.val+right);
        return Math.max(left,right)+root.val;
    }
}