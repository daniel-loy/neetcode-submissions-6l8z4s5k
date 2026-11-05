

class Solution {

    int[] status = new int[26];
    StringBuilder result = new StringBuilder();

    HashMap<Character, List<Character>> map = new HashMap<>();

    public String foreignDictionary(String[] words) {

        // Initialize graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new ArrayList<>());
            }
        }

        // Build graph
        for (int i = 0; i < words.length - 1; i++) {

            String first = words[i];
            String second = words[i + 1];

            // Invalid prefix
            if (first.length() > second.length()
                    && first.startsWith(second)) {
                return "";
            }

            int len = Math.min(first.length(), second.length());

            for (int j = 0; j < len; j++) {

                char u = first.charAt(j);
                char v = second.charAt(j);

                if (u != v) {
                    if (!map.get(u).contains(v)) {
                        map.get(u).add(v);
                    }
                    break;
                }
            }
        }

        // DFS
        for (char key : map.keySet()) {

            if (status[key - 'a'] == 0) {

                if (!dfs(key)) {
                    return "";
                }
            }
        }

        return result.reverse().toString();
    }

    public boolean dfs(char key) {

        int index = key - 'a';

        // Cycle detected
        if (status[index] == 1) {
            return false;
        }

        // Already processed
        if (status[index] == 2) {
            return true;
        }

        status[index] = 1;

        for (char neighbour : map.get(key)) {

            if (!dfs(neighbour)) {
                return false;
            }
        }

        status[index] = 2;

        result.append(key);

        return true;
    }
}
