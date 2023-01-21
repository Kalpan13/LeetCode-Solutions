class Solution {
    Map<String,Integer> result;
    public List<String> subdomainVisits(String[] cpdomains) {
        
        result = new HashMap<>();
        for(String cpdomain: cpdomains)
        {
            String[] count_domain = cpdomain.split(" ");
            int count = Integer.parseInt(count_domain[0]);
            processDomain(count_domain[1], count);
        }
        List<String> ans = new ArrayList<>();
        for(String key: result.keySet())
        {
            String val = String.valueOf(result.get(key)+" "+key);
            ans.add(val);
        }
        return ans;
        
    }
    public void processDomain(String domain, int count)
    {
        result.put(domain, result.getOrDefault(domain,0)+count);
        int dotIndex = domain.indexOf('.');
        if(dotIndex>=0)
        {
            String newDomain = domain.substring(dotIndex+1);
            processDomain(newDomain, count);
        }
    }
}