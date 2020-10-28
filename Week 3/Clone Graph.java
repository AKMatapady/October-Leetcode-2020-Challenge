/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null)
            return node;
        
        HashMap<Integer, List<Integer>> map1 = new HashMap();
        HashMap<Integer, Node> map2 = new HashMap();
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            if(map1.get(temp.val) == null)
            {
                List<Integer> ngh = new ArrayList<Integer>();
                for(Node e: temp.neighbors)
                {
                    ngh.add(e.val);
                    q.add(e);
                }
                map1.put(temp.val, ngh);
            }            
        }
        
        for(int key: map1.keySet())
        {
            Node curr = map2.getOrDefault(key, new Node(key));
            
            List<Integer> ngh = map1.get(key);
            List<Node> nodes = new ArrayList<Node>();
            for(int e: ngh)
            {
                Node n = map2.getOrDefault(e, new Node(e));
                
                map2.putIfAbsent(e, n);
                nodes.add(n);
            }
            curr.neighbors = nodes;
            map2.putIfAbsent(key, curr);
        }
        
        return map2.get(1);
    }
}