class Solution {
    int result=0;
    public int climbStairs(int n) {
        cal(n,0,0);
        return result;
    }

    public void cal(int n,int index,int totalcount){
        if(totalcount>n){
            return;
        }
        if(totalcount==n){
            result++;
            return;
        }
        int num=totalcount;
        
        for(int j=0;j<2;j++){
            num++;
            cal(n,index+1,num);
        }
        
    }
}
