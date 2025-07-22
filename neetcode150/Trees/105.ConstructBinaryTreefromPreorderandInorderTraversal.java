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
        if ( preorder.length <= 0 ) return null;
        int rootVal = preorder[0], mid = 0;
        for ( int i = 0; i < inorder.length; i++ ) {
            if ( inorder[i] == rootVal ) {
                mid = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int[] leftPre = Arrays.copyOfRange(preorder,1,mid+1);
        int[] leftIn = Arrays.copyOfRange(inorder,0,mid);
        int[] rightPre = Arrays.copyOfRange(preorder,mid+1,preorder.length);
        int[] rightIn = Arrays.copyOfRange(inorder,mid+1,inorder.length);
        root.left = buildTree(leftPre,leftIn);
        root.right = buildTree(rightPre,rightIn);
        return root;
    }
}