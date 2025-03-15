class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0, right = 0, cnt = 0;
        int[] arr = new int[3];
        while ( right < s.length() ) {
            arr[s.charAt(right)-'a']++;
            while ( arr[0] > 0 && arr[1] > 0 && arr[2] > 0 ) {
                cnt += s.length()-right;
                arr[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return cnt;
    }
}