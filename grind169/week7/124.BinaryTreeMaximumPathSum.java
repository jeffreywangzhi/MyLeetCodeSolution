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
    public int maxPathSum(TreeNode root) {
        int res[] = new int[]{Integer.MIN_VALUE};
        helper(root,res);
        return res[0];
    }
    private int helper(TreeNode root, int[] res) {
        if ( root == null ) return 0;
        int right = Math.max(helper(root.right,res),0);
        int left = Math.max(helper(root.left,res),0);
        res[0] = Math.max(res[0],right+left+root.val);
        return Math.max(right,left) + root.val;
    }
}