class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int jobCnt = startTime.length;
        Job[] jobs = new Job[jobCnt];
        for ( int i = 0; i < jobCnt; i++ ) jobs[i] = new Job(endTime[i],startTime[i],profit[i]);
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.endTime));
        int dp[] = new int[jobCnt+1];
        for ( int i = 0; i < jobCnt; i++ ) {
            int start = jobs[i].startTime;
            int end = jobs[i].endTime;
            int pro = jobs[i].profit;
            int upperBound = bs(start,i,jobs);
            dp[i + 1] = Math.max(dp[i], dp[upperBound] + pro);
        }
        return dp[jobCnt];
    }
    private int bs(int target, int idx, Job[] jobs) {
        int start = 0;
        int end = idx;
        while ( start < end ) {
            int mid = start + (end-start)/2;
            if ( jobs[mid].endTime <= target ) start = mid+1;
            else end = mid;
        }
        return start;
    }
    private class Job {
        int startTime;
        int endTime;
        int profit;
        private Job(int endTime, int startTime, int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}