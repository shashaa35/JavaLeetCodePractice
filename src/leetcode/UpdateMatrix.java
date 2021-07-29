package leetcode;

//https://leetcode.com/problems/01-matrix/
//https://leetcode.com/problems/01-matrix/solution/
//BFS : https://leetcode.com/problems/01-matrix/discuss/1327052/Single-Reverse-BFS-approach-JAVA-Best-Clean-Code
//DP : below solution
public class UpdateMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        int[][] dis = new int[matrix.length][matrix[0].length];
        int range = matrix.length * matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    dis[i][j] = 0;
                } else {
                    int upCell = (i > 0) ? dis[i - 1][j] : range;
                    int leftCell = (j > 0) ? dis[i][j - 1] : range;
                    dis[i][j] = Math.min(upCell, leftCell) + 1;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    dis[i][j] = 0;
                } else {
                    int downCell = (i < matrix.length - 1) ? dis[i + 1][j] : range;
                    int rightCell = (j < matrix[0].length - 1) ? dis[i][j + 1] : range;
                    dis[i][j] = Math.min(Math.min(downCell, rightCell) + 1, dis[i][j]);
                }
            }
        }

        return dis;
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
