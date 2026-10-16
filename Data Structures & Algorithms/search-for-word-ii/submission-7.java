class Solution {
    List<String> list = new ArrayList<>();
    public class Word{
        boolean wordend;
        String currentword;
        boolean isadded;
        HashMap<Character,Word> map = new HashMap<>();
    }
    Word word;
    public List<String> findWords(char[][] board, String[] words) {
        word = new Word();

        for(String str : words){
            dfs(word,str,0);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.map.containsKey(board[i][j])){
                  dfsfindword(word.map.get(board[i][j]),board,i,j);
                }
            }
        }
        return list;
    }

    public void dfs(Word word,String str,int index){
        if(index == str.length()){
            word.currentword = str;
            word.wordend = true;
            return;
        }
        char letter = str.charAt(index);
        if(!word.map.containsKey(letter)){
            word.map.put(letter,new Word());
        }
        dfs(word.map.get(letter),str,index+1);
    }

    public void dfsfindword(Word word,char[][] board,int i,int j){

        char currentchar = board[i][j];

        if(word.wordend && !word.isadded){
            list.add(word.currentword);
            word.isadded = true;
        }

        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};
        board[i][j] = '#';

        for(int k=0;k<4;k++){
            int newrow = row[k]+i;
            int newcol = col[k]+j;

            if(newrow<0 || newcol<0 || newrow>=board.length || newcol>=board[0].length || board[newrow][newcol]=='#' || !word.map.containsKey(board[newrow][newcol])){
                continue;
            }
            dfsfindword(word.map.get(board[newrow][newcol]),board,newrow,newcol);
        }

        board[i][j] = currentchar;
    }
}
