import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: duyubo
 * @date: 2020年12月22日, 0022 13:31
 * @description:
 */

public class P103_二叉树的锯齿形层序遍历 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList();
        if (root != null) {
            queue.add(root);
        } else {
            return res;
        }
        boolean left = true;
        while (!queue.isEmpty()) {
            List<Integer> queue1 = new LinkedList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (left) {
                    queue1.add(node.val);
                } else {
                    queue1.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            left = !left;
            res.add(queue1);
        }
        return res;
    }
}
