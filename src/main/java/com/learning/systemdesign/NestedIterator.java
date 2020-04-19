package com.learning.systemdesign;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class NestedIterator implements Iterator<Integer> {
    List<Integer> integers = new ArrayList<>();
    int position = 0;


    public NestedIterator(List<NestedInteger> nestedList) {
        flatten(nestedList);

    }

    public void flatten(List<NestedInteger> nestedIntegers){
        for(NestedInteger nestedInteger : nestedIntegers){
            if(nestedInteger.isInteger()) integers.add(nestedInteger.getInteger());
            else flatten(nestedInteger.getList());
        }
    }

    @Override
    public Integer next() {
        if(!hasNext()) throw new NoSuchElementException();
        return integers.get(position++);
    }

    @Override
    public boolean hasNext() {
        return position < integers.size();
    }
}


  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
   interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
