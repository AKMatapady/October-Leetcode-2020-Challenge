class Solution {
    
    // private long get(int n)
    // {
    //     long v = (long)n+1;
    //     return ((v*(v+1))/2);
    // }
    
    //int MAX = 101;
    
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured <= 0)
            return 0.0;
        
        
        // if(poured >= get(query_row))
        //     return 1.0;
        // if(poured <= get(query_row-1))
        //     return 0.0;
        // int val = (int)(poured - get(query_row-1));
        
        double[][] p = new double[query_row+1][query_row+1];
        p[0][0] = (double)poured;
        
        for(int i = 0; i < query_row; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                double q = (p[i][j] - 1)/2;
                if(q > 0)
                {
                    p[i+1][j] += q;
                    p[i+1][j+1] += q;
                }
            }
        }
        return Math.min(1.0, p[query_row][query_glass]);
    }
}