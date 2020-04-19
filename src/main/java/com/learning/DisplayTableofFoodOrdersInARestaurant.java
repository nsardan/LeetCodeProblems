package com.learning;

import java.util.*;
import java.util.stream.Collectors;

public class DisplayTableofFoodOrdersInARestaurant {
    /*
    Input: orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
Output: [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
Explanation:
The displaying table looks like:
Table,Beef Burrito,Ceviche,Fried Chicken,Water
3    ,0           ,2      ,1            ,0
5    ,0           ,1      ,0            ,1
10   ,1           ,0      ,0            ,0
For the table 3: David orders "Ceviche" and "Fried Chicken", and Rous orders "Ceviche".
For the table 5: Carla orders "Water" and "Ceviche".
For the table 10: Corina orders "Beef Burrito".
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> finalAnswer = new ArrayList<>();

        Set<String> food = new HashSet<>();
        Set<Integer> table = new HashSet<>();

        TreeMap<String, Integer> map = new TreeMap<>();
        for(List<String> order : orders){
            food.add(order.get(2));
            table.add(Integer.parseInt(order.get(1)));
            String key = order.get(1) + order.get(2);
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        List<String> sortedFood = food.stream().sorted().collect(Collectors.toList());
        List<Integer> sortedTable = table.stream().sorted().collect(Collectors.toList());

        List<String> firstRow = new ArrayList<>();
        firstRow.add("Table");
        firstRow.addAll(sortedFood);

        finalAnswer.add(firstRow);

        for(int tablei : sortedTable){
            List<String> nextRow = new ArrayList<>();
            nextRow.add(String.valueOf(tablei));
            for(int i = 1; i < firstRow.size(); i++){
                String key = tablei + firstRow.get(i);
                nextRow.add(String.valueOf(map.getOrDefault(key, 0)));
            }
            finalAnswer.add(nextRow);
        }
        return finalAnswer;
    }
}
