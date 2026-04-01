class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        if(strs.size()==0 ){
            return Character.toString((char)258);
        }

                String separate = Character.toString((char)257);

        for(String list : strs){
                str.append(list);
                str.append(separate);
        }
        str.deleteCharAt(str.length() - 1);
        System.out.println(str);
        return str.toString();
    }

    public List<String> decode(String str) {
        if(str.equals(Character.toString((char)258))){
            return new ArrayList();
        }
        String separate = Character.toString((char)257);
         return Arrays.asList(str.split(separate, -1));


    }
}
