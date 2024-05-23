class Solution {
    public String countAndSay(int n) {
        StringBuilder str = new StringBuilder("1");
        for ( int k = 1; k < n; k++ ) {
            StringBuilder update = new StringBuilder();
            for ( int i = 0; i < str.toString().length(); i++ ) {
                int count = 1;
                while ( i+1 < str.toString().length() && str.toString().charAt(i) == str.toString().charAt(i+1)) {
                    count++;
                    i++;
                }
                update.append(Integer.toString(count)).append(str.toString().charAt(i));
            }
            str = update;
        }
        return str.toString();
    }
}