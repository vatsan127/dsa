package com.srivatsan.dsa.binarytrees;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Node {
    int value;
    Node rightChild;
    Node leftChild;

    public Node(int value) {
        this.value = value;
    }
}

public class BinaryTrees {

    /*
     * RightChild should be greater than Root
     * LeftChild should be less than Root
     * Duplicate Entries are not allowed
     * Right Skewed: Most of the Node only have right child
     * Ex: 1, 2, 3, 4
     *  1
     *   \
     *    2
     *     \
     *      3
     *       \
     *        4
     *
     *
     *
     * Left Skewed: Most of the Node only have Left child
     * Ex: 8, 7, 6, 5
     *                  8
     *                 /
     *                7
     *               /
     *              6
     *             /
     *            5
     * */

    Node root;

    private List<Integer> orderList;

    /**
     * Insert Data
     */
    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            insert(data, root);
        }
    }

    private Node insert(int data, Node root) {
        if (root == null) {
            root = new Node(data);
        } else if (data < root.value) {
            root.leftChild = insert(data, root.leftChild);
        } else {
            root.rightChild = insert(data, root.rightChild);
        }
        return root;
    }

    /* Traversal - Depth First
     * PreOrder
     * PostOrder
     * InOrder
     * */

    /**
     * PreOder - Root, Left, Right
     */
    public void preOrderTraverse() {
        orderList = new ArrayList<>();
        preOrderTraverse(root);
        System.out.println("preOderTraverse: " + orderList);
    }

    private void preOrderTraverse(Node root) {
        if (root == null) return;
        orderList.add(root.value);
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);

    }

    /**
     * PostOder - Left, Right, Root
     */
    public void postOrderTraverse() {
        orderList = new ArrayList<>();
        postOrderTraverse(root);
        System.out.println("postOderTraverse: " + orderList);
    }

    private void postOrderTraverse(Node root) {
        if (root == null) return;

        postOrderTraverse(root.leftChild);
        postOrderTraverse(root.rightChild);
        orderList.add(root.value);
    }

    /**
     * InOrder - Left, Root, Right
     * Always sorted list
     */

    public void inOrderTraverse() {
        orderList = new ArrayList<>();
        inOrderTraverse(root);
        System.out.println("inOrderTraverse: " + orderList);
    }

    private void inOrderTraverse(Node root) {
        if (root == null) return;

        inOrderTraverse(root.leftChild);
        orderList.add(root.value);
        inOrderTraverse(root.rightChild);
    }


    /**
     * Find - check whether an element is present
     */

    public boolean find(int input) {
        Node node = root;
        while (node != null) {
            if (input < node.value) node = node.leftChild;
            else if (input > node.value) node = node.rightChild;
            else return true;
        }
        return false;
    }

    /**
     * get The minimum value using postOrder traversal
     */

    public int findMinValue() {
        if (root == null) return -1;
        return findMinValue(root);
    }

    private int findMinValue(Node root) {
        if (root == null) return Integer.MAX_VALUE;

        int minLeft = findMinValue(root.leftChild);
        int minRight = findMinValue(root.rightChild);

        return Math.min(root.value, Math.min(minLeft, minRight));
    }

    /**
     * get The minimum value  in Binary Search Tree
     */

    public int findMinValueInBST() {
        if (root == null) {
            throw new NoSuchElementException("Tree is Empty");
        }
        Node node = root;
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node.value;
    }

    /**
     * equality check between 2 Trees Using PreOrder traversal
     */
    public boolean compareTrees(BinaryTrees other) {
        if (other == null) return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) return true;
        if (first != null && second != null)
            return first.value == second.value && equals(first.leftChild, second.leftChild) && equals(first.rightChild, second.rightChild);

        return false;
    }

    /**
     * Get the Elements in the Tree at a given distance
     * Note : root is at a Distance 0.
     */

    public void getNodeAtDistance(int distance) {
        orderList = new ArrayList<>();
        getNodeAtDistance(root, distance);
        System.out.println(String.format("Node At Distance : %d :: %s", distance, orderList));
    }

    private void getNodeAtDistance(Node root, int distance) {

        if (root == null) return;

        if (distance == 0) {
            orderList.add(root.value);
        }

        getNodeAtDistance(root.leftChild, distance - 1);
        getNodeAtDistance(root.rightChild, distance - 1);

    }

    /**
     * get Max Height
     */
    public int height() {
        return getHeight(root);
    }


    private int getHeight(Node root) {
        if (root == null) {
            return -1;
        }

        if (root.leftChild == null && root.rightChild == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
    }

    /**
     * Traversal -  Breadth First or Level Order Traversal
     */
    public void levelOrderTraversal() {
        System.out.println("Level Order Traversal");
        for (int i = 0; i <= height(); i++) {
            getNodeAtDistance(i);
        }
    }
}
