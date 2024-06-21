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
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        inorder(root, list, res);
        Collections.sort(res);
        for ( int i = 0; i < res.size(); i++ ) {
            list.get(i).val = res.get(i);
        }
    }
    private void inorder(TreeNode root, List<TreeNode> list, List<Integer> res) {
        if ( root == null ) return;
        inorder(root.left, list, res);
        list.add(root);
        res.add(root.val);
        inorder(root.right, list, res);
    }
}