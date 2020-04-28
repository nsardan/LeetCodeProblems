package com.learning.arrays.binarysearch;

public class MountainArrayBinarySearch {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int length = mountainArr.length();
        int left = 0,right = length -1;

        int middle = 0;
        int peak = 0;
        while(left < right){
            middle = (left + right)/2;
            if(mountainArr.get(middle) < mountainArr.get(middle +1)){
                left = middle +1;
                peak = left;
            }else{
                right = middle;
            }
        }

        left = 0;
        right = peak;
        while(left <= right){
            middle = (left + right)/2;
            int key = mountainArr.get(middle);
            if(key < target){
                left = middle +1;
            }else if(key > target){
                right = middle - 1;
            }else{
                return middle;
            }
        }

        left = peak;
        right = length -1;
        while(left <= right){
            middle = (left + right)/2;
            int key = mountainArr.get(middle);
            if(key > target){
                left = middle+1;
            }else if(key < target) right = middle -1;
            else return middle;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,3,1};
        int target = 3;
        MountainArrayBinarySearch main = new MountainArrayBinarySearch();
    }
}

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

interface MountainArray{
    public int get(int index);

    public int length();
}