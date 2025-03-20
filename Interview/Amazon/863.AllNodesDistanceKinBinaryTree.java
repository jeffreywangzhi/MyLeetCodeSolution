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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        dis(root,target,k,res);
        return res;
    }
    private int dis(TreeNode root, TreeNode target, int k, List<Integer> res) {
        if ( root == null ) return -1;
        if ( root == target ) {
            collect(root,k,res);
            return 0;
        }
        int l = dis(root.left,target,k,res);
        int r = dis(root.right,target,k,res);
        if ( l >= 0 ) {
            if ( l == k-1 ) res.add(root.val);
            else collect(root.right,k-l-2,res);
            return l+1;
        }
        if ( r >= 0 ) {
            if ( r == k-1 ) res.add(root.val);
            else collect(root.left,k-r-2,res);
            return r+1;
        }
        return -1;
    }
    private void collect(TreeNode root, int k, List<Integer> res) {
        if ( root == null ) return;
        if ( k == 0 ) res.add(root.val);
        else {
            collect(root.left,k-1,res);
            collect(root.right,k-1,res);
        }
    }
}