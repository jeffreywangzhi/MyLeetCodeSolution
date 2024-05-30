class Solution {
    public String multiply(String num1, String num2) {
        if ( num1.charAt(0) == '0' || num2.charAt(0) == '0' ) return "0";
        int res[] = new int[num1.length()+num2.length()];
        for ( int i = num1.length() - 1; i >= 0; i-- ) {
            for ( int j = num2.length() - 1; j >= 0; j-- ) {
                int p1 = i + j, p2 = i + j + 1;
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + res[p2];
                res[p1] += sum / 10;
                res[p2] = sum % 10;
            }
        }
        StringBuilder str = new StringBuilder();
        for ( int k = 0; k < res.length; k++ ) {
            if ( !(str.isEmpty() && res[k] == 0) ) str.append((char) (res[k] + '0'));
        }
        return str.toString();
    }
}