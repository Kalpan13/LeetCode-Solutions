class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> ans = new ArrayList<int[]>();
        
        // Sort both the lists based on start time
        Arrays.sort(firstList, (a,b)-> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        Arrays.sort(secondList, (a,b)-> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        
        int i=0,j=0,m=firstList.length,n=secondList.length;
        
        while(i<m && j<n)
        {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];
            
            int startMax = Math.max(start1, start2);
            int endMin = Math.min(end1, end2);
            
            if(endMin>=startMax)
                ans.add(new int[]{startMax, endMin});
            
            if(end1>end2)
                j++;
            // else if(end2>end1)
            //     i++;
            // else{
            //     i++;
            //     j++;
            // }
            else
                i++;
                
            
        }
        return ans.toArray(new int[ans.size()][]);
    }
}