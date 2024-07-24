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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright) {
        if ( pleft > pright || ileft > iright ) return null;
        TreeNode cur = new TreeNode(preorder[pleft]);
        int i = ileft;
        for ( ; i <= iright; i++ ) if ( inorder[i] == preorder[pleft] ) break;
        cur.left = helper(preorder, pleft+1, pleft + i - ileft, inorder, ileft, i-1);
        cur.right = helper(preorder, pleft + i - ileft + 1, pright, inorder, i+1, iright);
        return cur;
    }
}