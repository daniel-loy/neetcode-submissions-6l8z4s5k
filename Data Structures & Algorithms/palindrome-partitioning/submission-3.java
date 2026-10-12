class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0,new ArrayList<>());
        return result;
    }

    public void dfs(String s,int index,List<String> list){
        if(index>s.length()-1){
        result.add(new ArrayList<>(list));            
        return;
        }

        for(int i=index;i<s.length();i++){
            if(validatePalindrome(s.substring(index,i+1))){
                list.add(s.substring(index,i+1));
                dfs(s,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean validatePalindrome(String str){
        int start = 0;
        int end = str.length()-1;
        while(start < end){
            if(str.charAt(start) != str.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
