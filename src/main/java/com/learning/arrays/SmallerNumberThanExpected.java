package com.learning.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmallerNumberThanExpected {

    public static void main(String[] args) {
        SmallerNumberThanExpected ob = new SmallerNumberThanExpected();
        int arr[] = ob.smallerNumbersThanCurrent(new int[]{8,1,2,2,3});
        Arrays.stream(arr).forEach(System.out::print);
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        HashMap<Integer, Integer> mapOfNumbers = new HashMap<Integer, Integer>();
        for(int i= 0; i < nums.length; i++){
            if(mapOfNumbers.get(nums[i]) == null){
                mapOfNumbers.put(nums[i],i);
            }
        }
        int solution[] = new int[nums.length];
        for(int i= 0; i < copy.length; i++){
            solution[i] = mapOfNumbers.get(copy[i]);
        }
        return solution;
    }
}
