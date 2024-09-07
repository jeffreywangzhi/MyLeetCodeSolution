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
    int cnt = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        dfs(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return cnt;
    }
    public void dfs(TreeNode root, int targetSum, long cur) {
        if ( root == null ) return;
        cur+=root.val;
        if ( cur == targetSum ) cnt++;
        dfs(root.left,targetSum,cur);
        dfs(root.right,targetSum,cur);
    }
}