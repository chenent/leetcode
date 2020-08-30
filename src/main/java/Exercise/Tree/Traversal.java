package Exercise.Tree;

import java.util.*;

public class Traversal {

    public static void main(String[] args) {

//        Integer[] array={3,9,20,null,null,15,7};
        Integer[] array={3,9,null,null,20,15,null,null,7};
        LinkedList<Integer> initList = new LinkedList<>(Arrays.asList(array));

        //构建二叉树
//
//                3
//        9                 20
//
//                      15      7
        TreeNode treeNode=createBinaryTree(initList);
        System.out.println(treeNode);

        //前序遍历-递归
        List<Integer> result=new Traversal().preorderTraversal(treeNode);
        System.out.println("前序遍历-递归-开始");
        for(Integer one:result){
            System.out.print(one+" ");
        }
        System.out.println();
        System.out.println("前序遍历-递归-结束");


        //前序遍历-非递归
        System.out.println("前序遍历-非递归-开始");
        List<Integer> resultWithStack=preOrderTraveralWithStack(treeNode);
        for(Integer one:resultWithStack){
            System.out.print(one+" ");
        }
        System.out.println();
        System.out.println("前序遍历-非递归-结束");

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
    */
    List<Integer> preorderTraversalresult = new ArrayList<>();
    public  List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            preorderTraversalresult.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return preorderTraversalresult;
    }

    /**
     * 前序遍历-非递归
     */
    public static List<Integer> preOrderTraveralWithStack(TreeNode node){
        List<Integer> preOrderTraveralWithStackresult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = node;
        while(treeNode!=null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while(treeNode != null){
                preOrderTraveralWithStackresult.add(treeNode.val);
//                System.out.print(treeNode.val+" ");
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
        return preOrderTraveralWithStackresult;
    }


}
