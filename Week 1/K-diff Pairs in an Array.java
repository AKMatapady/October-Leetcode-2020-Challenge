class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return 0;
        Arrays.sort(nums);
        Set<Integer> st = new HashSet<Integer>();
        int count = 0;
        if(k == 0)
        {
            for(int i = 1; i < nums.length; i++)
            {
                if(nums[i] == nums[i-1])
                {
                    st.add(nums[i]);
                }
            }
            return st.size();
        }
        else
        {
            st.add(nums[0]);
            for(int i = 1; i < nums.length; i++)
            {
                if(nums[i] == nums[i-1])
                    continue;
                if(st.contains(nums[i] - k))
                {
                    count++;
                }
                st.add(nums[i]);
            }
        }
        return count;
    }
}