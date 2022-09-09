class UndergroundSystem {
    Map<String,Pair<Double,Integer>> avgTime = new HashMap<>();
    Map<Integer,Pair<String,Integer>> checkIns = new HashMap<>();
        
    private String getKey(String start, String end)
    {
        return start+","+end;
    }
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String,Integer> checkinDetails = checkIns.get(id);
        String start = checkinDetails.getKey();
        int startTime = checkinDetails.getValue();
        
        String key = getKey(start, stationName);
        avgTime.putIfAbsent(key, new Pair(0.0,0));
        
        Pair<Double,Integer> avgDetail = avgTime.get(key);
        
        Double avgTimeVal = avgDetail.getKey();
        int n = avgDetail.getValue();
        
        Double updatedAvg = (avgTimeVal*n+(t-startTime))/(n+1);
        avgTime.put(key, new Pair(updatedAvg,n+1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return avgTime.get(getKey(startStation,endStation)).getKey();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */