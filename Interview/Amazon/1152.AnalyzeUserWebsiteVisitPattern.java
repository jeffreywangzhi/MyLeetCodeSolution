class Solution {
    private class Visit {
        String web;
        int time;
        private Visit (String web, int time) {
            this.web = web;
            this.time = time;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String,List<Visit>> map = new HashMap<>();
        for ( int i = 0; i < username.length; i++ ) {
            if ( !map.containsKey(username[i]) ) map.put(username[i],new ArrayList<>());
            map.get(username[i]).add(new Visit(website[i],timestamp[i]));
        }
        HashMap<List<String>,Integer> pattern = new HashMap<>();
        for ( Map.Entry<String,List<Visit>> entry : map.entrySet() ) {
            entry.getValue().sort(Comparator.comparingInt(a->a.time));
            HashSet<List<String>> set = new HashSet<>();
            for ( int i = 0; i < entry.getValue().size()-2; i++ ) {
                for ( int j = i+1; j < entry.getValue().size()-1; j++ ) {
                    for ( int k = j+1; k < entry.getValue().size(); k++ ) {
                        List<String> cur = Arrays.asList(entry.getValue().get(i).web,entry.getValue().get(j).web,entry.getValue().get(k).web);
                        set.add(cur);
                    }
                }
            }
            for ( List<String> p : set ) pattern.put(p,pattern.getOrDefault(p,0)+1);
        }
        List<Map.Entry<List<String>,Integer>> entryList = new ArrayList<>(pattern.entrySet());
        entryList.sort((e1,e2) -> {
            int fre = Integer.compare(e2.getValue(),e1.getValue());
            if ( fre == 0 ) return comparePatterns(e1.getKey(),e2.getKey());
            return fre;
        });
        return entryList.get(0).getKey();
    }
    // Helper function to compare patterns lexicographically
    private int comparePatterns(List<String> pattern1, List<String> pattern2) {
        for (int i = 0; i < 3; i++) {
            int compare = pattern1.get(i).compareTo(pattern2.get(i));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }
}