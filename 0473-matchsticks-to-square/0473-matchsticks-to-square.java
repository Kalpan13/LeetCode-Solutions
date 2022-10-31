class Solution {

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int ms : matchsticks)
            sum += ms;
        if(sum%4!=0)
            return false;
        int maxLen = sum / 4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(matchsticks, 0, 0, 0, 0, maxLen, 0);
    }
    public boolean backtrack(int[] ms, int left, int right, int up, int down, int maxLen, int pos)
    {
        if(maxLen<left || maxLen<right || maxLen<up || maxLen<down)
            return false;
        if(pos==ms.length)
        {
            return (left==right) && (up==down) && (left==up);
        }
        return backtrack(ms, left+ms[pos], right, up, down, maxLen, pos+1) 
            || backtrack(ms, left, right+ms[pos], up, down, maxLen, pos+1)
            || backtrack(ms, left, right, up+ms[pos], down, maxLen, pos+1)
            || backtrack(ms, left, right, up, down+ms[pos], maxLen, pos+1);
    }
    public void reverse(int[] arr)
    {
        for(int i=0;i<arr.length/2;i++)
        {
            int tp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = tp;
        }
    }
}