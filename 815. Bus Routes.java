/*
TLE
*/
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int result = -1;
        // init 
        
        Map<Integer, Set<Integer>> route2stop = new HashMap<>();
        Map<Integer, Set<Integer>> stop2route = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {     
            Set<Integer> rSet = new HashSet<>();
            for (int j = 0; j < routes[i].length; j++) {
                rSet.add(routes[i][j]);
                stop2route.putIfAbsent(routes[i][j], new HashSet<>());
                stop2route.get(routes[i][j]).add(i);
            }
            route2stop.put(i, rSet);
        }
        
        Set<Integer> visitedRoute = new HashSet<>();
        Set<Integer> visitedStop = new HashSet<>();
        Queue<Integer> qRoute = new ArrayDeque<>();
        Queue<Integer> qStop = new ArrayDeque<>();
        
        if (!stop2route.containsKey(source))
            return -1;
        if (source == target)
            return 0;
        
        qStop.offer(source);
        visitedStop.add(source);
        int cntRoutes = 0;
        while (!qStop.isEmpty()) {
            int qStopLen = qStop.size();
            for (int i = 0; i < qStopLen; i++) {
                int currStop = qStop.poll();
                if (!stop2route.containsKey(currStop))
                    continue;
                Set<Integer> currRoutes = stop2route.get(currStop);
                for (int currRoute : currRoutes) {
                    if (!visitedRoute.contains(currRoute))
                        qRoute.offer(currRoute);
                }
            }
            cntRoutes++;
            int qRouteLen = qRoute.size();
            for (int i = 0; i < qRouteLen; i++) {
                int currRoute = qRoute.poll();
                visitedRoute.add(currRoute);
                Set<Integer> currStops = route2stop.get(currRoute);
                if (currStops.size() == 0)
                    continue;
                for (int currStop : currStops) {
                    if (currStop == target)
                        return cntRoutes;
                    if (!visitedStop.contains(currStop)) {
                        visitedStop.add(currStop);
                        qStop.offer(currStop);
                    }
                }
            }
        }
        
        return result;
    }
}

/*
optimized
*/
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
       HashSet<Integer> visited = new HashSet<>();
       Queue<Integer> q = new LinkedList<>();
       HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
       int ret = 0; 
        
       if (S==T) return 0; 
        
       for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);                
            }       
        }
                
       q.offer(S); 
       while (!q.isEmpty()) {
           int len = q.size();
           ret++;
           for (int i = 0; i < len; i++) {
               int cur = q.poll();
               ArrayList<Integer> buses = map.get(cur);
               for (int bus: buses) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) return ret;
                        q.offer(routes[bus][j]);  
                   }
               }
           }
        }
        return -1;
    }
}
