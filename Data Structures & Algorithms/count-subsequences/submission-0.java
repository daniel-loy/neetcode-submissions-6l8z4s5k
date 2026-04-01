class Solution {
    int totalcount = 0;
    public int numDistinct(String s, String t) {
        boolean[] dp = new boolean[s.length()];
        dps(s,t,0,0,dp,"");
        return totalcount;
    }

    public boolean dps(String s,String t,int indexs,int indext,boolean[] dp,String str){

        if(t.length() == indext ){

            System.out.println(str + " " + indexs);
            totalcount++;
            return true;
        }

        if(s.length() == indexs){
            return false;
        }

        // if(dp[indext]){
        //     return true;
        // }

        for(int i=indexs;i<s.length();i++){

            if(s.charAt(i)==t.charAt(indext)){
                if(dps(s,t,i+1,indext+1,dp,str+t.charAt(indext))){
                    dp[indext]=true;
                }
            }
        }

        return dp[indext];
    }
}
