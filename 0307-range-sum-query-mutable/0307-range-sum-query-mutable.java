class SegTreeNode{
    int start;
    int end;
    int sum;
    SegTreeNode left;
    SegTreeNode right;
    SegTreeNode(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}
class NumArray {

    int n;
    SegTreeNode root;
    int[] nums;
    public NumArray(int[] input) {
        nums = input.clone();
        n = nums.length;
        root = buildSegTree(0, n-1, nums);
    }
    public SegTreeNode buildSegTree(int start, int end, int[] nums)
    {   
        if(start==end)
        {
            SegTreeNode leaf = new SegTreeNode(start,end);
            leaf.sum = nums[start];
            return leaf;
        }
        int mid = (start+end)/2;
        SegTreeNode root = new SegTreeNode(start, end);
        root.left = buildSegTree(start, mid, nums);
        root.right = buildSegTree(mid+1, end, nums);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    public void update(int index, int val) {
        int prev = nums[index];
        nums[index] = val;
        int diff = val-prev;
        updateHelper(index, diff, root);
    }
    public void updateHelper(int pos, int diff, SegTreeNode node)
    {
        
        if(node==null || pos<node.start || pos>node.end)
            return;
        node.sum+= diff;
        
        updateHelper(pos, diff, node.left);
        updateHelper(pos, diff, node.right);
    }
    
    public int sumRange(int left, int right) {
        int sum = sumRangeHelper(root, left, right);
        return sum;
    }
    public int sumRangeHelper(SegTreeNode node, int left, int right)
    {
        if(node.start>=left && node.end<=right)  // Total Overlap
        {
            return node.sum;
        }
        else if(node.start>right || node.end<left)
            return 0;
        
        return sumRangeHelper(node.left, left, right) + sumRangeHelper(node.right, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */