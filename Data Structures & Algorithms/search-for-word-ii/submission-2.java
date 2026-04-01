
class Solution {
    
    // Using a simpler name (TrieNode) for convention
    class TrieNode {
        boolean isEnd = false;
        String word = "";
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }

        // isContains and getChild are correctly implemented
        public boolean isContains(char c) {
            return children[c - 'a'] != null;
        }

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }
        
        // Helper method to set a new node (used only when we know it's null)
        public void setNode(char c) {
            children[c - 'a'] = new TrieNode();
        }
    }
    
    private final int[] rowOffset = {-1, 0, 1, 0};
    private final int[] colOffset = {0, 1, 0, -1};
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        List<String> result = new ArrayList<>();
        
        // 1. BUILD THE TRIE (Trie construction logic corrected to use setNode)
        for(String word : words){
            TrieNode current = root;
            for(char c : word.toCharArray()){
                if(!current.isContains(c)){
                    current.setNode(c); // Use the helper that does NOT overwrite
                }
                current = current.getChild(c);
            }
            current.isEnd = true;
            current.word = word;
        }

        // 2. START DFS FROM EVERY CELL (Corrected starting point)
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                char firstChar = board[r][c];
                if(root.isContains(firstChar)){
                    // CRITICAL FIX: Pass the child node, not the root
                    backtrack(r, c, board, result, root.getChild(firstChar));
                }
            }
        }

        return result;
    }

    // Simplified backtrack signature by using board itself for 'visited'
    public void backtrack(int r, int c, char[][] board, List<String> result, TrieNode node){
        
        // 1. Found Word Logic (CRITICAL FIX: Mark as collected)
        if(node.isEnd){
            result.add(node.word);
            node.isEnd = false; // Stop duplicates
        }
        
        // 2. Mark cell as visited
        char originalChar = board[r][c];
        board[r][c] = '#'; 
        
        // 3. Explore Neighbors
        for(int i = 0; i < 4; i++){
            int newR = r + rowOffset[i];
            int newC = c + colOffset[i];
            
            if(newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length && board[newR][newC] != '#'){
                
                char nextChar = board[newR][newC];
                
                if(node.isContains(nextChar)){
                    // Pass the correct NEXT node
                    backtrack(newR, newC, board, result, node.getChild(nextChar));
                }
            }
        }
        
        // 4. Backtrack: Restore the cell
        board[r][c] = originalChar;
    }
}