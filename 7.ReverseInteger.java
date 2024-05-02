class Solution {
    public int reverse(int x) {
        boolean flag = false;
        int res = 0;
        if(x < 0){
            flag = true;
            x = 0 - x;
        }
        while(x != 0){
            long temp = (long)res * 10;
            if(temp != res*10) return 0;
            res = res*10 + x%10;
            x /= 10;
        }
        if(flag){
            res = 0 - res;
        }
        return res;
    }
}