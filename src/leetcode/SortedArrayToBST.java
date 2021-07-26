package leetcode;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class SortedArrayToBST {
    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l>r)
            return null;
        int mid = l + (r-l)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, l, mid-1);
        node.right = sortedArrayToBST(nums, mid+1, r);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        SortedArrayToBST obj = new SortedArrayToBST();
//        TreeNode root = obj.sortedArrayToBST(new int[] {-10,-3,0,5,9});
        TreeNode root = obj.sortedArrayToBST(new int[] {});
        TreeNode.inOrderTraversal(root);
    }
}
