class RandomizedCollection {
    Map<Integer,Set<Integer>> hm;
    List<Integer> arr;
    Random rand;
    public RandomizedCollection() {
        rand = new Random();
        hm = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val))
        {
            hm.get(val).add(arr.size());
            arr.add(val);
            return false;    
        }
        hm.put(val, new HashSet<>());
        hm.get(val).add(arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val))
            return false;
        
        Set<Integer> indices = hm.get(val);
        int removeIdx = indices.iterator().next();
        int lastVal = arr.get(arr.size()-1);
        int lastIdx = arr.size()-1;
        arr.set(removeIdx, lastVal);
        arr.remove(arr.size()-1);
        
        indices.remove(removeIdx);
        
        
        if(indices.size()==0)
            hm.remove(val);
        else
            hm.put(val,  indices);
        
        if(hm.containsKey(lastVal))
        {
            hm.get(lastVal).remove(lastIdx);
            hm.get(lastVal).add(removeIdx);
        }
        return true;
        
    }
    
    public int getRandom() {
        int randInd = rand.nextInt(arr.size());
        return arr.get(randInd);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */