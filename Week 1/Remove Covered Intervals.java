class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> {
           if(a[0] > b[0]) 
               return 1;
            if(a[0] < b[0])
                return -1;
            if(a[1] > b[1])
                return -1;
            if(b[1] > a[1])
                return 1;
            return 0;
        });
        int ans = 0, prev = 0;
        
        for(int[] x: intervals)
        {
            if(prev < x[1])
            {
                ans++;
                prev = x[1];
            }
        }
        return ans;
    }
}