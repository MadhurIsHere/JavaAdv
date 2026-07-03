class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        if(dividend==Integer.MIN_VALUE && divisor==1) return Integer.MIN_VALUE;
        boolean negative=(dividend<0)^(divisor<0);

        long divd=Math.abs((long) dividend);
        long divs=Math.abs((long) divisor);

        int quotent=0;
        while(divd>=divs)
        {
            divd-=divs;
            quotent++;
        }

        return negative? -quotent : quotent;
    }
}