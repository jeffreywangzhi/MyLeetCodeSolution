class Solution {
    public int smallestRepunitDivByK(int k) {
        HashSet<Integer> set = new HashSet<>();
        int rem = 1 % k;
        int cnt = 1;
        while (!set.contains(rem)) {
            if (rem == 0) return cnt;
            set.add(rem);
            rem = (rem * 10 + 1) % k;
            cnt++;
        }
        return -1;
    }
}
