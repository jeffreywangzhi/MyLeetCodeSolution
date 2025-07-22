/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        dfs(root,res);
        return res.toString().substring(1);
    }
    private void dfs(TreeNode root, StringBuilder res) {
        if ( root == null ) {
            res.append(",N");
            return;
        }
        res.append(","+root.val);
        dfs(root.left,res);
        dfs(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tree = data.split(",");
        int[] idx = new int[1];
        return helper(tree,idx);
    }
    private TreeNode helper(String[] tree, int[] idx) {
        if ( tree[idx[0]].equals("N") ) return null;
        TreeNode root = new TreeNode(Integer.valueOf(tree[idx[0]]));
        idx[0]++;
        root.left = helper(tree,idx);
        idx[0]++;
        root.right = helper(tree,idx);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));