class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int carry = 0;
        for ( int i = a.length()-1, j = b.length()-1; i >= 0 || j >= 0; i--, j-- ) {
            int inta = i >= 0 ? a.charAt(i)-'0' : 0;
            int intb = j >= 0 ? b.charAt(j)-'0' : 0;
            str.append((inta+intb+carry)%2);
            carry = (inta+intb+carry)/2;
        }
        if ( carry != 0 ) str.append(carry);
        return str.reverse().toString();
    }
}