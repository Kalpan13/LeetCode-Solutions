class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        
        // for(int i=0;i<n;i++)
        //     System.out.print(nums[i] + ", ");
        // System.out.println();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<n-2;i++)
        {
            if(nums[i]>0)
                break;
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int j = i+1;
            int k = n-1;
            
            int target = -nums[i];
            int prevJ = nums[i];
            
            while(j<k)
            {
                if(nums[j]+nums[k]==target)
                {
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    int lastLow = nums[j];
                    int lastHigh = nums[k];
                    while(j<k && nums[j]==lastLow)
                        j++;
                    
                    while(j<k && nums[k]==lastHigh)
                        k--;
                }
                   
                else if(nums[j]+nums[k]>target)
                    k--;
                else
                {
                    j++;
                }
            }
            
        }
        return ans;
    }
}