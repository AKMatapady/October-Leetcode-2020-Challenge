class Solution {
    public boolean find132pattern(int[] nums) {
       if(nums == null || nums.length < 3) 
           return false;
        int[] min = new int[nums.length]; 
        //int max = nums[0];
        int cmin = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] < cmin)
                cmin = nums[i];
            min[i] = cmin;
        }
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = nums.length-1; i >= 0; i--)
        {
            while(!st.isEmpty() && st.peek() <= min[i])
            {
                st.pop();
            }
            
            if(!st.isEmpty() && nums[i] > st.peek())
            {
                return true;
            }
            if(nums[i] > min[i])
            {
                st.push(nums[i]);
            }
            // if(nums[i] < min)
            // {
            //     min = nums[i];
            //     max = nums[i];
            // }
            // else if(nums[i] > max)
            // {
            //     max = nums[i];
            // }
            // else
            // {
            //     return true;
            // }
        }
        
        return false;
    }
}