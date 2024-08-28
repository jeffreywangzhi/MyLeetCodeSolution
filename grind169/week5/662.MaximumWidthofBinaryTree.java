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
    List<Integer> lefts = new ArrayList<>();
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root,1,0);
    }
    private int dfs(TreeNode root, int id, int depth) {
        if ( root == null ) return 0;
        if ( depth == lefts.size() ) lefts.add(id);
        int subtrees = Math.max(dfs(root.left,id*2,depth+1),dfs(root.right,id*2+1,depth+1));
        return Math.max(subtrees,id-lefts.get(depth)+1);
    }
}