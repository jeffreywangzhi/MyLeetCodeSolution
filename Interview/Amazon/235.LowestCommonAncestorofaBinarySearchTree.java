/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode max = p.val > q.val ? p : q;
        TreeNode min = p.val > q.val ? q : p;
        if ( min.val <= root.val && root.val <= max.val ) return root;
        else return root.val > max.val ? lowestCommonAncestor(root.left,p,q) : lowestCommonAncestor(root.right,p,q);
    }
}