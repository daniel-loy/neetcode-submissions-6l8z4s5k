class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        HashMap<String, List<String>> map = new HashMap<>();
        Set<String> visited = new HashSet<>();

        // Build pattern map
        for (String str : wordList) {
            for (int i = 0; i < str.length(); i++) {
                String hashstr = str.substring(0, i) + "*" + str.substring(i + 1);
                List<String> list = map.getOrDefault(hashstr, new ArrayList<>());
                list.add(str);
                map.put(hashstr, list);
            }
        }

        int ans = dfs(beginWord, endWord, map, visited);

        return ans == -1 ? 0 : ans + 1; // +1 to count beginWord
    }

    public int dfs(String word, String endword,
                   HashMap<String, List<String>> map,
                   Set<String> visited) {

        if (word.equals(endword)) {
            return 0;
        }

        visited.add(word);  // ✅ mark visited

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < word.length(); i++) {

            String hashstr = word.substring(0, i) + "*" + word.substring(i + 1);

            if (map.containsKey(hashstr)) {

                for (String str : map.get(hashstr)) {

                    if (!visited.contains(str)) {

                        int result = dfs(str, endword, map, visited);

                        if (result >= 0) {
                            min = Math.min(min, result + 1);
                        }
                    }
                }
            }
        }

        visited.remove(word); // ✅ backtracking

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}