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
    // BFS Solution
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if ( root == null ) return res;
        queue.offer(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            for ( int i = 0; i < size; i++ ) {
                TreeNode cur = queue.poll();
                if ( level == res.size() ) res.add(new ArrayList<>());
                res.get(level).add(cur.val);
                if ( cur.left != null ) queue.offer(cur.left);
                if ( cur.right != null ) queue.offer(cur.right);
            }
            level++;
        }
        return res;
    }
}