class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return subArraysWithAtMostK(nums, k) - subArraysWithAtMostK(nums, k-1);
    }
    public int subArraysWithAtMostK(int[] nums, int k)
    {
        Map<Integer,Integer> hm = new HashMap<>();
        
        int start = 0;
        int uniqNum = 0;
        int res = 0;
        for(int end=0;end<nums.length;end++)
        {
            int numEnd = nums[end];
            hm.put(numEnd, hm.getOrDefault(numEnd,0)+1);
            if(hm.get(numEnd)==1) // New Element added in window
                uniqNum++;
            
            while(uniqNum>k)
            {
                int numStart = nums[start];
                hm.put(numStart, hm.get(nums[start])-1);
                if(hm.get(nums[start])==0)
                    uniqNum--;
                start++;
                
            }
            res += (end-start+1);
        }
        return res;
    }
}