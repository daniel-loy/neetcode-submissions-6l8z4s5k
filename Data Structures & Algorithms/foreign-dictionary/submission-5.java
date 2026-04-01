class Solution {
      HashMap<Character,List<Character>> map = new HashMap<>();
      HashMap<Character,Boolean> seen = new HashMap<>();
      StringBuilder result = new StringBuilder();
    public String foreignDictionary(String[] words) {
      for(String word : words){
        for(char str : word.toCharArray()){
            map.put(str,new ArrayList<>());
        }
      }

      for(int i=0;i<words.length-1;i++){
        if(words[i].length()>words[i+1].length() && words[i].startsWith(words[i+1])){
            return "";
        }
        for(int j=0;j<words[i].length();j++){
            if(words[i].charAt(j)!=words[i+1].charAt(j)){
                map.get(words[i+1].charAt(j)).add(words[i].charAt(j));
                break;
            }
        }
      }

      for(char key : map.keySet()){
            if(!dfs(key)){
                return "";
            }
      }
      return result.toString();
    }

    public boolean dfs(char key){

        if(seen.containsKey(key) && seen.get(key)){
            return true;
        }

        if(seen.containsKey(key) && !seen.get(key)){
            return false;
        }

        seen.put(key,false);

        for(char val : map.get(key)){
            if(!dfs(val)){
                return false;
            }
        }

        seen.put(key,true);

        result.append(key);

        return true;
    }
}
