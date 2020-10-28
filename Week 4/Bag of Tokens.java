class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        
        int max  = 0, curr = 0;
        
        if(tokens == null || tokens.length < 1)
            return max;
        
        if(tokens.length == 1)
            if(tokens[0] > P)
                return 0;
            else
                return 1;
        
        Arrays.sort(tokens);
        int i = 0, j = tokens.length-1;
        
        while(i <= j)
        {
            if(tokens[i] <= P)
            {
                P -= tokens[i];
                curr++;
                i++;
            }
            else
            {
                if(curr > 0)
                {
                    P += tokens[j];
                    j--;
                    curr--;
                }
                else
                    break;
            }
            if(curr > max)
                max = curr;
        }
        
        
        return max;
    }
}