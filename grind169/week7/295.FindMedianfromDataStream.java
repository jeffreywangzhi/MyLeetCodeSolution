class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    
    public MedianFinder() {
        small = new PriorityQueue<>((a,b)->b-a);
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());
        if ( small.size() < large.size() ) small.offer(large.poll());
    }
    
    public double findMedian() {
        return small.size() > large.size() ? small.peek() : (large.peek() + small.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */