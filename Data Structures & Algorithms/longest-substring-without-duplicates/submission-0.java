class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hash = new HashSet<>();
        int i = 0;
        int j = 0;
        int max=0;
        while(j<s.length()){
            if(hash.contains(s.charAt(j))){
                max=Math.max(max,j-i);
                while(s.charAt(i)!=s.charAt(j)){
                    hash.remove(s.charAt(i));
                    i++;
                }
                i++;
                j++;
            }
            else{
                hash.add(s.charAt(j));
                j++;
            }
        }
        max=Math.max(max,j-i);
        return max;
    }
}
