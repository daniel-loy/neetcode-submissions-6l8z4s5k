class Solution {
    public String minWindow(String s, String t) {


        HashMap<Character,Integer> tmap = new HashMap<>();
        HashMap<Character,Integer> smap =new HashMap<>();
        for(int i=0;i<t.length();i++){
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        }
        int[] ans = {-1,0,0};
        int i=0;
        int j=0;
        int unique=0;
        
        while(j<s.length())
        {
            smap.put(s.charAt(j),smap.getOrDefault(s.charAt(j),0)+1);

            if(tmap.containsKey(s.charAt(j)) && tmap.get(s.charAt(j)) == smap.get(s.charAt(j)) ){
                unique++;

            }

            while(i<=j && unique == tmap.size()){
                if(ans[0]==-1){
                    ans[0]=j-i+1;
                }
                if(j-i+1 <= ans[0] ){
                    ans[0]=j-i+1;
                    ans[1]=i;
                    ans[2]=j;
                }
            smap.put(s.charAt(i),smap.get(s.charAt(i))-1);

            if(tmap.containsKey(s.charAt(i)) && tmap.get(s.charAt(i)) > smap.get(s.charAt(i))){
                unique--;
            }
            i++;
            }
        j++;
        }

        if(s.length()<t.length() || ans[0]==-1 ){
            return "";
        }
        return s.substring(ans[1],ans[2]+1);
    }
}
