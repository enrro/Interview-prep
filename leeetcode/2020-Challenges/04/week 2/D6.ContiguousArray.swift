class Solution {
    func findMaxLength(_ nums: [Int]) -> Int {
        var map: [Int:Int] = [0:-1]
        var maxlen = 0, count = 0
        //map[0] = -1
        
        for i in 0..<nums.count{
            count += (nums[i] == 1) ? 1 : -1
            if let value =  map[count]{
                maxlen = max(maxlen, i - value)
            } else{
                map[count] = i
            }
            print("the count \(count) \nThe position \(i)\nThe map value\(map[count]) \nThe max \(maxlen)\n")
        }
        return maxlen
    }
}