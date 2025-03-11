class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, int ori) {
        if ( sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length ) return;
        if ( image[sr][sc] == color ) return;
        if ( image[sr][sc] == ori ) image[sr][sc] = color;
        else return;
        dfs(image,sr+1,sc,color,ori);
        dfs(image,sr-1,sc,color,ori);
        dfs(image,sr,sc+1,color,ori);
        dfs(image,sr,sc-1,color,ori);
    }
}