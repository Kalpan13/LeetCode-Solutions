class MaxStack {
    PriorityQueue<int[]> pq;
    Stack<int[]> stack;
    int index = 0;
    Set<Integer> deleted;
    public MaxStack() {
        stack = new Stack<>();
        pq = new PriorityQueue<>((a,b)->b[0]-a[0]==0?b[1]-a[1]:b[0]-a[0]);
        
        deleted = new HashSet<>();
    }
    
    public void push(int x) {
        stack.push(new int[]{x,index});
        pq.offer(new int[]{x, index++});
    }
    
    public int pop() {
        while(deleted.contains(stack.peek()[1]))
            stack.pop();
        
        int[] top = stack.pop();
        deleted.add(top[1]);
        return top[0];
    }
    
    public int top() {
        while(deleted.contains(stack.peek()[1]))
            stack.pop();
        
        int[] top = stack.peek();
        return top[0];
    }
    
    public int peekMax() {
        
        while(deleted.contains(pq.peek()[1]))
            pq.poll();
        
        int[] maxTop = pq.peek();
        return maxTop[0];
        
    }
    
    public int popMax() {
        while(deleted.contains(pq.peek()[1]))
            pq.poll();
        
        int[] maxTop = pq.peek();
        deleted.add(maxTop[1]);
        return maxTop[0];
        
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */