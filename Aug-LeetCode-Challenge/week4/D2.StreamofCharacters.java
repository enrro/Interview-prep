/*
Implement the StreamChecker class as follows:

StreamChecker(words): Constructor, init the data structure with the given words.
query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 

Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 

Note:

1 <= words.length <= 2000
1 <= words[i].length <= 2000
Words will only consist of lowercase English letters.
Queries will only consist of lowercase English letters.
The number of queries is at most 40000.
https://leetcode.com/explore/featured/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3434/
*/
/*
the stream of characters keeps adding the new characters to the queue and it returns true for any part of the string that 
is present in the Trie.
example;
words. ["cd","f","kl"]
streamChecker.query('a');          // return false                                      a
streamChecker.query('b');          // return false                                      ab
streamChecker.query('c');          // return false                                      abc
streamChecker.query('d');          // return true, because 'cd' is in the wordlist      abcd
streamChecker.query('e');          // return false                                      abcde
streamChecker.query('f');          // return true, because 'f' is in the wordlist       abcdef
streamChecker.query('g');          // return false                                      abcdefg
streamChecker.query('h');          // return false                                      abcdefgh
streamChecker.query('i');          // return false                                      abcdefghi
streamChecker.query('j');          // return false                                      abcdefghij
streamChecker.query('k');          // return false                                      abcdefghijk
streamChecker.query('l');          // return true, because 'kl' is in the wordlist      abcdefghijkl

the strategy is to save the words in a data structure that keeps an easy access to the words we already know.
 and to keed a string or another data structure with the current stream of characters to compare agains the trie.
  once we reach an end of word in the trie then we are good to go.
*/
class StreamChecker {
    
    class Trie{
        public Trie[] children;
        public boolean endOfWord;
        
        public Trie(){
            endOfWord = false;
            children = new Trie[26];
        }
        
        public void insert(String s){
            Trie t = this;
            for(char c: s.toCharArray()){
                if(t.children[c-'a'] == null)
                    t.children[c-'a'] = new Trie();
                t = t.children[c-'a'];
            }
            t.endOfWord = true;
        }
        
        public boolean search(Deque<Character> s){
            Trie t = this;
            for(char c: s){
                if(t.children[c-'a'] == null) return false;
                t = t.children[c-'a'];
                if(t.endOfWord)return true;
            }
            return false;
        }
    }
    
    public Trie t = new Trie();
    // this deque helps use keep appending new characters to the queue
    public Deque<Character> stream = new LinkedList();
    
    public StreamChecker(String[] words) {
        // add the words in reverse order for them to be faster to retrieve and find in the trie.
        // because the way they are stored now you can do searches faster.
        for(String w: words){
            String rev = new StringBuilder(w).reverse().toString();
            t.insert(rev);
        }

    }
    
    public boolean query(char letter) {
        stream.addFirst(letter);
        return t.search(stream);
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */