class TimeMap {
    
    class TBV {
        Map<Integer, String> values;
        List<Integer> time;
        boolean isSorted;
        
        public TBV () {
            this.values = new HashMap<>();
            this.time = new ArrayList<>();
            isSorted = true;
        }
        
        public void insert(int t, String s) {
            if (time.size() > 0 && t < time.get(time.size() - 1))
                isSorted = false;
            time.add(t);
            values.put(t, s);            
        }
        
        public String get(int ts) {
            if (!isSorted)
                Collections.sort(time);
            int index = Collections.binarySearch(time, ts);
            if (index == -1) {
                return "";
            }
            index = index < 0 ? -index - 2 : index;
            return values.get(time.get(index));
        }
    }
    
    Map<String, TBV> mapping;

    public TimeMap() {
        this.mapping = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mapping.putIfAbsent(key, new TBV());
        mapping.get(key).insert(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        String result = "";
        if (!mapping.containsKey(key)) 
            return result;
        TBV tbv = mapping.get(key);
        result = tbv.get(timestamp);
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
