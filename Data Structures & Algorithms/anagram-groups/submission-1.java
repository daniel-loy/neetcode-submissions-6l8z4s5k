class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            List<String> listarr = map.getOrDefault(sorted,new ArrayList<>());
            listarr.add(s);
            map.put(sorted,listarr);
        }

        for(List<String> l : map.values()){
            list.add(l);
        }

        return list;
    }
}
