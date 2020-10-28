class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        if(nums == null || nums.length < 1)
            return ans;
        int start = nums[0], end = nums[0];
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] == (end + 1))
            {
                end = nums[i];
            }
            else
            {
                sb.append(start);
                if(start != end)
                {
                    sb.append("->"+end);
                }
                ans.add(sb.toString());
                sb = new StringBuilder();
                start = nums[i];
                end = nums[i];
            }
        }
        sb.append(start);
        if(start != end)
        {
            sb.append("->"+end);
        }
        ans.add(sb.toString());
        return ans;
    }
}