class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low < high)
        {
            int mid = low + (high-low)/2;
            // System.out.println("low i : "+ low + " high i:"+high + " mid i: "+mid);
            // System.out.println("low :"+nums[low]+ " high : "+nums[high] + " mid :"+nums[mid]);
            if(nums[mid]==target)
                return mid;
            
            if(nums[mid]>=nums[low]) // left part is sorted
            {
                if(nums[mid]>target && nums[low]<=target)
                    high = mid-1;
                else
                    low = mid+1;
            }    
            else  // right part is sorted
            { 
                if(nums[mid]<target && nums[high]>=target)
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return nums[low]==target?low:-1;
    }
}