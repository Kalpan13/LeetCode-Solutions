class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int start = 0;
        int oddCount = 0;
        int ans = 0;
        int n = nums.length;
        
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==1)
                oddCount++;
            
            hm.put(oddCount, hm.getOrDefault(oddCount,0)+1);
            // cur - pre = k ==> cur - k = prev
            
            ans += hm.getOrDefault(oddCount-k,0);
        }
        return ans;
    }
}