class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        Map<Integer,Set<Integer>> prereqs = new HashMap();
        int[] inDegree = new int[n];
        for(int[] p: prerequisites)
        {
            int course = p[0];
            int prereq = p[1];
            
            prereqs.putIfAbsent(course, new HashSet<>());
            prereqs.putIfAbsent(prereq, new HashSet<>());
            
            prereqs.get(prereq).add(course);
            inDegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n];
        for(int i=0;i<n;i++)
        {
            if(inDegree[i]==0)
                q.offer(i);
        }
        int i = 0;
        while(!q.isEmpty())
        {
            int curCourse = q.poll();
            Set<Integer> dependentCourses = new HashSet<>(prereqs.getOrDefault(curCourse, new HashSet<>()));
            ans[i++] = curCourse;
            for(int dependentCourse : dependentCourses)
            {
                inDegree[dependentCourse]--;
                if(inDegree[dependentCourse]==0)
                {
                    q.offer(dependentCourse);
                    prereqs.get(curCourse).remove(dependentCourse);
                }
            }
        }
        return i==n?ans:new int[0];
    }
}