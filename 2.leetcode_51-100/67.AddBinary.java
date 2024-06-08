class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        int carry = 0;
        while ( i >= 0 || j >= 0 ) {
            int m = i >= 0 ? a.charAt(i--) - '0' : 0;
            int n = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = m + n + carry;
            res.append( sum % 2 );
            carry = sum / 2;
        }
        return carry == 0 ? res.reverse().toString() : res.append(carry).reverse().toString();
    }
}