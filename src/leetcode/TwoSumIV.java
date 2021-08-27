package leetcode;

public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator leftIterator = new BSTIterator(root);
        BSTIterator rightIterator = new BSTIterator(root, true);

        int left = leftIterator.next(), right = rightIterator.next();
        while (left < right) {
            if (left + right == k)
                return true;
            else if (left + right < k) {
                if (leftIterator.hasNext())
                    left = leftIterator.next();
                else
                    return false;
            } else {
                if (rightIterator.hasNext())
                    right = rightIterator.next();
                else
                    return false;
            }
        }
        return false;
    }
}
