/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int posCeleb = 0;
        
        for(int i=1;i<n;i++)
        {
            if(knows(posCeleb,i))
                posCeleb = i;
        }
        for(int i=0;i<n;i++)
        {
            if(i!=posCeleb && (!knows(i,posCeleb) || knows(posCeleb,i)))
                return -1;
        }
        return posCeleb;
    }
}