class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length==0)
            return new int[]{-1,-1};
        
        if(nums.length==1)
        {
            if(nums[0]==target)
                return new int[]{0,0};
            else
                return new int[]{-1,-1};
        }
        
        int first = findFirst(nums, target);
        if(first==-1)
            return new int[]{-1,-1};
        int last = findLast(nums, target, first);
        return new int[]{first, last};
    }
    public int findFirst(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length-1;
        int first = -1;
        while(low<high)
        {
            int mid = (low+high)/2;
            // System.out.println("low :"+low + " mid :"+mid + " high : "+high);
            if(nums[mid]==target)
            {
                if(mid==0 || nums[mid-1]<nums[mid]) // first occurrence found
                {
                    return mid;
                }
                else
                {
                    high = mid;
                    first = mid;
                    // System.out.println("New High :"+first);
                }
            }
            else if(nums[mid]>target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        // System.out.println("lowerBound : "+first);
        if(low<0)
            return first;
        
        return nums[low]==target?low:first;
    }
    public int findLast(int[] nums, int target, int first)
    {
        int low = first;
        int high = nums.length-1;
        int last = -1;
        while(low<high)
        {
            int mid = (low+high)/2;
            // System.out.println("low :"+low + " mid :"+mid + " high : "+high);
            if(nums[mid]==target)
            {
                if(mid==nums.length-1 || nums[mid]<nums[mid+1])
                {
                    return mid;
                }
                else
                {
                    last = mid;
                    low = mid+1;
                }
            }
            else if(nums[mid]>target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        if(high>=nums.length)
            return last;
        
        // System.out.println("upperBound : "+last);
        
        return nums[high]==target?high:last;
    }
}