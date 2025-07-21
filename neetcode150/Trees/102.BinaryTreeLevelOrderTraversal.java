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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root,res,0);
        return res;
    }
    private void traverse(TreeNode root, List<List<Integer>> res, int h) {
        if ( root == null ) return;
        if ( h == res.size() ) res.add(new ArrayList<>());
        res.get(h).add(root.val);
        traverse(root.left,res,h+1);
        traverse(root.right,res,h+1);
    }
}