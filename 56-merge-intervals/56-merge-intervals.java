class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]==0?a[1]-b[1]:a[0]-b[0]));
        
        for(int[] interval : intervals)
        {
            int start = interval[0];
            int end = interval[1];
            if(merged.size()==0 || merged.get(merged.size()-1)[1]< start)
                merged.add(interval);
            else
            {
                merged.get(merged.size()-1)[1] = Math.max(end, merged.get(merged.size()-1)[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    
    }
}