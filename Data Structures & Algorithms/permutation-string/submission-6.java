class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length()<s1.length()){
            return false;
        }
        int[] arr = new int[26];
        int[] calarr =  new int[26];
        int i=0;
        for(int k=0;k<s1.length();k++){
            arr[s1.charAt(k)-'a']+=1;
            calarr[s2.charAt(k)-'a']+=1;
        }
        for(int j=s1.length();j<s2.length();j++){

            if(Arrays.equals(arr,calarr)){
                return true;
            }
            else{
                calarr[s2.charAt(i)-'a']-=1;
                i++;
            }
            calarr[s2.charAt(j)-'a']+=1;
        }
        if(Arrays.equals(arr,calarr)){
            return true;
        }
        return false;
    }
}
