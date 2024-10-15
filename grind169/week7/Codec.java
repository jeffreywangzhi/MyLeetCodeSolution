/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    List<String> list;

    public String serialize(TreeNode root) {
        list = new ArrayList<>();
        helper(root);
        StringBuilder str = new StringBuilder("[");
        for (String s : list)
            str.append(s).append(",");
        str.setCharAt(str.length() - 1, ']');
        return str.toString();
    }

    public void helper(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                list.add("null");
                continue;
            } else
                list.add(String.valueOf(cur.val));
            queue.add(cur.left);
            queue.add(cur.right);
        }
        int i = list.size() - 1;
        while (i >= 0 && list.get(i) == "null") {
            list.remove(i);
            i--;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 2)
            return null;
        String[] values = data.substring(1, data.length() - 1).split(",");
        List<Integer> result = new ArrayList<>();
        for (String value : values) {
            if (value.trim().equals("null")) {
                result.add(null);
            } else {
                result.add(Integer.parseInt(value.trim()));
            }
        }
        if (result == null || result.isEmpty() || result.get(0) == null)
            return null;
        TreeNode root = new TreeNode(result.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < result.size()) {
            TreeNode current = queue.poll();
            if (result.get(i) != null) {
                current.left = new TreeNode(result.get(i));
                queue.add(current.left);
            }
            i++;
            if (i < result.size() && result.get(i) != null) {
                current.right = new TreeNode(result.get(i));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));