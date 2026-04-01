class Solution {
    List<String> list =  new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n,0,0,"");
        return list;
    }

    public void dfs(int n,int open,int close,String result){
        if(open > n){
            return;
        }
        if(close>open){
            return;
        }
        if(open == n && close==n){
            list.add(result);
            return;
        }
        dfs(n,open+1,close,result+"(");
        dfs(n,open,close+1,result+")"); 
    }
}
