package leetcode;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    boolean[][] visited;
    private static class Pair<P,Q> {
        P fst;
        Q snd;
        Pair(P f, Q s) {
            fst = f;
            snd = s;
        }
    }
    public void BFS(char[][] grid, int i, int j) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<Integer, Integer>(i, j));
        visited[i][j] = true;
        while (!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            if (p.fst + 1 < grid.length && !visited[p.fst + 1][p.snd] && grid[p.fst + 1][p.snd] == '1') {
                //down cell
                q.add(new Pair<>(p.fst + 1, p.snd));
                visited[p.fst + 1][p.snd] = true;
            }
            if (p.fst - 1 > -1 && !visited[p.fst - 1][p.snd] && grid[p.fst - 1][p.snd] == '1') {
                //up cell
                q.add(new Pair<>(p.fst - 1, p.snd));
                visited[p.fst - 1][p.snd] = true;
            }
            if (p.snd + 1 < grid[0].length && !visited[p.fst][p.snd+1] &&  grid[p.fst][p.snd+1] == '1') {
                //right cell
                q.add(new Pair<>(p.fst, p.snd+1));
                visited[p.fst][p.snd+1] = true;
            }
            if (p.snd - 1 > -1 && !visited[p.fst][p.snd-1] && grid[p.fst][p.snd-1] == '1') {
                //left cell
                q.add(new Pair<>(p.fst, p.snd-1));
                visited[p.fst][p.snd-1] = true;
            }
        }
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    BFS(grid, i, j);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfIslands obj = new NumberOfIslands();
        char [][] grid = new char[][] {{'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},{'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},{'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},{'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},{'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},{'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
//        char [][] grid = new char[][] {{'0','0'},{'0','1'}};
        Instant start = Instant.now();
        System.out.println(obj.numIslands(grid));
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
    }
}
