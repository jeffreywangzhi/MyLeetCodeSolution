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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        preporder(root,res,0);
        return res;
    }
    public void preporder(TreeNode root, List<List<Integer>> res, int level) {
        if ( root == null ) return;
        if ( level == res.size() ) res.add(new ArrayList<>(Arrays.asList(root.val)));
        else {
            if ( level % 2 == 0 ) res.get(level).add(root.val);
            else res.get(level).add(0,root.val);
        }
        preporder(root.left,res,level+1);
        preporder(root.right,res,level+1);
    }
}