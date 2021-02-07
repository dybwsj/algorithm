import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Executor;

public class 前中后序遍历 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution4 {
    public List<Integer> preorderTraversal(TreeNode root) {

        //万能遍历，迭代法
//        List<Integer> L = new ArrayList<>();
//        Stack<TreeNode> s = new Stack<>();
//
//        if (root != null){
//            s.push(root);
//        } else {
//            return L;
//        }
//        while (!s.isEmpty()){
//            TreeNode t = s.pop();
//            if (t != null){
//                //前序遍历
////                if (t.right != null) s.push(t.right);
////                if (t.left != null) s.push(t.left);
////                s.push(t);
////                s.push(null);
//                //中序遍历
//                if (t.right != null) s.push(t.right);
//                s.push(t);
//                s.push(null);
//                if (t.left != null) s.push(t.left);
//                //后序遍历
////                s.push(t);
////                s.push(null);
////                if (t.right != null) s.push(t.right);
////                if (t.left != null) s.push(t.left);
//            } else {
//                L.add(s.pop().val);
//            }
//        }
//        return L;

        //递归——前序遍历
//        List<Integer> L = new ArrayList<>();
//        preorder(root,L);
//        return L;
//    }
//    public void preorder(TreeNode node, List list){
//        if (node != null){
//            list.add(node.val);
//            preorder(node.left,list);
//            preorder(node.right,list);
//        }

        //递归——中序遍历
//        List<Integer> L = new ArrayList<>();
//        preorder(root,L);
//        return  L;
//        public void preorder(TreeNode node, List list){
//            if (node != null){
//                preorder(node.left, L);
//                list.add(node.val);
//                preorder(node.right, L);
//            }
//        }

        //递归——后序遍历
//        List<Integer> L = new ArrayList<>();
//        preorder(root,L);
//        return  L;
//        public void preorder(TreeNode node, List list){
//            if (node != null){
//                preorder(node.left, L);
//                preorder(node.right, L);
//                list.add(node.val);
//            }
//        }

        //迭代——前序遍历
//        List<Integer> L = new ArrayList<>();
//        Stack s = new Stack();
//        if (root != null){
//            s.push(root);
//        } else {
//            return L;
//        }
//        while (!s.empty()){
//            TreeNode t = (TreeNode) s.pop();
//            L.add(t.val);
//            if (t.right!=null) s.push(t.right);
//            if (t.left!=null) s.push(t.left);
//        }
//        return L;

        //迭代——中序遍历
//        List<Integer> L = new ArrayList<>();
//        Stack<TreeNode> s = new Stack<>();
//
//        while (root != null || !s.isEmpty()){
//            if (root != null){
//                s.push(root);
//                root = root.left;
//            } else {
//                TreeNode m = s.pop();
//                L.add(m.val);
//                root = m.right;
//            }
//        }
//        return L;
        //迭代——后序遍历

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        //记录最后弹出的节点，由此判定父节点的右节点有没有走过，否则会出现死循环。如果已经走过直接弹出父节点。
        TreeNode last = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.peek();
                //是否变到右子树
                if (temp.right != null && temp.right != last) {
                    cur = temp.right;
                } else {
                    list.add(temp.val);
                    last = temp;
                    stack.pop();
                }
            }
        }
        return list;
    }
}