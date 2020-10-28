class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if( A == null || B == null || A.length < 1 || A.length != B.length)
            return -1;
        int a1 = 0, b1 = 0, a2 = 0, b2 = 0;
        boolean aa = true, bb =true, ab = true, ba = true;
        
        for(int i = 0; i < A.length; i++)
        {
            if(aa && A[i] != A[0])
            {
                if(B[i] == A[0])
                    a1++;
                else
                    aa = false;
            }
            if(ab && A[i] != B[0])
            {
                if(B[i] == B[0])
                    a2++;
                else
                    ab = false;
            }
            if(bb && B[i] != B[0])
            {
                if(A[i] == B[0])
                    b1++;
                else
                    bb = false;
            }
            if(ba && B[i] != A[0])
            {
                if(A[i] == A[0])
                    b2++;
                else
                    ba = false;
            }
            if(!aa && !bb && !ab && !ba)
                break;
        }
        // System.out.println(aa + " " + bb + " " + ab + " " + ba);
        // System.out.println(a1 + " " + b1 + " " + a2 + " " + b2);
        int min = Integer.MAX_VALUE;
        if(aa && a1 < min)
            min = a1;
        if(ab && min > a2)
            min = a2;
        if(bb && min > b1)
            min = b1;
        if(ba && min > b2)
            min = b2;
        if(min == Integer.MAX_VALUE)
            return -1;
        return min;
        
    }
}