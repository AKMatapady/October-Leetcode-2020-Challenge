class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        
        //dp[0] = 1;
        int max = 1;
        Arrays.fill(count, 1);
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i++)
        {
            
            for(int j = i-1; j >= 0; j--)
            {
                if(nums[i] > nums[j])
                {
                    if(dp[j] >= dp[i] )
                    {
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    }
                    else if(dp[i] == (dp[j]+1))
                    {
                        count[i]+=count[j];
                    }
                }
            }
            
            // int j = i-1;
            // while(j >= 0 && nums[j] > nums[i])
            //     j--;
            // System.out.println(i + " " + j);
            // if(j >= 0)
            //     dp[i] = dp[j]+1;
            // else
            //     dp[i] = 1;
            // System.out.println(dp[i]);
            
            if(dp[i] > max)
            {
                max = dp[i];
                //count = 1;
            }
            // else if(dp[i] == max)
            //     count++;
        }
        
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(dp[i] == max)
                ans += count[i];
        }
        
        // System.out.println(max);
        // System.out.println(Arrays.toString(dp));
        // System.out.println(Arrays.toString(count));
        return ans;
    }
}