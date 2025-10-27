class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) minLen = Math.min(minLen, s.length());
        int low = 0, high = minLen;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (isCommonPrefix(strs, mid)) low = mid;
            else high = mid - 1;
        }
        return strs[0].substring(0, low);
    }
    private boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(prefix)) return false;
        return true;
    }
}
