class Solution {
    public int ladderLength(String beginWord, String endWord,
                            List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern =
                    word.substring(0, i) + "*" + word.substring(i + 1);

                map.computeIfAbsent(pattern, k -> new ArrayList<>())
                   .add(word);
            }
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                String current = queue.poll();

                if (current.equals(endWord)) {
                    return length;
                }

                for (int i = 0; i < current.length(); i++) {
                    String pattern =
                        current.substring(0, i) + "*"
                        + current.substring(i + 1);

                    // Retrieve and remove: process each pattern only once.
                    List<String> neighbors = map.remove(pattern);

                    if (neighbors == null) {
                        continue;
                    }

                    for (String next : neighbors) {
                        if (visited.add(next)) {
                            queue.offer(next);
                        }
                    }
                }
            }

            length++;
        }

        return 0;
    }
}