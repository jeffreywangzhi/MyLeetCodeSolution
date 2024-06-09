class Solution {
    public String simplifyPath(String path) {
        List<String> res = new ArrayList<>();
        String[] strs = path.split("/");
        for ( String s : strs ) {
            if ( !res.isEmpty() && s.equals("..") ) {res.remove(res.size()-1);}
            else if ( !s.equals("") && !s.equals(".") && !s.equals("..") ) {res.add(s);}
        }
        return "/" + String.join("/", res);
    }
}