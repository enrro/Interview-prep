func kthLargestElement(nums: [Int], k: Int) -> Int {
    var nums2 = nums.sorted()
    
    return nums2[nums2.count - k]
    
}
