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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,res,1);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> res, int level) {
        if ( root == null ) return;
        if ( level > res.size() ) res.add(root.val);
        dfs(root.right,res,level+1);
        dfs(root.left,res,level+1);
    }
}