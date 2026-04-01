class Solution {
    List<List<String>> order = new ArrayList<>();
    char[][] arr;
    public List<List<String>> solveNQueens(int n) {
        arr = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }
        backtrackval(0,0);
        return order;
    }

    public void backtrackval(int row,int col){
        if(row == arr.length){
            List<String> list = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                String str = new String(arr[i]);
                list.add(str);
            }
             order.add(list);
             return;
        }

        while(col<arr.length){
        Boolean notpossible = true;
        for(int j=row;j>=0;j--){
            if(arr[j][col]=='Q' && notpossible){
                notpossible = false;
                continue;
            }
        }

        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(arr[i][j]=='Q' && notpossible){
                notpossible = false;
                continue;
            }

        }

        for(int i=row,j=col;i>=0 && j<arr.length;i--,j++){
            if(arr[i][j]=='Q' && notpossible){
                notpossible = false;
                continue;
            }
        }

        if(!notpossible){
            notpossible = true;
            col++;
            continue;
        }

        arr[row][col]='Q';
        backtrackval(row+1,0);
        arr[row][col]='.';
        col++;
        }

    }
}
