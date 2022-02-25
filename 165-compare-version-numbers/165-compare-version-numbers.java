class Solution {
    public int compareVersion(String version1, String version2) {
        
        List<Integer> v1 = getVersions(version1);
        List<Integer> v2 = getVersions(version2);
        int i = 0;
        
        for(;i<Math.min(v1.size(),v2.size());i++)
        {
            if(v1.get(i)>v2.get(i))
           
                return 1;
            if(v1.get(i)<v2.get(i))
                return -1;
        }
        if(i<v1.size())
        {
            while(i<v1.size())
            {
                if(v1.get(i++)>0)
                    return 1;
            }
            return 0;
        }
        if(i<v2.size())
        {
            while(i<v2.size())
            {
                if(v2.get(i++)>0)
                    return -1;
            }
            return 0;
        }
        return 0;
    }
    public List<Integer> getVersions(String v)
    {
        String revisions[] = v.split("\\.");
        List<Integer> ans = new ArrayList<>();
        for(String revision : revisions)
        {
            int intRev = Integer.parseInt(revision);
            ans.add(intRev);
        }
        return ans;
    }
}