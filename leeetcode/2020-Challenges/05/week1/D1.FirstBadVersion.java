/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
*/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //System.out.println(n);
        //System.out.println(binarySearch(0, n));
        return binarySearch(0, n);
    }
    
    public int binarySearch(int left, int right){
        if(left > right){return -1;}
        int middle = (left + right) /2;
        if(isBadVersion(middle) && middle > 0 && !isBadVersion(middle-1) || 
          isBadVersion(middle) && middle == 0){
            return middle;
        }
        if(!isBadVersion(left) && isBadVersion(middle)){
            return binarySearch(left,middle-1);
        }else{
            return binarySearch(middle+1, right);
        }
    }
}


//iterative solution.
//left + rigth / 2 could overflow so we do it this way
//we can return r or l. they are at the same position
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int middle;
        while(left < right){
            middle = left + (right - left) / 2;
            if(isBadVersion(middle)){
                right = middle;
            }else{
                left = middle + 1;
            }
            
        }
        
        return left;
    }
}

//cleaner
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
// this binary search aproach is moving the left pointer to the right until it collides
// making left moving slowly to the right until it reaches it. giving us like this the
// first element that was a false. 
// the trick is in the plus 1 to the left.
/*example
n            = 100
first defect = 4
Your stdout
left: 1 right: 50
left: 1 right: 25
left: 1 right: 13
left: 1 right: 7
left: 1 right: 4
left: 3 right: 4
left: 4 right: 4
*/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        int mid;
        while(l < r){
            mid = l + (r-l)/2;
            if(isBadVersion(mid)) r = mid;
            else l = mid + 1;
        }
        return r; // r or l are ok
    }
}

[0,0,1,1,1,1,1,1]
