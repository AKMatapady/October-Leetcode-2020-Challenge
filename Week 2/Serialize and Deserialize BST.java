/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    private String Construct(TreeNode root)
    {
        if(root == null)
            return "null";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        sb.append(root.val+",");
        while(q.size() > 0)
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode child = q.poll();
                if(child.left == null)
                {
                    sb.append("null,");
                }
                else
                {
                    sb.append(child.left.val + ",");
                    q.add(child.left);
                }
                if(child.right == null)
                {
                    sb.append("null,");
                }
                else
                {
                    sb.append(child.right.val + ",");
                    q.add(child.right);
                }
            }
        }
        return sb.toString();
    }
    
    private TreeNode DeConstruct(String str)
    {
        TreeNode head = null;
        if(str.equals("null"))
            return head;
        
        String[] arr = str.trim().split(",");
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        head = new TreeNode(Integer.valueOf(arr[0]));
        // head.left = null;
        // head.right = null;
        q.add(head);
        TreeNode prev = null;
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i].trim().length() > 0)
            {
                if(prev == null)
                {
                    if(q.size() > 0)
                    {
                        prev = q.poll();
                        //String s = arr[i];
                        if(arr[i].equals("null"))
                        {
                            prev.left = null;
                        }
                        else
                        {
                            TreeNode next = new TreeNode(Integer.valueOf(arr[i]));
                            // next.left = null;
                            // next.right = null;
                            prev.left = next;
                            q.add(next);
                        }
                    }   
                }
                else
                {
                    if(arr[i].equals("null"))
                    {
                        prev.right = null;
                    }
                    else
                    {
                        TreeNode next = new TreeNode(Integer.valueOf(arr[i]));
                        // next.left = null;
                        // next.right = null;
                        prev.right = next;
                        q.add(next);
                    }
                    prev = null;
                }
                             
            }
        }
        
        return head;
    }
    

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return Construct(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //System.out.println(data);
        return DeConstruct(data);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;