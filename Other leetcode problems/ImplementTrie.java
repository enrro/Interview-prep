class Trie {
        public Trie[] children;
        public boolean endOfWord;
    /** Initialize your data structure here. */
    public Trie() {
        endOfWord = false;
        children = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie t = this;
        for(char c: word.toCharArray()){
            if(t.children[c-'a'] == null)
                t.children[c-'a'] = new Trie();
            t = t.children[c-'a'];
        }
        t.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie t = this;
        for(char c: word.toCharArray()){
            if(t.children[c-'a'] == null) return false;
            t = t.children[c-'a'];
            //if(t.endOfWord)return true;
        }
        return t.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie t = this;
        for(char c: prefix.toCharArray()){
            if(t.children[c-'a'] == null ) return false;
            t = t.children[c-'a'];
            
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */