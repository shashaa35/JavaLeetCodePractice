package leetcode;

import java.util.Objects;

public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // ensure q > p
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        while(Objects.nonNull(root)) {
            if (root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
