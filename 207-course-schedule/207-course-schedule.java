class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int inDegree[] = new int[n];
        
        Map<Integer,Set<Integer>> prereqs = new HashMap<>();
        
        for(int[] p : prerequisites)
        {
            int course = p[0];
            int prereq = p[1];
            inDegree[course]++;
            prereqs.putIfAbsent(course,new HashSet<>());
            prereqs.putIfAbsent(prereq,new HashSet<>());
            
            prereqs.get(prereq).add(course);
        }
        Queue<Integer> q = new LinkedList<>();
        int coursePending = n;
        for(int i=0;i<n;i++)
        {
            if(inDegree[i]==0)
                q.offer(i);
        }
        while(!q.isEmpty())
        {
            int course = q.poll();
            coursePending--;
            Set<Integer> nextCourses = prereqs.getOrDefault(course, new HashSet<>());
            for(int next:nextCourses)
            {      
                inDegree[next]--;
                if(inDegree[next]==0)
                {
                    inDegree[next]--;
                    q.offer(next);
                }
            }
        }
        return coursePending==0;
        
    }
}