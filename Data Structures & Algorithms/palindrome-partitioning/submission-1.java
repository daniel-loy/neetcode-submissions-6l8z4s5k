class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0);
        return result;
    }

    public void dfs(String s,int index){

        if(s.length() == index){
            result.add(List.copyOf(list));
            return;
        }

        String str = "";

        for(int i=index;i<s.length();i++){
            str+=s.charAt(i);
            if(checkpalindrome(str)){
            list.add(str);
            dfs(s,i+1);
            list.remove(list.size()-1);
            }
        }
    }

    public Boolean checkpalindrome(String str){
        int start = 0;
        int end = str.length()-1;
        while(start<end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
