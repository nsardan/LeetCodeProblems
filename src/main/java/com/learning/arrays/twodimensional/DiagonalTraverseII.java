package com.learning.arrays.twodimensional;

import java.util.*;

public class DiagonalTraverseII {
    //[[1,2,3],[4,5,6],[7,8,9]]
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.size(); i++){
            List<Integer> row = nums.get(i);
            for(int j = 0; j < row.size(); j++){
                int index = i +j;
                LinkedList<Integer> list = map.get(index);
                if(list == null) list = new LinkedList<>();
                list.addFirst(row.get(j));
                map.put(index, list);
            }
        }

        int maxLength = Collections.max(map.keySet());
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= maxLength; i++){
            result.addAll(map.get(i));
        }

        int ans[] = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            ans[i] = result.get(i);
        }

        return ans;
    }
}
