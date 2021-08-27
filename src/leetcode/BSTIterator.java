package leetcode;

import java.util.Objects;
import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator/
public class BSTIterator {
    private final Stack<TreeNode> stack;
    private final boolean reverse;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        reverse = false;
        push(root);
    }

    public BSTIterator(TreeNode root, boolean reverseOrder) {
        stack = new Stack<>();
        reverse = reverseOrder;
        push(root);
    }

    public int next() {
        TreeNode top = stack.pop();
        push(reverse? top.left : top.right);
        return top.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void push(TreeNode root) {
        while(Objects.nonNull(root)) {
            stack.push(root);
            root = (reverse? root.right : root.left);
        }
    }
}
