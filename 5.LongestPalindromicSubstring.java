class Solution {
    public String longestPalindrome(String s) {
        String max = Character.toString(s.charAt(0));
        for(int i = 1 ; i < s.length() ; i ++){
            String res = getLongestPalindrome(s, i);
            if(res.length() > max.length()){
                max = res;
            }
        }
        return max;
    }

    public String getLongestPalindrome(String s, int i){
        boolean flag = false;
        String res1 = "";
        String res2 = "";
        int j = 0, k = 0;
        for(j = i - 1, k = i ; j >= 0 && k < s.length() ; j--, k++){
            if(s.charAt(j) != s.charAt(k)){
                res1 = s.substring(j+1,k);
                flag = true;
                break;
            }
        }
        if(!flag){
            res1 = s.substring(j+1,k);
        }
        flag = false;
        for(j = i - 1, k = i + 1 ; j >= 0 && k < s.length() ; j--, k++){
            if(s.charAt(j) != s.charAt(k)){
                res2 = s.substring(j+1,k);
                flag = true;
                break;
            }
        }
        if(!flag){
            res2 = s.substring(j+1,k);
        }
        if(res1.length() > res2.length()){
            return res1;
        }else return res2;
        
    }
}