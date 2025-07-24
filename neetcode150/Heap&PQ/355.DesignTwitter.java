class Twitter {
    private HashMap<Integer,HashSet<Integer>> follow;
    private HashMap<Integer,ArrayList<Tweet>> post;
    private class Tweet {
        int time;
        int id;
        private Tweet(int time, int id) {
            this.time = time;
            this.id = id;
        }
    }
    private int time;
    public Twitter() {
        follow = new HashMap<>();
        post = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        post.computeIfAbsent(userId,k->new ArrayList<>());
        post.get(userId).add(new Tweet(++time,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        follow.computeIfAbsent(userId,k->new HashSet<>());
        follow.get(userId).add(userId);
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->Integer.compare(b.time,a.time));
        for ( int id : follow.get(userId) ) {
            if ( !post.containsKey(id) ) continue;
            for ( Tweet tw : post.get(id) ) pq.offer(tw);
        }
        List<Integer> res = new ArrayList<>();
        for ( int i = 0; i < 10; i++ ) {
            if ( pq.isEmpty() ) break;
            res.add(pq.poll().id);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follow.computeIfAbsent(followerId,k->new HashSet<>());
        follow.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if ( follow.containsKey(followerId) ) follow.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */