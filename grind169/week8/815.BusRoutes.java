class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        
        // Map each stop to the list of buses that visit it
        HashMap<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                if (!stopToBuses.containsKey(stop)) {
                    stopToBuses.put(stop, new ArrayList<>());
                }
                stopToBuses.get(stop).add(i);
            }
        }
        
        // If target stop isn't serviced by any bus, return -1
        if (!stopToBuses.containsKey(target)) return -1;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        
        // Track visited buses and stops
        HashSet<Integer> visitedBuses = new HashSet<>();
        HashSet<Integer> visitedStops = new HashSet<>();
        visitedStops.add(source);
        
        int busCount = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size(); // Process all stops at current level
            busCount++;
            
            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();
                
                // Get all buses that visit this stop
                List<Integer> buses = stopToBuses.get(currentStop);
                if (buses == null) continue;
                
                // For each bus, visit all its stops
                for (int bus : buses) {
                    if (visitedBuses.contains(bus)) continue;
                    visitedBuses.add(bus);
                    
                    // Add all stops of this bus to queue
                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) return busCount;
                        if (visitedStops.contains(nextStop)) continue;
                        
                        visitedStops.add(nextStop);
                        queue.offer(nextStop);
                    }
                }
            }
        }
        
        return -1;
    }
}