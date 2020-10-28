class Solution {
    public String removeDuplicateLetters(String s) {
        
        if(s == null || s.length() < 2)
            return s;
        
        Stack<Character> st = new Stack<Character>();
        //character -> last location
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        Set<Character> seen = new HashSet<Character>();
        
        for(int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), i);
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(!seen.contains(ch))
            {
                while(!st.isEmpty() && st.peek() > ch && map.get(st.peek()) > i)
                {
                    char last = st.pop();
                    seen.remove(last);
                }
                seen.add(ch);
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: st)
        {
            sb.append(""+ch);
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }
}