package com.learning.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> finalAnswer = new ArrayList<>();
        if(nums.length < 4) return finalAnswer;
        Arrays.sort(nums);


        for(int first = 0; first < nums.length; first++){
            if(first != 0 && nums[first] == nums[first-1]) continue;

                for(int second = first +1; second < nums.length; second++){
                    if(second != first+1 && nums[second] == nums[second -1]) continue;
                    int twoSum = target - nums[first] - nums[second];
                    int third = second +1, fourth = nums.length -1;
                    while(third < fourth){
                        if(nums[third] + nums[fourth] == twoSum){
                            finalAnswer.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                            third++;
                            fourth--;
                            while(third < nums.length && nums[third] == nums[third -1])third++;
                            while(fourth >= 0 && nums[fourth] == nums[fourth +1]) fourth++;
                        }else if(nums[third] + nums[fourth] < twoSum){
                            third++;
                        }else{
                            fourth--;
                        }
                    }
                }
        }
        return finalAnswer;
    }

    public static void main(String[] args) {

    }
}
