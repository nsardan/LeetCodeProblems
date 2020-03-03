package com.learning.arrays;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int index = 0;
        for(int i = 0; i < length; i++){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }

        for(int i = index; i < length; i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int input[] = {0,1,0,3,12};
        MoveZeros main = new MoveZeros();
        main.moveZeroes(input);
    }
}
