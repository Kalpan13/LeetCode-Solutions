class ProductOfNumbers {
    List<Integer> stream;
    public ProductOfNumbers() {
        stream = new ArrayList<>();
        stream.add(1);
    }
    
    public void add(int num) {
        if(num>0)
        {
            stream.add(stream.get(stream.size()-1)*num);    
        }
        else
        {
            stream = new ArrayList<>();
            stream.add(1);
        }
        
    }
    
    public int getProduct(int k) {
        
        int n = stream.size();
        // System.out.println("Stream : "+stream);
        // System.out.println("k : "+k);
        
        if(n-k<=0)
            return 0;
        else
            return stream.get(n-1)/stream.get(n-k-1);
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */