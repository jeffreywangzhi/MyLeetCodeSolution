class Solution {
    private class Node {
        HashMap<Character,Node> child;
        boolean isWord;
        private Node(boolean isWord) {
            this.child = new HashMap<>();
            this.isWord = isWord;
        }
    }
    private Node root;
    private void buildTree(String[] words) {
        root = new Node(false);
        for ( String w : words ) {
            Node cur = root;
            for ( char c : w.toCharArray() ) {
                cur.child.computeIfAbsent(c,k->new Node(false));
                cur = cur.child.get(c);
            }
            cur.isWord = true;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        buildTree(words);
        List<String> res = new ArrayList<>();
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                if ( root.child.containsKey(board[i][j]) ) dfs(board,new StringBuilder(),i,j,res,root);
                else continue;
            }
        }
        return res;
    }
    private void dfs(char[][] board, StringBuilder str, int i, int j, List<String> res, Node cur) {
        if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length ) return;
        if ( board[i][j] == '#' || !cur.child.containsKey(board[i][j]) ) return;
        cur = cur.child.get(board[i][j]);
        str.append(board[i][j]);
        if ( cur.isWord ) {res.add(str.toString());cur.isWord=false;}
        char tmp = board[i][j];
        board[i][j] = '#';
        dfs(board,str,i+1,j,res,cur);
        dfs(board,str,i-1,j,res,cur);
        dfs(board,str,i,j+1,res,cur);
        dfs(board,str,i,j-1,res,cur);
        board[i][j] = tmp;
        str.deleteCharAt(str.length()-1);
    }
}