class Solution {
    List<String> result = new ArrayList<>();
    HashMap<Character,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return result;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");   

        dfs(digits,0,"");
        return result; 
        
    }

    public void dfs(String digits,int index,String str){
        if(index == digits.length()){
            result.add(str);
            return;
        }
        for (char chars : map.get(digits.charAt(index)).toCharArray()) {
                dfs(digits,index+1,str+chars);
        }
    }
}
