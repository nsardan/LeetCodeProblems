package com.learning.sorting;

public class SortColors {


    public int[] sortColors(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length-1;
        int currIndex = 0;
        int tmp;
        while(currIndex <= endIndex){
            if(nums[currIndex] == 0){
                tmp = nums[currIndex];
                nums[currIndex++] = nums[startIndex];
                nums[startIndex++] = tmp;
            }
            else if(nums[currIndex] == 2){
                tmp = nums[endIndex];
                nums[endIndex--] = nums[currIndex];
                nums[currIndex] = tmp;
            }else{
                currIndex++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SortColors sort = new SortColors();
        int[] nums = new int[]{2,0,2,1,1,0};
        int[] ans = sort.sortColors(nums);
        sort.printArray(ans);
    }

    public void printArray(int[] input){
        for(int i : input){
            System.out.print(i + " , ");
        }
    }
}
