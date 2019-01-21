package main.domian;

public class BinaryTreeNode {

    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int x) {
        val = x;
    }

    public BinaryTreeNode() {
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode setLeft(BinaryTreeNode left) {
        this.left = left;
        return this;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public BinaryTreeNode setRight(BinaryTreeNode right) {
        this.right = right;
        return this;
    }

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
        binaryTreeNode
                .setRight(
                        new BinaryTreeNode(5))
                .setLeft(
                        new BinaryTreeNode(2)
                                .setLeft(
                                        new BinaryTreeNode(3)
                                                .setLeft(new BinaryTreeNode(4))
                                                .setRight(new BinaryTreeNode(6))
                                )
                );

//        binaryTreeNode.printNode(binaryTreeNode);
        binaryTreeNode.ppp(binaryTreeNode, 5);
        System.out.println();
//        binaryTreeNode.ppp(binaryTreeNode, 4);
    }

    public void ppp(BinaryTreeNode root, Integer object) {
        if (root.right != null || root.left != null) {
            printNode(root);
            if (root.right != null && root.right.val == object) {
                printNode(root.right);
                System.exit(0);
            } else if (root.left != null && root.left.val == object) {
                printNode(root.left);
                System.exit(0);
            }

        }
        if (root.getRight() != null) {  //递归遍历右孩子
            ppp(root.getRight(), object);
        }
        if (root.getLeft() != null) {  //使用递归进行遍历左孩子
            ppp(root.getLeft(), object);
        }
    }

    public void printNode(BinaryTreeNode node) {
        System.out.print(node.getVal());
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public void preorderTraversal(BinaryTreeNode root) {
        printNode(root);
        if (root.getLeft() != null) {  //使用递归进行遍历左孩子
            preorderTraversal(root.getLeft());
        }
        if (root.getRight() != null) {  //递归遍历右孩子
            preorderTraversal(root.getRight());
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void sequentialTraversal(BinaryTreeNode root) {  //中序遍历
        if (root.getLeft() != null) {
            sequentialTraversal(root.getLeft());
        }
        printNode(root);
        if (root.getRight() != null) {
            sequentialTraversal(root.getRight());
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void postOrderTraversal(BinaryTreeNode root) {  //后序遍历
        if (root.getLeft() != null) {
            postOrderTraversal(root.getLeft());
        }
        if (root.getRight() != null) {
            postOrderTraversal(root.getRight());
        }
        printNode(root);
    }
}
