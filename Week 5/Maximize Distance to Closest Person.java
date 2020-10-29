class Solution {
    public int maxDistToClosest(int[] seats) {
        if(seats == null || seats.length < 2)
            return 0;
        int max = 1, prev = 0;
        boolean found = false;
        for(int i = 0; i < seats.length; i++)
        {
            
            if(seats[i] == 1)
            {
                if(!found && (i - prev) > max)
                    max = i - prev;
                else if(found && ((i - prev)/2) > max)
                    max = (i-prev)/2;                        
                prev = i;
                found = true;
            }
        }
        
        if(prev < seats.length-1 && (seats.length-1-prev) > max)
            max = (seats.length-1-prev);
            
        
        return max;
    }
}