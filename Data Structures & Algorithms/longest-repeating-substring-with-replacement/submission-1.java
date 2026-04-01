class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max=0;
        int maxlength=0;
        while(j<s.length()){
                System.out.println(i+"->"+j+" "+max+" "+maxlength);
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            
                if(max<map.get(s.charAt(j))){
                    max=map.get(s.charAt(j));
                    maxlength=j-i+1;
                }
                if(k<((j-i+1)-max)){
                   map.put(s.charAt(i),map.get(s.charAt(i))-1);
                   i++;
                }
                j++; 
        }
       if(maxlength<j-i){
        maxlength=j-i;
       }

        return maxlength;
    }
}

