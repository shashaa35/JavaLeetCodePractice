package leetcode;

//https://leetcode.com/problems/01-matrix/
public class UpdateMatrix {

    private int[][] ans;

    private boolean rightExists(int i, int  j) {
        return j+1 < ans[0].length;
    }

    private boolean leftExists(int i, int  j) {
        return j-1 >= 0;
    }

    private boolean upExists(int i, int  j) {
        return i-1 >= 0;
    }
    private boolean downExists(int i, int  j) {
        return i+1 < ans.length;
    }

    public boolean updateSurroundings(int[][] mat, int i, int j) {
        if (ans[i][j] == ans.length*ans[0].length) {
            //not eligible for updating surroundings
            return false;
        }
        boolean updated = false;
        if (rightExists(i, j) && ans[i][j+1] > ans[i][j]+1) {
            updated = true;
            ans[i][j+1] = ans[i][j]+1;
        }
        if (leftExists(i, j) && ans[i][j-1] > ans[i][j]+1) {
            updated = true;
            ans[i][j-1] = ans[i][j]+1;
        }
        if (upExists(i, j) && ans[i-1][j] > ans[i][j]+1) {
            updated = true;
            ans[i-1][j] = ans[i][j]+1;
        }
        if (downExists(i, j) && ans[i+1][j] > ans[i][j]+1) {
            updated = true;
            ans[i+1][j] = ans[i][j]+1;
        }
        return updated;
    }

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        ans = new int[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                ans[i][j] = (mat[i][j] == 0? 0: rows*cols);
            }
        }

        boolean updated = true;
        int currentDistance = 0;
        while(updated) {
            updated = false;
            for (int i=0;i<rows;i++){
                for (int j=0;j<cols;j++){
                    if (ans[i][j] == currentDistance) {
                        updated = updateSurroundings(mat, i, j) || updated;
                    }
                }
            }
            currentDistance++;
        }
        return ans;
    }

    public static void main(String[] args) {
        UpdateMatrix obj = new UpdateMatrix();
        int [][] ans = obj.updateMatrix(new int[][] {{1,1,1}, {1,0,1}, {1,1,1}});
        for (int i=0;i< ans.length;i++){
            for (int j=0;j<ans[0].length;j++){
                System.out.printf("%d ", ans[i][j]);
            }
            System.out.println();
        }
    }
}
