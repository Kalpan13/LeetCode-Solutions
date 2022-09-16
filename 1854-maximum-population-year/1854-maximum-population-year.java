class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] pop = new int[2051];
        
        for(int[] log: logs)
        {
            int birth = log[0];
            int death = log[1];
            pop[birth]++;
            pop[death]--;
        }
        int max = 0;
        int year = -1;
        int curSum = 0;
        for(int i=0;i<2051;i++)
        {
            curSum += pop[i];
            if(max<curSum)
            {
                max = curSum;
                year = i;
            }
        }
        return year;
    }
}