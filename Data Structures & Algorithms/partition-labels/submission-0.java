class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int index = map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i),i);
        }
        String substring= "";
        int maxindex = 0;
        for(int i=0;i<s.length();i++){
            int index = map.get(s.charAt(i));
            System.out.println(index);
            maxindex = Math.max(maxindex,index);
            substring+=s.charAt(i);
            if(maxindex==i){
                list.add(substring.length());
                substring="";
            }
        }
        return list;
    }
}
