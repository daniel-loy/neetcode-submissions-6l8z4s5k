// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/generate-parentheses/

// Video Solution: https://www.youtube.com/watch?v=VzMyeCMLdPI

// **************** Java Solution ***********************


class Solution {
    public List<String> generateParenthesis(int n) {

       List<String> ans = new ArrayList();
       backtrack(ans, "", 0,0,n);
       return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if(cur.length()==max*2){
            ans.add(cur);
            return;
        }

        if(open<max){
            backtrack(ans, cur+"(", open+1, close, max);
        }
        if(close<open){
            backtrack(ans, cur+")", open, close+1, max);
        }
    }
}