class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        dp[0] = false;
        dp[1] = true;
        for(int i = 2; i <= n; i++)
        {
            for(int j = 1; (i - (j * j))>= 0; j++)
            {
                if(!dp[i-(j*j)])
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}