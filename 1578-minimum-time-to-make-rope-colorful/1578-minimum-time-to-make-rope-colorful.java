class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost = 0;
        int maxCostGroup = 0;
        int sumCostGroup = 0;
        char colorsChar[] = colors.toCharArray();
        
        for(int i=1;i<colorsChar.length;i++)
        {
            if(colorsChar[i]==colorsChar[i-1]) // Same color as previous
            {
                sumCostGroup += neededTime[i-1];
                maxCostGroup = Math.max(neededTime[i-1], maxCostGroup);
                if(i==colorsChar.length-1)
                {
                    sumCostGroup += neededTime[i];
                    maxCostGroup = Math.max(neededTime[i], maxCostGroup);
                    // System.out.println("i : "+i+" sum : "+sumCostGroup + " maxCostGroup :"+maxCostGroup);
                    cost += sumCostGroup-maxCostGroup;
                }
            }
            else
            {
                sumCostGroup += neededTime[i-1];
                maxCostGroup = Math.max(neededTime[i-1], maxCostGroup);
                // System.out.println("i : "+i+" sum : "+sumCostGroup + " maxCostGroup :"+maxCostGroup);
                cost += sumCostGroup-maxCostGroup;
                
                sumCostGroup = maxCostGroup = 0;
                
            }
        }
        
        return cost;
    }
    
}