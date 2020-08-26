/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
*/

class Solution {
    func backspaceCompare(_ S: String, _ T: String) -> Bool {
        var ars = Array(S)
        var art = Array(T)

        var i = ars.count - 1
        var j = art.count - 1
        
        var skipS = 0
        var skipT = 0
        
        while i >= 0{
            while i >= 0 { // Find position of next possible char in build(S)
                if ars[i] == "#" {
                    skipS += 1
                    i -= 1
                }
                else if skipS > 0 {
                    skipS -= 1
                    i -= 1
                }else {
                    break
                }
            }
            while j >= 0{
                if art[j] == "#"{
                    skipT += 1
                    j -= 1
                }else if skipT > 0 {
                    skipT -= 1
                    j -= 1
                }else{
                    break
                }
                
            }
            print(art[j])
            print(ars[i])
            i -= 1
            j -= 1
        }
        
        
        return false
    }
}