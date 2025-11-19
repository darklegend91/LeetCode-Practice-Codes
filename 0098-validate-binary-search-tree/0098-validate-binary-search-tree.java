class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidSub(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidSub(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return isValidSub(root.left, min, root.val) &&
               isValidSub(root.right, root.val, max);
    }
}
