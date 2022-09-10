class RandomizedSet {
    Map<Integer,Integer> indices;
    List<Integer> nums;
    Random rand;
    public RandomizedSet() {
        nums = new ArrayList<>();
        indices = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(indices.containsKey(val))
            return false;
        
        indices.put(val,nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!indices.containsKey(val))
            return false;
        
        
        int ind = indices.get(val);
        if(ind<nums.size()-1)
        {
            indices.remove(val);
            indices.put(nums.get(nums.size()-1), ind);
            nums.set(ind, nums.get(nums.size()-1));
            nums.remove(nums.size()-1);    
        }
        else
        {
            nums.remove(nums.size()-1);   
            indices.remove(val);
        }
        
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */