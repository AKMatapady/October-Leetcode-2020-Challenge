class Solution {
    public int bitwiseComplement(int N) {
        String b = Integer.toBinaryString(N);
        StringBuilder sb = new StringBuilder();
        for(char ch: b.toCharArray())
        {
            if(ch == '0')
                sb.append("1");
            else
                sb.append("0");
        }
        int d = Integer.parseInt(sb.toString(), 2);
        return d;
    }
}