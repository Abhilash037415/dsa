class Solution {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        for(int i=5;i<=n;n/=5)  zeroCount+= n/5;
        return zeroCount;
    }
}