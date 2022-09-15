/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    StringBuffer serialized;
    
    public String serialize(Node root) {
        serialized = new StringBuffer();
        serializeHelper(root);
        return serialized.toString();
    }
    private void serializeHelper(Node root)
    {
        if(root==null)
            return;
        serialized.append(root.val);
        if(root.children==null || root.children.size()==0)
            serialized.append(" ");
        else
        {
            serialized.append("[");
            for(Node child: root.children)
            {
                serializeHelper(child);
            }
            serialized.append("]");    
        }
    }
    
	int ptr = 0;
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        return dfs(data);
    }
    private Node dfs(String data)
    {
        
        
        if(ptr>=data.length())
            return null;
       
        if(data.charAt(ptr)==']')
        {
            ptr++;
            return null;
        }
        int j = ptr;
        int val = 0;
        while(j<data.length() && Character.isDigit(data.charAt(j)))
        {
            val = val*10 + (data.charAt(j)-'0');
            j++;
        }
        Node node = new Node(val, new ArrayList<>());
        ptr = j;
        if(ptr<data.length() && data.charAt(ptr)=='[')
        {
            ptr++;
            while(true)
            {
               Node child = dfs(data);
               if(child!=null)
                   node.children.add(child);
               else
                   break;
            }
        }
        if(ptr<data.length() && data.charAt(ptr)==' '){
            ptr++;
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));