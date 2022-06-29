class Solution {
    Map<Integer,Set<Integer>> prereqMap;
    public int minimumSemesters(int n, int[][] relations) {
        prereqMap = new HashMap<>();
        int coursesRemaining = n;
        int inDegree[] = new int[n+1];
        
        // Create a dependency graph for courses and their prereqs
        for(int[] relation : relations)
        {
            int course = relation[1];
            int prereq = relation[0];
            prereqMap.putIfAbsent(course, new HashSet<>());
            prereqMap.putIfAbsent(prereq, new HashSet<>());
            prereqMap.get(prereq).add(course);
            
            if(prereqMap.get(course).contains(prereq)) // Cycle
                return -1; 
            
            inDegree[course]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<n;i++)     // Take courses with no prereq
        {
            if(inDegree[i]==0)
                q.offer(i);
        }
        
        if(q.isEmpty())    // No course with 0 prereq
            return -1;
        int semestersTaken = 0;
        
        while(!q.isEmpty())
        {
            int qSize = q.size(); // Iterate over current possible courses
            semestersTaken++;
            for(int i=0;i<qSize;i++)
            {
                int currCourse = q.poll();
                coursesRemaining--;
                
                for(Integer course: prereqMap.getOrDefault(currCourse, new HashSet<>()))
                {
                    inDegree[course]--;   // Update Indegree of courses having currCourse as prereq
                    if(inDegree[course]==0)
                        q.offer(course);
                }
                prereqMap.remove(currCourse);
            }
        }
        return coursesRemaining==0?semestersTaken:-1;
        
    }
}