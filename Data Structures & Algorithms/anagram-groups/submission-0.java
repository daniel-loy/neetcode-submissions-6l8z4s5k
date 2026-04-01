class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        List<String> listName = new ArrayList<>();
        List<List<String>> outerList = new ArrayList<>();


        for(String str:strs){
            int arr[] = new int[26];
            for(int i=0;i<str.length();i++){
                arr[str.charAt(i)-'a']++;
            }
            String arraystring=Arrays.toString(arr);           
            if(map.containsKey(arraystring)){
                map.get(arraystring).add(str);
            }
            else{
                map.put(arraystring, new ArrayList<>());
                map.get(arraystring).add(str);
            }
        }
        for(List<String> value:map.values()){
            outerList.add(value);
        }
        return outerList;
    }
}
