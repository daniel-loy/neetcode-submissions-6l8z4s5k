class Solution {
    HashMap<Character,String> map = new HashMap<>();  
    List<String> arr = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits==""){
            return arr;
        }
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> letters = new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            letters.add(map.get(digits.charAt(i)));
        }
        Combinations(letters,"",0);
        return arr;
    }

    public void Combinations(List<String> letters,String combination,int index){
            if(letters.size()==index){
                arr.add(combination);
                return;
            }
            for(int i=0;i<letters.get(index).length();i++){
                Combinations(letters,combination+letters.get(index).charAt(i),index+1);
            }
    }
}
