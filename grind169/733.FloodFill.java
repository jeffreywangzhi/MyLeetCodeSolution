class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] rec = new int[image.length][image[0].length];
        dfs(image, sr, sc, image[sr][sc], color, rec);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int target, int color, int[][] rec) {
        if ( sr > image.length-1 || sr < 0 || sc > image[0].length-1 || sc < 0 ) return;
        if ( image[sr][sc] != target || rec[sr][sc] == -1 ) return;
        rec[sr][sc] = -1;
        if ( image[sr][sc] == target ) {
            image[sr][sc] = color;
            dfs(image, sr+1, sc, target, color, rec);
            dfs(image, sr, sc+1, target, color, rec);
            dfs(image, sr-1, sc, target, color, rec);
            dfs(image, sr, sc-1, target, color, rec);
        }
    }
}