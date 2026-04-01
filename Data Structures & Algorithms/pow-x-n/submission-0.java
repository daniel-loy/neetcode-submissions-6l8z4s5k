class Solution {
    public double myPow(double x, int n) {
        int N = n;
        if(n==0){
            return 1;
        }
        if(n<0){
            x=1/x;
            N=-1*n;
        }
        double current = x;
        double result = 1;
        while(N>0){
            if(N%2 ==1){
                result *=current;
                N=N-1;
            }
            current*=current;
            N=N/2;
        }

        return result;
    }
}
