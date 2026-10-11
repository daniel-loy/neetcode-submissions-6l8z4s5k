class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0,0,n,"");
        return list;
    }

    public void dfs(int n,int m,int k,String param){
        if(m>n){
            return;
        }

        if(m==k && n==k){
            list.add(param);
            return;
        }

        if(n<k){
            dfs(n+1,m,k,param+"(");
        }

        if(m<k){
            dfs(n,m+1,k,param+")");
        }
    }
}
