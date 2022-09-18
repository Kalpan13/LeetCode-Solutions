class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxL[] = new int[n];
        int maxR[] = new int[n];
        
        for(int i=1;i<n;i++)
        {
            maxL[i] = Math.max(maxL[i-1],height[i-1]);
        }
        
        for(int i=n-2;i>=0;i--)
        {
            maxR[i] = Math.max(maxR[i+1],height[i+1]);
        }
        // for(int i=0;i<n;i++)
        // {
        //     System.out.println("i : "+i+" maxL :"+maxL[i] + " maxR : "+maxR[i]);
        // }
        
        int trappedWater = 0;
        
        for(int i=0;i<n;i++)
        {
            trappedWater += Math.max(0,Math.min(maxL[i],maxR[i])-height[i]);
        }
        return trappedWater;
        
    }
}