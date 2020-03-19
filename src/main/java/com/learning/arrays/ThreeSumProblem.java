package com.learning.arrays;

import java.util.*;

public class ThreeSumProblem {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalAnswer = new ArrayList<>();

        if(nums.length < 3) return finalAnswer;
        HashMap<Integer, Integer> twoSums = new HashMap<>();
        for(int i = 0; i < nums.length -1; i ++){
            for(int j = i+1; j< nums.length; j++){
                int testSum = - (nums[i] + nums[j]);
                if(twoSums.get(j) != null && twoSums.containsValue(testSum)){
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(testSum);
                    triplets.add(nums[i]);
                    triplets.add(nums[j]);
                    Collections.sort(triplets);
                     if(!finalAnswer.contains(triplets))
                        finalAnswer.add(triplets);

                }
                else {
                    twoSums.put(j, nums[j]);

                }
            }
        }

        return finalAnswer;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,-2,-1,1,2};
        ThreeSumProblem problem = new ThreeSumProblem();
        List<List<Integer>>  finalAnswer = problem.threeSum(nums);
        for(List<Integer> list : finalAnswer){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
            System.out.println("===========");
        }

    }

    public List<List<Integer>> threeSumExtraSpace(int[] nums) {
        Set<List<Integer>> finalAnswer = new HashSet<>();

        if(nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        int left = 0;
        int right = 0;

        for(; i < nums.length -1 ;i++){
            left = i +1;

            right = nums.length -1;
            while(left < right) {

                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(nums[left]);
                    triplets.add(nums[right]);
                    if(!finalAnswer.contains(triplets))
                        finalAnswer.add(triplets);
                    left++;
                    right--;
                }
                else if (nums[i] + nums[left] + nums[right] < 0){
                    left++;
                    //i++;
                }
                else if(nums[i] + nums[left] + nums[right]  > 0){
                    right--;
                }
            }
            left = i +1;

        }
        return new ArrayList<>(finalAnswer);
    }
}
