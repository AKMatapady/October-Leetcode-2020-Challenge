class Solution {
    public void rotate(int[] nums, int k) {
        //negative k can be handled by dding nums.length until k become positive
        if( k < 1)
            return;
        
        k = k % nums.length;
        int rotations = 0;
        for(int i = 0; rotations < nums.length; i++)
        {
            int curr = -1;
            int prev = nums[i], l = i;
            while(curr != i)
            {
                l = (l+k)%nums.length;
                int temp = nums[l];
                nums[l] = prev;
                prev = temp;
                curr = l;
                rotations++;
             }
        }
        return;
    }
}