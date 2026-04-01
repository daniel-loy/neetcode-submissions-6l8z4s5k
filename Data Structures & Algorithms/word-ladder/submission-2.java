class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String word : wordList){
            for(int i=0;i<word.length();i++){
                String str = word.substring(0,i)+"*"+word.substring(i+1);
                List<String> list = map.getOrDefault(str,new ArrayList<>());
                list.add(word);
                map.put(str,list);
            }
        }

        Queue<Pair<String,Integer>> queue = new LinkedList<>();

        queue.offer(new Pair<>(beginWord,1));

        HashSet<String> visited = new HashSet<>();

        visited.add(beginWord);

        while(!queue.isEmpty()){
            Pair<String, Integer> poped = queue.poll();
            String key = poped.getKey();
            int value = poped.getValue();

            System.out.println(key);
            for(int i=0;i<key.length();i++){
                String str = key.substring(0,i)+"*"+key.substring(i+1);
                if(map.containsKey(str)){
                    for(String listString : map.get(str)){
                        if(endWord.equals(listString)){
                            return value+1;
                        }
                        if(!visited.contains(listString)){
                            visited.add(listString);
                        queue.offer(new Pair<>(listString,value+1));
                        }
                    }
                }
            }
        }


        return 0;
    }

    class Pair<K,V>{
        K key;
        V value;

        public Pair(K k,V v){
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }
    
        public V getValue() {
            return value;
        }
    }
}
