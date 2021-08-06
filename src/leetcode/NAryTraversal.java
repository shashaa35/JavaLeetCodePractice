package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

//https://leetcode.com/problems/n-ary-tree-level-order-traversal/
public class NAryTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<Node> nodesOfLevel = new LinkedList<>();
        if (Objects.nonNull(root))
            nodesOfLevel.add(root);
        while (!nodesOfLevel.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int sizeOfLevel = nodesOfLevel.size();
            for (int i = 0; i < sizeOfLevel; i++) {
                Node node = nodesOfLevel.poll();
                temp.add(node.val);
                nodesOfLevel.addAll(node.children);
            }
            ans.add(temp);
        }
        return ans;
    }
}
