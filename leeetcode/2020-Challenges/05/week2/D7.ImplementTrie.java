

class Trie {
    HashMap<Character,HashMap> trie;
    /** Initialize your data structure here. */
    public Trie() {
        trie = new HashMap<Character,HashMap>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        recursiveInsert(word, trie);
    }
    
    public void recursiveInsert(String word, HashMap<Character,HashMap> trie){
        //System.out.println("here " + word);
        if(word.equals("")){
            //System.out.println("here exit condition " + word);
            trie.put('.',null);
            return;
        }
        char c  = word.charAt(0);
        HashMap<Character,HashMap> currentHead;
        if(trie.containsKey(c)){
            currentHead = trie.get(c);
        }else{
            HashMap<Character,HashMap> trieNode = new HashMap();
            trie.put(c, trieNode);
            currentHead = trieNode;
        }
        recursiveInsert(word.substring(1), currentHead);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        HashMap<Character,HashMap> head = trie;
        System.out.print("word to find " + word + "\n");
        for(int i = 0; i < word.length(); i++){
            char c  = word.charAt(i);
            System.out.print(c);
            if(head.get(c) == null){
                return false;
            }else{
                head = head.get(c);
            }
        }
        System.out.println("\n");
        //System.out.println("contiene fin de palabra? " + head.containsKey('.'));
        return head.containsKey('.');
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        HashMap<Character,HashMap> head = trie;
        
        for(int i = 0; i < prefix.length(); i++){
            char c  = prefix.charAt(i);
            if(head.get(c) == null){
                return false;
            }else{
                head = head.get(c);
            }
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