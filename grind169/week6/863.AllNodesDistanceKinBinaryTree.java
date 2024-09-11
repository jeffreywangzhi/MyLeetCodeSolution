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
    List<Integer> res;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res = new ArrayList<>();
        dis(root,target,k);
        return res;
    }
    public int dis(TreeNode root, TreeNode target, int k) {
        if ( root == null ) return -1;
        if ( root == target ) {
            collect(root,k);
            return 0;
        }
        int l = dis(root.left,target,k);
        int r = dis(root.right,target,k);
        if ( l >= 0 ) {
            if ( l == k-1 ) res.add(root.val);
            collect(root.right,k-l-2);
            return l+1;
        }
        if ( r >= 0 ) {
            if ( r == k-1 ) res.add(root.val);
            collect(root.left,k-r-2);
            return r+1;
        }
        return -1;

    }
    public void collect(TreeNode root, int k) {
        if ( root == null || k < 0 ) return;
        if ( k == 0 ) res.add(root.val);
        else {
            collect(root.left,k-1);
            collect(root.right,k-1);
        }
    }
}