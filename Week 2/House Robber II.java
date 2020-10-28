class Solution {
    
    int[] n;
    
    private int sub(int start, int end)
    {
        int a = 0, b = 0;
        
        for(int i = start; i < end; i++)
        {
            int temp = b;
            b = Math.max(a+n[i], b);
            a = temp;
        }
        return b;
    }
    
    public int rob(int[] nums) {
        int ans = 0;
        if(nums == null || nums.length < 1)
            return ans;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        
        n = nums;
        
        int a = sub(0, n.length-1);
        int b = sub(1, n.length);
        
        return Math.max(a,b);
        
    }
}