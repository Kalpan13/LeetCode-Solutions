class LRUCache {
    DLNode head = null;
    DLNode tail = null;
    Map<Integer,DLNode> cache;
    int CAPACITY;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.CAPACITY = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key))
        {
            DLNode node = cache.get(key);
            promote(node);            
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key))
        {
            DLNode node = cache.get(key);
            node.val = value;
            promote(node);
        }
        else
        {
            if(cache.size()==CAPACITY)
            {
                DLNode tail = removeLast();
                cache.remove(tail.key);
            }
        
        
            DLNode node = insert(key, value);
            cache.put(key, node);    
        }
        
    }
    private DLNode insert(int key, int val)
    {
        if(head == null && tail == null)
        {
            head = new DLNode(key, val);
            tail = head;
            return head;
        }
        else
        {
            DLNode cur = new DLNode(key, val);
            head.prev = cur;
            cur.next = head;
            head = cur;
            return cur;
        }
    }
    private DLNode removeLast()
    {
        if(head==tail)
        {
            DLNode prev = tail;
            head = null;
            tail = null;
            return prev;
        }
        else
        {
            DLNode prev = tail;
            tail = tail.prev;
            tail.next = null;
            return prev;
        }
    }
    private void removeMiddle(DLNode node)
    {

        if(node==head) // Head
        {
                     
            DLNode prev = head;
            head = head.next;
            if(head!=null)
                head.prev = null;    
            else
                tail=null;
        }
        else if(node==tail)
           removeLast();
        else
        {
            DLNode prev = node.prev;
            DLNode next = node.next;
            prev.next = next;
            next.prev = prev;
            node = null;    
        }
        
    }
    
    
    private void promote(DLNode node)
    {
        if(node==head) // Head
            return;
        
        if(node==tail)
        {
            tail = tail.prev;
            tail.next = null;
            head.prev = node;
            node.next = head;
            head = node;
        }
        else
        {
            DLNode prev = node.prev;
            DLNode next = node.next;
            prev.next = next;
            next.prev = prev;
            head.prev = node;
            node.next = head;
            head = node;
        }
    }
}

class DLNode{
    int val;
    int key;
    DLNode next, prev;
    
    DLNode(int key, int val)
    {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */