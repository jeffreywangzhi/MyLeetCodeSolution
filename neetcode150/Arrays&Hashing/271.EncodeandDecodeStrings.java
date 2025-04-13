public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for ( String str : strs ) res.append(str.length()).append('#').append(str);
        return res.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int cur = 0;
        List<String> res = new ArrayList<>();
        for ( int i = 0; i < s.length(); i++ ) {
            char c = s.charAt(i);
            if ( Character.isDigit(c) ) cur = cur*10+(c-'0');
            else {
                res.add(s.substring(i+1,i+1+cur));
                i+=cur;
                cur = 0;
            }
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));