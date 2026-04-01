class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            int freqcount = map.getOrDefault(t.charAt(i),0);
            map.put(t.charAt(i),freqcount+1);        
            }
        HashMap<Character,Integer> freq = new HashMap<>();
        int start=0;
        int end=0;
        int length=0;
        String max=s;
	    Boolean contains = false;
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return "";
        }    
        while(end<s.length() && !map.containsKey(s.charAt(end))){
            start++;
            end++;
        }


        while(end<s.length() || length>=t.length()){
            if(length==t.length()){
                String currentString = s.substring(start,end);
                if(currentString.length() <= max.length()){
		    contains=true;
                    System.out.println(currentString);
                    max=currentString;
                }
                freq.put(s.charAt(start),freq.getOrDefault(s.charAt(start),0)-1);
                if(freq.getOrDefault(s.charAt(start),0)<map.getOrDefault(s.charAt(start),0)){
                    length=length-1;
                }
                start++;
                while(start<end && !map.containsKey(s.charAt(start))){
                    start++;
                }
            }
            else{
                if(map.containsKey(s.charAt(end)) && freq.getOrDefault(s.charAt(end),0)<map.get(s.charAt(end)) ){
                    System.out.println(start+" "+end);
                    length++;
                }
                freq.put(s.charAt(end),freq.getOrDefault(s.charAt(end),0)+1);
                end++;
            }
        }

	if(contains){
        return max;
	}
	else{
	return "";
	}

    }
}

