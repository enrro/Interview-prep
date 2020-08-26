class Solution {
    func fizzBuzz(_ n: Int) -> [String] {
        var list:[String] = []
        
        for i in 1..<n+1{
            if i % 15 == 0{
                list.append("FizzBuzz")
            }
            else if i % 3 == 0{
                list.append("Fizz")
            }
            else if i % 5 == 0{
                list.append("Buzz")
            }else{
                list.append(i.description)
            }
        }
        return list
    }
}