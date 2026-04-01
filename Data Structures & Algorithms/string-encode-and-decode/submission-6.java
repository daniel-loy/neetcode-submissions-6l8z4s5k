class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0){
            return "";
        }
        String seperator = Character.toString((char) 257);
        String result = String.join(seperator,strs);
        return result;
    }

    public List<String> decode(String str) {
            String seperator = Character.toString((char) 257);
            if(str == ""){
                return new ArrayList<>();
            }
            String[] arr = str.split(seperator);
            List<String> list =Arrays.asList(arr);
            return list;
    }
}
