class SparseVector {
    Map<Integer,Integer> indMap;
    Set<Integer> inds;
    int size;
    SparseVector(int[] nums) {
        indMap = new HashMap<>();
        inds = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            indMap.put(i,nums[i]);
            inds.add(i);
        }
        size = nums.length;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int val = 0;
        
        for(int i=0;i<size;i++)
        {
            if(this.inds.contains(i) && vec.inds.contains(i))
                val += (this.indMap.get(i) * vec.indMap.get(i));
        }
        return val;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);