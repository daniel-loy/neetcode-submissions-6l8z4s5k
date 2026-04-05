class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);        
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        int lasttrue = 0;
        for(int i=1;i<s.length()+1;i++){
            for(int j=lasttrue+1;j>=0;j--){
                if(set.contains(s.substring(j,i)) && dp[j]){
                    dp[i]=true;
                    lasttrue = i;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
