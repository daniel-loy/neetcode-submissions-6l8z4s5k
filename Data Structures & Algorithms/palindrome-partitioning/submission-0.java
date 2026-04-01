class Solution {
    List<List<String>> arr =new ArrayList<>();
    public List<List<String>> partition(String s) {
        palindrome(s,0,new ArrayList<>());
        return arr;
    }

    public void palindrome(String s,int index,List<String> list){
        if(index == s.length()){
            arr.add(new ArrayList<>(list));
            return;
        }
        String combination="";
        for(int i=index;i<s.length();i++){
            combination=combination+s.charAt(i);
            if(validatePalindrome(combination)){
            list.add(combination);
            palindrome(s,i+1,list);
            list.remove(list.size()-1);
            }
        }
    }

    public boolean  validatePalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
