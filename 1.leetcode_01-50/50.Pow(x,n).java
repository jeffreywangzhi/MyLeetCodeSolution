class Solution {
    public double myPow(double x, int n) {
        double ans=1;
        long n_temp = n;
        if(n_temp<0){
            n_temp *= -1;
        }
        while(n_temp>0){
            if(n_temp%2==0){
                x = x*x;
                n_temp = n_temp/2;
            }else{
                ans = ans * x;
                n_temp--;
            }
        }
        if(n<0){
            return (double) 1/ans;
        }
        return ans;
    }
}