class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];

        int start = 0;
        int end = 0;
        int max = 0;
        int result = Integer.MIN_VALUE;
        while(end<s.length()){
            int c = s.charAt(end);
            arr[c-'A']+=1;
            max = Math.max(arr[c-'A'],max);
            if(end-start-max+1>k){
                System.out.println(max);
                result = Math.max(result,end-start);
                arr[s.charAt(start)-'A']--;
                start++;
            }
            end++;
        }
        
        result = Math.max(result,end-start);

        return result;
    }
}
