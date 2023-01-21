class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        
        Map<String,List<String>> entries = new HashMap<>();
        List<String> result = new ArrayList<>();
        int n = keyName.length;
        for(int i=0;i<n;i++)
        {
            entries.putIfAbsent(keyName[i], new ArrayList<>());
            entries.get(keyName[i]).add(keyTime[i]);
        }
        // System.out.println(entries);
        for(String key: entries.keySet())
        {
            Collections.sort(entries.get(key),(a,b)->{
                return a.compareTo(b);
            });
            
            if(hasAlert(entries.get(key)))
            {
                result.add(key);
            }
        }
        Collections.sort(result, (a,b)->{
            return a.compareTo(b);
        });
        return result;
    }
    public boolean hasAlert(List<String> userEntries)
    {
        // System.out.println("Entries : "+userEntries);
        
        if(userEntries.size()<3)
            return false;
        
        for(int i=2;i<userEntries.size();i++)
        {
            String secondLast = userEntries.get(i-2);
            String current = userEntries.get(i);
            
            String hh1 = secondLast.split(":")[0];
            String mm1 = secondLast.split(":")[1];
            String hh2 = current.split(":")[0];
            String mm2 = current.split(":")[1];
            
            int h1 = Integer.parseInt(hh1);
            int m1 = Integer.parseInt(mm1);
            int h2 = Integer.parseInt(hh2);
            int m2 = Integer.parseInt(mm2);
            
            if(h2==h1 || (h2==(h1+1) && m2<=m1))
                return true;    
        }
        return false;
    }
}