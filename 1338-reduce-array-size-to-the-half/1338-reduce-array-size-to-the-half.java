class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        int[][] frq = new int[hm.size()][2];
        int j = 0;
        for(Map.Entry<Integer,Integer> e: hm.entrySet())
        {
            frq[j][0] = e.getKey();
            frq[j][1] = e.getValue();
            j++;
        }
        Arrays.sort(frq, (a,b)->b[1]-a[1]);
        int minSize = n/2;
        int sum = 0;
        for(int i=0;i<frq.length;i++)
        {
            int f = frq[i][1];
            sum+= f;
            if(minSize<=sum)
                return i+1;
        }
        return frq.length;
    }
}