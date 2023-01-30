class Solution {
    public String rankTeams(String[] votes) {
        if(votes.length==1)
            return votes[0];
        int numTeams = votes[0].length();
        Map<Character,int[]> teamRanks = new HashMap<>();
        
        for(String vote : votes)
        {
            for(int i=0;i<numTeams;i++)
            {
                char c = vote.charAt(i);
                teamRanks.putIfAbsent(c, new int[numTeams]);
                teamRanks.get(c)[i]++;
            }
        }
        List<Character> rankedTeams = new ArrayList<>(teamRanks.keySet());
        
        Collections.sort(rankedTeams, (a,b)->{
            for(int i=0;i<numTeams;i++)
            {
                if(teamRanks.get(a)[i]!=teamRanks.get(b)[i])
                {
                    return teamRanks.get(b)[i] - teamRanks.get(a)[i];
                }
            }
            return a-b;
        });
        
        StringBuffer result = new StringBuffer();
        for(char c: rankedTeams)
        {
            result.append(c);
        }
        return result.toString();
        
        
        
    }
}