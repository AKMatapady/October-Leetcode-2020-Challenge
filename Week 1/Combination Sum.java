class Solution {
    
    private void backTrack(int required, int start, List<Integer> curr, List<List<Integer>> ans)
    {
        if(required == 0)
        {
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        if(required < 0)
            return;
        for(int i = start; i < c.length; i++)
        {
            curr.add(c[i]);
            backTrack(required-c[i], i, curr, ans);
            curr.remove(curr.size()-1);
        }
        
    }
    
    int[] c;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length < 1)
            return ans;
        Arrays.sort(candidates);
        c = candidates;
        backTrack(target, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
}