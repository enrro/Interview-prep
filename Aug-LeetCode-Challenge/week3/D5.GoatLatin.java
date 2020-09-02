/*A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin. 

 

Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 

Notes:

S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150.
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3429/
*/

class Solution {
    public String toGoatLatin(String S) {
        String[] splited = S.split("\\s+");
        String output = "";
        for(int i = 0; i < splited.length; i++){
            String word = splited[i];
            if(isVowel(word.charAt(0))){
                word = word + "ma";
            }
            else{
                word = word.substring(1) + word.substring(0,1) + "ma";
            }
            word += "a".repeat(i+1);
            output = i == splited.length - 1 ? (output + word) : (output + word + " ");
        }
        return output;
    }
    
    public boolean isVowel(char c){
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

// minor twerks to improve efficiency
class Solution {
    public String toGoatLatin(String S) {
        String[] splited = S.split(" ");
        StringBuilder word = new StringBuilder();
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < splited.length; i++){
            word.append(splited[i]);
            if(isVowel(word.charAt(0))){
                word.append("ma");
            }
            else{
                char c = word.charAt(0);
                word.deleteCharAt(0);
                word.append(c + "ma");
            }
            word.append("a".repeat(i+1));
            if(i == splited.length - 1){
                output.append(word);
            }else{
                output.append(word + " ");
            }
            word = new StringBuilder();
        }
        return output.toString();
    }
    
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}