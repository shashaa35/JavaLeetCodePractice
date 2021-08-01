package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/making-a-large-island
//As in the previous solution, we check every 0. However, we also store the size of each group, so that we do not have to use depth-first search to repeatedly calculate the same size.
//However, this idea fails when the 0 touches the same group. For example, consider grid = [[0,1],[1,1]]. The answer is 4, not 1 + 3 + 3, since the right neighbor and the bottom neighbor of the 0 belong to the same group.
//We can remedy this problem by keeping track of a group id (or index), that is unique for each group. Then, we'll only add areas of neighboring groups with different ids.
//Algorithm
//For each group, fill it with value index and remember it's size as area[index] = dfs(...).
//Then for each 0, look at the neighboring group ids seen and add the area of those groups, plus 1 for the 0 we are toggling. This gives us a candidate answer, and we take the maximum.
//To solve the issue of having potentially no 0, we take the maximum of the previously calculated areas.
public class LargestIsland {
    boolean[][] visited;
    int[] area;
    int[][] areaIds;
    int dir[][] = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    int id;
    private static class Pair<P,Q> {
        P fst;
        Q snd;
        Pair(P f, Q s) {
            fst = f;
            snd = s;
        }
    }
    public void BFS(int[][] grid, int i, int j) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int size = 0;
        q.add(new Pair<Integer, Integer>(i, j));
        visited[i][j] = true;
        id++;
        while (!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            areaIds[p.fst][p.snd] = id;
            size++;
            for (int k=0;k<4;k++) {
                if (checkIfExists(p.fst, p.snd, k)
                        && !visited[p.fst + dir[k][0]][p.snd + dir[k][1]]
                        && grid[p.fst + dir[k][0]][p.snd + dir[k][1]] == 1) {
                    q.add(new Pair<>(p.fst + dir[k][0], p.snd + dir[k][1]));
                    visited[p.fst + dir[k][0]][p.snd + dir[k][1]] = true;
                }
            }
        }
        area[id] = size;
    }

    public void traverseIslands(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    BFS(grid, i, j);
                }
            }
        }
    }

    public int largestIsland(int[][] grid) {
        id = 0;
        area = new int[grid.length*grid[0].length+1];
        areaIds = new int[grid.length][grid[0].length];
        int ans = -1;
        traverseIslands(grid);

        for (int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 0){
                    int temp = 0;
                    Set<Integer> s = new HashSet<>();
                    for (int k=0;k<4;k++) {
                        if(checkIfExists(i,j,k)){
                            s.add(areaIds[i+dir[k][0]][j+dir[k][1]]);
                        }
                    }
                    for (Integer id: s)
                        temp += area[id];
                    temp++;
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans== -1? grid.length*grid[0].length: ans;
    }

    private boolean checkIfExists(int i, int j, int k) {
        return i+dir[k][0] < areaIds.length
                && i+dir[k][0]>=0
                && j+dir[k][1]>=0
                && j+dir[k][1]<areaIds[0].length;
    }

    public static void main(String[] args) {
        LargestIsland obj = new LargestIsland();
        System.out.println(obj.largestIsland(new int[][]{{1,1},{1,0}}));
        System.out.println(obj.largestIsland(new int[][]{{1,0},{0,1}}));
        System.out.println(obj.largestIsland(new int[][]{{1,1},{1,1}}));
        System.out.println(obj.largestIsland(new int[][]{{0,0},{0,0}}));
        System.out.println(obj.largestIsland(new int[][]{{1}}));
    }
}
