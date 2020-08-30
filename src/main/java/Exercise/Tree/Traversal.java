package Exercise.Tree;


import java.util.*;

public class Traversal {

    public static void main(String[] args) {


        //构建二叉树
        //
        //                3
        //        9                 20
        //
        //                      15      7

        Integer[] array = {3, 9, null, null, 20, 15, null, null, 7};
        LinkedList<Integer> initList = new LinkedList<>(Arrays.asList(array));
        TreeNode treeNode = createBinaryTree(initList);
        System.out.println(treeNode);

        //前序遍历-递归
        List<Integer> result = new Traversal().preorderTraversal(treeNode);
        System.out.println("=================================================");

        System.out.println("前序遍历-递归-开始");
        for (Integer one : result) {
            System.out.print(one + " ");
        }
        System.out.println();
        System.out.println("前序遍历-递归-结束");

        System.out.println("=================================================");


        //前序遍历-非递归
        System.out.println("前序遍历-非递归-开始");
        List<Integer> resultWithStack = preOrderTraveralWithStack(treeNode);
        for (Integer one : resultWithStack) {
            System.out.print(one + " ");
        }
        System.out.println();
        System.out.println("前序遍历-非递归-结束");

        System.out.println("=================================================");

        //中序遍历-递归
        List<Integer> inOrderTraveralresult = new Traversal().inOrderTraveral(treeNode);
        System.out.println("中序遍历-递归-开始");
        for (Integer one : inOrderTraveralresult) {
            System.out.print(one + " ");
        }
        System.out.println();
        System.out.println("中序遍历-递归-结束");
        System.out.println("=================================================");

        //中序遍历-非递归
        System.out.println("中序遍历-非递归-开始");
        List<Integer> inOrderTraveralWithStackresult = inOrderTraveralWithStack(treeNode);
        for (Integer one : inOrderTraveralWithStackresult) {
            System.out.print(one + " ");
        }
        System.out.println();
        System.out.println("中序遍历-非递归-结束");
        System.out.println("=================================================");

        //后序遍历-递归
        List<Integer> postOrderTraveralresult = new Traversal().postOrderTraveral(treeNode);
        System.out.println("后序遍历-递归-开始");
        for (Integer one : postOrderTraveralresult) {
            System.out.print(one + " ");
        }
        System.out.println();
        System.out.println("后序遍历-递归-结束");
        System.out.println("=================================================");

        //后序遍历-非递归
        System.out.println("后序遍历-非递归-开始");
        postOrderTraveralWithStack(treeNode);
        System.out.println();
        System.out.println("后序遍历-非递归-结束");

        System.out.println("=================================================");

        //层级遍历
        System.out.println("层级遍历-递归-开始");
        levelOrder(treeNode);
        System.out.println();
        System.out.println("层级遍历-递归-结束");

        System.out.println("=================================================");

    }

    /**
     * 构建二叉树
     *
     * @param list 输入序列
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> list) {
        TreeNode node = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Integer data = list.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(list);
            node.right = createBinaryTree(list);
        }
        return node;
    }

    /**
     * 前序遍历-递归
     * 二叉树前序遍历   根-> 左-> 右
     */
    List<Integer> preorderTraversalresult = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            preorderTraversalresult.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return preorderTraversalresult;
    }

    /**
     * 前序遍历-非递归
     * 二叉树前序遍历   根-> 左-> 右
     */
    public static List<Integer> preOrderTraveralWithStack(TreeNode node) {
        List<Integer> preOrderTraveralWithStackresult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = node;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                preOrderTraveralWithStackresult.add(treeNode.val);
//                System.out.print(treeNode.val+" ");
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
        return preOrderTraveralWithStackresult;
    }


    /**
     * 中序遍历-递归
     * 二叉树中序遍历   左-> 根-> 右
     */
    List<Integer> inOrderTraveralresult = new ArrayList<>();

    public List<Integer> inOrderTraveral(TreeNode root) {
        if (root != null) {
            inOrderTraveral(root.left);
            inOrderTraveralresult.add(root.val);
            inOrderTraveral(root.right);
        }
        return inOrderTraveralresult;
    }


    /**
     * 中序遍历-非递归
     * 二叉树中序遍历   左-> 根-> 右
     */
    public static List<Integer> inOrderTraveralWithStack(TreeNode node) {
        List<Integer> inOrderTraveralWithStackresult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = node;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                inOrderTraveralWithStackresult.add(treeNode.val);
//                System.out.print(treeNode.val + " ");
                treeNode = treeNode.right;
            }
        }
        return inOrderTraveralWithStackresult;
    }


    /**
     * 后序遍历-递归
     * 二叉树后序遍历   左-> 右-> 根
     */
    List<Integer> postOrderTraveralresult = new ArrayList<>();

    public List<Integer> postOrderTraveral(TreeNode root) {
        if (root != null) {
            postOrderTraveral(root.left);
            postOrderTraveral(root.right);
            postOrderTraveralresult.add(root.val);
        }
        return postOrderTraveralresult;
    }

    /**
     * 后序遍历-非递归
     */
    public static void postOrderTraveralWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = node;
        TreeNode lastVisit = null;   //标记每次遍历最后一次访问的节点
        while (treeNode != null || !stack.isEmpty()) {//节点不为空，结点入栈，并且指向下一个左孩子
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //栈不为空
            if (!stack.isEmpty()) {
                //出栈
                treeNode = stack.pop();
                /**
                 * 这块就是判断treeNode是否有右孩子，
                 * 如果没有，输出treeNode.data，让lastVisit指向treeNode，并让treeNode为空
                 * 如果有右孩子，将当前节点继续入栈，treeNode指向它的右孩子,继续重复循环
                 */
                if (treeNode.right == null || treeNode.right == lastVisit) {
                    System.out.print(treeNode.val + " ");
                    lastVisit = treeNode;
                    treeNode = null;
                } else {
                    stack.push(treeNode);
                    treeNode = treeNode.right;
                }
            }
        }
    }

    /**
     * 层级遍历
     */
    public static void levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.pop();
            System.out.print(root.val + " ");
            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);
        }
    }

}
