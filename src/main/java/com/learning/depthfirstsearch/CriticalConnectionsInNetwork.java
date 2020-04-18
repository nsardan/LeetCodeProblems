package com.learning.depthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

public class CriticalConnectionsInNetwork {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n], low = new int[n];
        // use adjacency list instead of matrix will save some memory, adjmatrix will cause MLE
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.fill(disc, -1); // use disc to track if visited (disc[i] == -1)
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // build graph
        for (int i = 0; i < connections.size(); i++) {
            int from = connections.get(i).get(0), to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, low, disc, graph, res, i);
            }
        }
        System.out.println(time);
        return res;
    }

    int time = 0; // time when discover each vertex

    private void dfs(int vertex, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre) {
        disc[vertex] = low[vertex] = ++time;
        // discover u
        System.out.println(pre);
        for (int j = 0; j < graph[vertex].size(); j++) {
            int child = graph[vertex].get(j);
            if (child == pre) {
                continue; // if parent vertex, ignore
            }
            if (disc[child] == -1) { // if not discovered
                dfs(child, low, disc, graph, res, vertex);
                low[vertex] = Math.min(low[vertex], low[child]);
                if (low[child] > disc[vertex]) {
                    // u - v is critical, there is no path for v to reach back to u or previous vertices of u
                    res.add(Arrays.asList(vertex, child));
                }
            } else { // if v discovered and is not parent of u, update low[u], cannot use low[v] because u is not subtree of v
                low[vertex] = Math.min(low[vertex], disc[child]);
                System.out.println(low[vertex]);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));
        int servers = 4;
        CriticalConnectionsInNetwork main = new CriticalConnectionsInNetwork();
        List<List<Integer>> res = main.criticalConnections(servers, connections);
        res.forEach(System.out::println);
    }
}
