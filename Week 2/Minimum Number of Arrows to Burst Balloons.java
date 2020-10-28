class Solution {
    public int findMinArrowShots(int[][] points) {
        int ans = 0;
        if(points == null || points.length < 1)
            return ans;
        
        Arrays.sort(points, (int[] a, int[] b) -> {
           if(a[0] < b[0]) 
               return -1;
            if(a[0] > b[0])
                return 1;
            if(a[1] < b[1])
                return -1;
            if(a[1] > b[1])
                return 1;
            return 0;
        });
        
        int start = points[0][0], end = points[0][1];
        ans++;
        
        for(int i = 1; i < points.length; i++)
        {
            if((start >= points[i][0] && start <= points[i][1]) || (end >= points[i][0] && end<=points[i][1]) || (start <= points[i][0] && end >= points[i][1]))
            {
                start = Math.max(start, points[i][0]);
                end = Math.min(end, points[i][1]);
            }
            else
            {
                ans++;
                start = points[i][0];
                end = points[i][1];
            }
        }
        
        return ans;
    }
}