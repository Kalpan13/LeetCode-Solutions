class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a,b)->a[0]-b[0]);
        Arrays.sort(slots2, (a,b)->a[0]-b[0]);
        
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<slots1.length && j<slots2.length)
        {
            int s1 = slots1[i][0];
            int e1 = slots1[i][1];
            int s2 = slots2[j][0];
            int e2 = slots2[j][1];
            
            int maxS = Math.max(s1,s2);
            int minE = Math.min(e1,e2);
            if(maxS+duration<=minE)
            {
                ans.add(maxS);
                ans.add(maxS+duration);
                return ans;
            }
            if(e1<e2)
                i++;
            else
                j++;
        }
        return ans;
    }
}