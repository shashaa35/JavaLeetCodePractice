package leetcode;

//https://leetcode.com/problems/search-a-2d-matrix
public class searchMatrix {
    int findJustSmallerIndexCol(int[][] matrix, int target) {
        int low = 0, high = matrix.length;
        while( high-low > 1 ) {
            int med = low + (high-low)/2;
            if(target < matrix[med][0]) {
                high = med;
            } else if(target > matrix[med][0]) {
                low = med;
            } else {
                return med;
            }
        }
        return low;
    }

    boolean binarySearchElement(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        while(low <= high) {
            int med = low + (high-low)/2;
            if(target < arr[med]) {
                high = med-1;
            } else if(target > arr[med]) {
                low = med+1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findJustSmallerIndexCol(matrix, target);
        return binarySearchElement(matrix[row], target);
    }
}
