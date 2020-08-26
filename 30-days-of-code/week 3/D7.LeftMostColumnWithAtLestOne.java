/*
(This problem is an interactive problem.)

A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
*/

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        if(binaryMatrix == null) return -1;
        List<Integer> ld = binaryMatrix.dimensions();
        int row = ld.get(0);
        int col = ld.get(1);
        System.out.println(" row: " + row + " col: " + col );
        
        // by default not found
        int minPositionValue = -1;
        int result = col; 
        for(int  i = 0; i < row;i++ ){
            result = binarySearchLeftMost(binaryMatrix,i, 0, result - 1);
            System.out.println(result);
            if(result == 0) return 0;
            if(result > minPositionValue && minPositionValue == -1){
                minPositionValue = result;
            }
            else if(result < minPositionValue && result != -1){
                minPositionValue = result;
            }
            if(result == -1){
                if(minPositionValue == -1){
                    result = col;
                }
                else{
                    result = minPositionValue;
                }
            }
            
        }
        return minPositionValue;
    }
    
    public int binarySearchLeftMost(BinaryMatrix binaryMatrix,int row, int left, int right){
        if(left > right){
            return -1;
        }
        int middle  = (left + right)/ 2;
        int middleValue = binaryMatrix.get(row, middle);
        if((middleValue == 1 && middle == 0) ||
           (middleValue == 1 && binaryMatrix.get(row, middle - 1) == 0)){
            return middle;
        }
        else{
            if(middleValue == 0){ // since is cero it means that the ones are to the right
                 return binarySearchLeftMost(binaryMatrix,row, middle + 1, right);
            }else{ //  since is one it means that the largest is on the left
                return binarySearchLeftMost(binaryMatrix, row, left, middle - 1);
            }
        }
    }
    
}


