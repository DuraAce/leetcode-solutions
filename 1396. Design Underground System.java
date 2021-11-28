class UndergroundSystem {
    
    class Travel {
        public String start;
        public int time;
        public Travel(String start, int time) {
            this.start = start;
            this.time = time;
        }
    }
    
    Map<String, Map<String, List<Integer>>> travelTime;
    Map<Integer, Travel> traveling;

    public UndergroundSystem() {
        this.travelTime = new HashMap<>();
        this.traveling = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        traveling.put(id, new Travel(stationName, t));        
    }
    
    public void checkOut(int id, String stationName, int t) {
        String startStation = traveling.get(id).start;
        int startTime = traveling.get(id).time;
        traveling.remove(id);
        travelTime.putIfAbsent(startStation, new HashMap<>());
        travelTime.get(startStation).putIfAbsent(stationName, new ArrayList<>());
        travelTime.get(startStation).get(stationName).add(t - startTime);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        List<Integer> allTravelTime = travelTime.get(startStation).get(endStation);
        int sum = 0, cnt = 0;
        for (int time : allTravelTime) {
            sum += time;
            cnt++;
        }
        return (double) sum / cnt;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
