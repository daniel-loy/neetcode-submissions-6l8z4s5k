class Solution {
    public int reverseBits(int n) {
        int reverse = 0;
        int current=0;
    for(int i=0;i<32;i++){
            current = n&1;
            reverse<<=1;
            reverse|=current;
            n>>=1;
        }
        return reverse;
    }
}
