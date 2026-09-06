class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] num = new int[26];
        for(int i=0;i<s1.length();i++){
        num[s1.charAt(i)-'a']=num[s1.charAt(i)-'a']+1;
        }

        int left=0;
        int right=0;
        int count=0;
        while(right<=s2.length()-1){
            if(num[s2.charAt(right)-'a']>0){
                num[s2.charAt(right)-'a'] = num[s2.charAt(right)-'a'] -1;
                System.out.println("left : "+s2.charAt(left)+" right : "+s2.charAt(right));
                count++;
                right++;
                if(count==s1.length()){
                    return true;
                }
            }
            else{
                if(count==0){
                    right++;
                    left++;
                    continue;
                }
                num[s2.charAt(left)-'a'] = num[s2.charAt(left)-'a']+1;
                left++;
                count--;
            }
        }

        return false;
    }
}
