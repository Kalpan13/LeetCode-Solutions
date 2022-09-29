class RandomizedSet {
    Map<Integer,Integer> hm;
    Random rand;
    List<Integer> arr;
    public RandomizedSet() {
        hm = new HashMap<>();
        rand = new Random();
        arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        
        if(hm.containsKey(val))
            return false;
        hm.put(val, arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val))
            return false;
        int ind = hm.get(val);
        int lastEle = arr.get(arr.size()-1);
        
        arr.set(ind, lastEle);
        arr.remove(arr.size()-1);
        hm.remove(val);
        if(val!=lastEle)
            hm.put(lastEle, ind);
        return true;
    }
    
    public int getRandom() {
        int randInd = rand.nextInt(arr.size());
        
        return arr.get(randInd);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */