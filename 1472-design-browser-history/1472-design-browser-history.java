class BrowserHistory {
    List<String> urls;
    int currentInd = 0;
    int historySize = 0;
    public BrowserHistory(String homepage) {
        urls = new ArrayList<>();
        urls.add(homepage);
        historySize = 1;
    }
    
    public void visit(String url) {
        if(currentInd+1 < urls.size())
            urls.set(currentInd+1,url);
        else
            urls.add(url);
            
        currentInd++;
        historySize = currentInd+1;
    }
    
    public String back(int steps) {
        
        currentInd = Math.max(0,currentInd-steps);
        return urls.get(currentInd);
        
    }
    
    public String forward(int steps) {
        currentInd = Math.min(historySize-1, currentInd+steps);
        return urls.get(currentInd);
    }
}
/*
["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]

    B                 V              V                  V          B   B   F
[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],
    V             F   B   B
["linkedin.com"],[2],[2],[7]]
*

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */