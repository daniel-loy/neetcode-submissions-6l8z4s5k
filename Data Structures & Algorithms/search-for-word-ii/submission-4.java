class Solution {
    class tier{
        boolean isEnd = false;
        String word = "";
        tier[] tierarray;
        public tier(){
            tierarray = new tier[26];
        }

        public void insertarray(char c){
            tierarray[c-'a'] = new tier();
        }

        public boolean iscontains(char c){
            return tierarray[c-'a'] != null;
        }

        public tier gettier(char c){
            return tierarray[c-'a'];
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        tier tierroot = new tier();
        for(int i=0;i<words.length;i++){
            tier currenttier = tierroot;
            for(int j=0;j<words[i].length();j++){
                if(!currenttier.iscontains(words[i].charAt(j))){
                    currenttier.insertarray(words[i].charAt(j));
                }
                currenttier = currenttier.gettier(words[i].charAt(j));
            }
            currenttier.isEnd = true;
            currenttier.word = words[i];
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> result = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(tierroot.iscontains(board[i][j])){
                    backtrack(i,j,board,result,tierroot.gettier(board[i][j]),visited);
                }
            }
        }

        return result;
    }

    public void backtrack(int row,int col,char[][] board,List<String> result,tier currenttier,boolean[][] visited){
        if(currenttier == null){
            return;
        }
        if(currenttier.isEnd){
            result.add(currenttier.word);
            currenttier.isEnd = false;
        }

        int[] rowoffset = {-1,0,1,0};
        int[] coloffset = {0,1,0,-1};

        visited[row][col] = true;

        for(int i=0;i<4;i++){
            if(row+rowoffset[i]<0 || col+coloffset[i]<0 || row+rowoffset[i]>=board.length || col+coloffset[i]>=board[0].length || !currenttier.iscontains(board[row+rowoffset[i]][col+coloffset[i]]) || visited[row+rowoffset[i]][col+coloffset[i]]){
                continue;
            }
            backtrack(row+rowoffset[i],col+coloffset[i],board,result,currenttier.gettier(board[row+rowoffset[i]][col+coloffset[i]]),visited);
        }

         visited[row][col] = false;
    }
}
