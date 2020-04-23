package com.learning.arrays.binarysearch;

public class SearchInRotatedSortedArray {

    /*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
     */
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int low = 0;
        int high = nums.length -1;

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target) return mid;
                //left array
            else if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]) high = mid -1;
                else low = mid +1;
            }else{
                if(target > nums[mid] && target <= nums[high]) low = mid +1;
                else high = mid -1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }


}