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
    public int goodNodes(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE);
    }
    private int dfs(TreeNode root, int max) {
        if ( root == null ) return 0;
        int count = root.val >= max ? 1 : 0;
        max = Math.max(max,root.val);
        count += dfs(root.left,max);
        count += dfs(root.right,max);
        return count;
    }
}