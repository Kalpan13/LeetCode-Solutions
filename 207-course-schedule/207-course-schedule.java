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
        //System.out.println(prereqs);
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
            //System.out.println("Taking course :"+course);
            coursePending--;
            Set<Integer> nextCourses = prereqs.getOrDefault(course, new HashSet<>());
            //System.out.println("Resolving course :"+nextCourses);
            for(int next:nextCourses)
            {      
                inDegree[next]--;
               // System.out.println("Indegree : "+next + " is "+inDegree[next]);
                if(inDegree[next]==0)
                {
                    inDegree[next]--;
                    //prereqs.get(course).remove(next);
                    q.offer(next);
                }
            }
        }
        return coursePending==0;
        
    }
}