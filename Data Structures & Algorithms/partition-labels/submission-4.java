class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> list =  new ArrayList<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int left = 0;
        int right = 0;
        int starting = 0;
        while(left<s.length() && right<s.length()){

            if(map.get(s.charAt(left))>0){
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                right++;
            }
            else if(left != right){
                left++;
            }

            if(left == right){
                System.out.println(left);
                list.add(right-starting);
                starting = left;
            }
        }
                list.add(right-starting);
return list;

    }
}
