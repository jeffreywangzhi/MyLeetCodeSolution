class Solution {
    public int leastInterval(char[] tasks, int n) {
        int cnt[] = new int[26];
        for ( char ch : tasks ) {
            cnt[ch-'A']++;
        }
        Arrays.sort(cnt);
        int i = 25, mx = cnt[25];
        while ( i >= 0 && cnt[i] == mx ) i--;
        return Math.max(tasks.length, (n+1)*(mx-1)+25-i);
    }
}