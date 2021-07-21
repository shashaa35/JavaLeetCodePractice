package leetcode;

//https://leetcode.com/problems/push-dominoes/

/**
 * Here is a worked example on the string S = 'R.R...L':
 * We find the force going from left to right is [7, 6, 7, 6, 5, 4, 0].
 * The force going from right to left is [0, 0, 0, -4, -5, -6, -7].
 * Combining them (taking their vector addition),
 * the combined force is [7, 6, 7, 2, 0, -2, -7],
 * for a final answer of RRRR.LL.
 */
public class PushDominoes {
    public static void main(String[] args) {
        PushDominoes obj = new PushDominoes();
        System.out.println(obj.pushDominoes(new String("RR.L")));
        System.out.println(obj.pushDominoes(new String(".L.R.")));
        System.out.println(obj.pushDominoes(new String(".L.R...LR..L..")));
    }

    public String pushDominoes(String S) {
        char[] A = S.toCharArray();
        int N = A.length;
        int[] forces = new int[N];

        // Populate forces going from left to right
        int force = 0;
        for (int i = 0; i < N; ++i) {
            if (A[i] == 'R') force = N;
            else if (A[i] == 'L') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] += force;
        }

        // Populate forces going from right to left
        force = 0;
        for (int i = N - 1; i >= 0; --i) {
            if (A[i] == 'L') force = N;
            else if (A[i] == 'R') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] -= force;
        }

        StringBuilder ans = new StringBuilder();
        for (int f : forces)
            ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
        return ans.toString();
    }
}
