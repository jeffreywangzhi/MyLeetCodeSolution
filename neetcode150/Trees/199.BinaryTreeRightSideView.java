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
        view(root,res,0);
        return res;
    }
    private void view(TreeNode root, List<Integer> res, int h) {
        if ( root == null ) return;
        if ( res.size() == h ) res.add(root.val);
        view(root.right,res,h+1);
        view(root.left,res,h+1);
    }
}