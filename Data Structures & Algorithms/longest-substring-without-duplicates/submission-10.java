
class Solution {
    public int lengthOfLongestSubstring(String s) {
	if(s.length()==0){
		return 0;
	}
    if(s.length()==1){
        return 1;
    }
	int start = 0;
	int max = Integer.MIN_VALUE;
    HashMap<Character,Integer> map = new HashMap<>();
	for(int i=0;i<s.length();i++){
        if(s.charAt(i)==' '){
            return 1;
        }
	   if(map.containsKey(s.charAt(i)) &&  map.get(s.charAt(i)) == 1){
		max = Math.max(max,i-start);
		while(s.charAt(i) != s.charAt(start)){
			map.put(s.charAt(start),0);
			start++;
		}
		start++;

	   }
	   else{
		map.put(s.charAt(i),1);
	   }

	}
    max = Math.max(max,s.length()-start);

	return max == Integer.MIN_VALUE?1:max;
    }
}