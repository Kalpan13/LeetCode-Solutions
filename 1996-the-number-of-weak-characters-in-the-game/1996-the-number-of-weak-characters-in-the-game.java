class Solution {
    public int numberOfWeakCharacters(int[][] props) {
        Arrays.sort(props, (a,b)-> (a[0]==b[0])?b[1]-a[1]:a[0]-b[0]);
        int n = props.length;
        
        // (1,5)(1,4)(1,3) (2,4)(2,3), (3,6)(3,4)
        int weakCharacters = 0;
        int maxDefense = 0;
        for (int i = props.length - 1; i >= 0; i--) {
            // Compare the current defense with the maximum achieved so far
            if (props[i][1] < maxDefense) {
                weakCharacters++;
            }
            maxDefense = Math.max(maxDefense, props[i][1]);
        }
        
        return weakCharacters;
    }
}