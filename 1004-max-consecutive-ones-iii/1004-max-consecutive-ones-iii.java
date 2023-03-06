class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxSoFar = 0;
        
        int start = 0;
        int flipped = 0;
        int count = 0;
        for(int end=0;end<nums.length;end++)
        {
            int num = nums[end];
            
            if(num==0)
            {
                count++;
            }
            //System.out.println("Reducing the window");
            while(count>k)
            {
                if(nums[start]==0)
                    count--;
                start++;
            }
            maxSoFar = Math.max(maxSoFar, end-start+1);
        }

        return maxSoFar;
    }
}