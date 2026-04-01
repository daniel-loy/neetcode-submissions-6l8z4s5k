class Solution {
    List<List<String>> result = new ArrayList<>();
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        dfs(0,n);
        return result;
    }

    public void dfs(int row,int n){
        if(row>=n){
            constructResult();
            return;
        }
        
            for(int j=0;j<n;j++){
                int k = row;
                int m = j;
                boolean isvalid = true;


                while(k>=0 && m>=0){
                    if(board[k][m]=='Q'){
                        isvalid = false;
                        break;
                    }
                    k--;
                    m--;
                }
                if(!isvalid){
                    continue;
                }

                k = row;
                m = j;
                while(k>=0 && m<n){
                    if(board[k][m]=='Q'){
                        isvalid = false;
                        break;
                    }
                    k--;
                    m++;
                }

                if(!isvalid){
                    continue;
                } 
                k=row;
                m=j;
                while(k>=0){
                    if(board[k][m]=='Q'){
                        isvalid = false;
                        break;
                    } 
                    k--;
                }

                if(!isvalid){
                    continue;
                } 

                board[row][j] = 'Q';
                dfs(row+1,n);
                board[row][j] = '.';

            }
    }

    public void constructResult()
    {
        List<String> list = new ArrayList<>();
        for(char[] row : board){
        String str = new String(row);  
            list.add(str);
        }

        result.add(list);
    }
}
