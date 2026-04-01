class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), i);
        }
        int startindex= 0;
        int maxindex = 0;
        for(int i=0;i<s.length();i++){
            int index = map.get(s.charAt(i));
            maxindex = Math.max(maxindex,index);
            if(maxindex==i){
                list.add(i-startindex+1);
                startindex=i+1;
            }
        }
        return list;
    }
}
