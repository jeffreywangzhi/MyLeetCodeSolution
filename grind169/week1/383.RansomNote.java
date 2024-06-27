class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for ( char ch : magazine.toCharArray() ) {
            if ( map.containsKey(ch) ) map.put(ch, map.get(ch)+1);
            else map.put(ch, 1);
        }
        for ( char ch : ransomNote.toCharArray() ) {
            if ( !map.containsKey(ch) || map.get(ch) == 0 ) return false;
            else map.put(ch, map.get(ch)-1);
        }
        return true;
    }
}