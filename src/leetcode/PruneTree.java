package leetcode;
//https://leetcode.com/problems/binary-tree-pruning/
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return root;
        if (root.left == null && root.right == null)
        {
            if (root.val == 0)
                return null;
            else
                return root;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null)
        {
            if (root.val == 0)
                return null;
            else
                return root;
        }
        return root;
    }
}
