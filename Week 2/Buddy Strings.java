class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A == null || B == null || A.length() < 1 || B.length() < 1 || A.length() != B.length())
            return false;
        int c = 0, j = -1, k = -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < A.length(); i++)
        {
            map.put(A.charAt(i), map.getOrDefault(A.charAt(i), 0)+1);
            if(A.charAt(i) != B.charAt(i))
            {
                c++;
                if( j == -1)
                {
                    j = i;
                }
                else
                {
                    k = i;
                }
            }
            if(c > 2)
                return false;
        }
        if(c == 1)
            return false;
        boolean found = false;
        for(char ch: map.keySet())
        {
            if(map.get(ch) > 1)
            {
                found = true;
                break;
            }
        }
        if(c == 0)
        {
            if(!found)
            return false;
            return true;
        }
        if(A.charAt(j) != B.charAt(k) || B.charAt(j) != A.charAt(k))
            return false;
        return true;
    }
}