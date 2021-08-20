package leetcode;

import java.util.Objects;

public class MaxProduct {
    int getSum(TreeNode root, int sumSoFar) {
        if (Objects.isNull(root))
            return sumSoFar;
        return getSum(root.left, sumSoFar) + getSum(root.right, sumSoFar) + root.val;
    }

    long ans;
    int totalSum;
    public int maxProduct(TreeNode root) {
        totalSum = getSum(root, 0);
        ans = Long.MIN_VALUE;
        maxProductUtil(root);
        return (int) ( ans  % (int) (1e9 +7) );
    }

    private long maxProductUtil(TreeNode root) {
        if (Objects.isNull(root))
            return 0;
        long leftSum = maxProductUtil(root.left);
        long rightSum = maxProductUtil(root.right);
        long subtreeSum = leftSum + rightSum + root.val;
        ans = Math.max(ans, subtreeSum*(totalSum - subtreeSum));
        return subtreeSum;
    }
}
