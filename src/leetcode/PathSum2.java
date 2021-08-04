package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

//https://leetcode.com/problems/path-sum-ii/
//dfs and preorder tree traversal
public class PathSum2 {

    List<List<Integer>> ans;
    void traversePreOrder(TreeNode root, Stack<Integer> path, int sumTillNow, int targetSum) {
        if (Objects.isNull(root)) {
            return;
        }

        sumTillNow += root.val;
        path.add(root.val);
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            if (sumTillNow == targetSum) {
                ans.add(new ArrayList<>(path));
            }
        }
        traversePreOrder(root.left, path, sumTillNow, targetSum);
        traversePreOrder(root.right, path, sumTillNow, targetSum);
        path.pop();
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        traversePreOrder(root, path, 0, targetSum);
        return ans;
    }
}
