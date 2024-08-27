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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,targetSum,new ArrayList<>(),0,res);
        return res;
    }
    public void dfs(TreeNode root, int target, List<Integer> cur, int curSum, List<List<Integer>> res) {
        if ( root == null ) return;
        cur.add(root.val);
        if ( curSum + root.val == target && root.left == null && root.right == null ) res.add(new ArrayList<>(cur));
        dfs(root.left,target,new ArrayList<>(cur),curSum+root.val,res);
        dfs(root.right,target,new ArrayList<>(cur),curSum+root.val,res);
    }
}