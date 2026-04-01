class Solution {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i-1<0 && j-1<0){
                    arr[i][j]=1;
                }
                else if(i-1>=0 && j-1>=0){
                    arr[i][j]+=arr[i-1][j];
                    arr[i][j]+=arr[i][j-1];
                }
                else if(i-1>=0){
                    arr[i][j]+=arr[i-1][j];
                }
                else{
                    System.out.println(i+" "+j);
                    arr[i][j]+=arr[i][j-1];
                }
            }
        }
        return arr[m-1][n-1];
    }
}
