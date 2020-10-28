class Solution {
    
//     private int val(String quad)
//     {
//         StringBuilder sb = new StringBuilder();
        
        
//     }
    
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() < 10)
            return new ArrayList();
        
        List<String> ans = new ArrayList();
        Map<String, Integer> freq = new HashMap<>();
        
        for(int i = 10; i <= s.length(); i++) 
        {
            String sub = s.substring(i-10, i);
            if(freq.containsKey(sub) && freq.get(sub) == 1) 
            {
                ans.add(sub);
            }
            freq.put(sub, freq.getOrDefault(sub, 0)+1);
        }
        
        return ans;
    }
}