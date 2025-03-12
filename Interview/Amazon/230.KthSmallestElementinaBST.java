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
    private int k = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }
    private int dfs(TreeNode root) {
        if ( root == null ) return -1;
        int val = dfs(root.left);
        if ( val != -1 ) return val;
        if ( --k == 0 ) return root.val;
        else return dfs(root.right);
    }

}