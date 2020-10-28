class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length < 1 || k < 1)
            return 0;
        
        if(2*k > prices.length)
        {
            int sp = 0;
            for(int i = 1; i < prices.length; i++)
            {
                sp += Math.max(0, prices[i] - prices[i-1]);
            }
            return sp;
        }
        
        int[][][] dp = new int[prices.length][k+1][2];
        
        for(int i = 0; i < prices.length; i++)
        {
            for(int j = 0; j <= k; j++)
            {
                Arrays.fill(dp[i][j], (Integer.MIN_VALUE/2));
            }
        }
        
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        
        for(int i = 1; i < prices.length; i++)
        {
            for(int j = 0; j <= k; j++)
            {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i]);
                if(j > 0)
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i]);
            }
        }
        
        int ans = 0;
        
        for(int i = 0; i <= k; i++)
        {
            ans = Math.max(ans, dp[prices.length-1][i][0]);
        }
        return ans;
    }
}