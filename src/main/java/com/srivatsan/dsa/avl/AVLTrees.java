package com.srivatsan.dsa.avl;

/**
 * AVL TREES is a Type of Binary Trees
 * It is balancedTree/balanceFactor, the difference between the height of the left and right sub-tree of every node should be less than or equal to one.
 * balanceFactor = height(left) - height(right) <= 1
 * balanceFactor > 1 leftHeavy
 * balanceFactor < -1 rightHeavy
 */
public class AVLTrees {

    private class AVLNode {

        private AVLNode leftChild;
        private AVLNode rightChild;
        private final int value;
        private int height;

        public AVLNode(int value) {
            this.value = value;
        }
    }

    private AVLNode root;

    /**
     * Insert Data into the AVL tree
     */

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null) return new AVLNode(value);

        if (value < root.value) root.leftChild = insert(root.leftChild, value);
        else root.rightChild = insert(root.rightChild, value);

        root.height = setHeight(root);
        return balance(root);
    }

    private AVLNode balance(AVLNode node) {
        if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) < 0) {
                System.out.println("Left Rotate " + node.leftChild.value);
                root.leftChild = rotateLeft(root.leftChild);
            }
            System.out.println("Right Rotate " + node.value);
            return rotateRight(root);
        } else if (isRightHeavy(node)) {
            if (balanceFactor(node.rightChild) > 0) {
                System.out.println("Right Rotate " + node.rightChild.value);
                root.rightChild = rotateRight(root.rightChild);
            }
            System.out.println("Left Rotate " + node.value);
            return rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root) {
        AVLNode newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        root.height = setHeight(root);
        newRoot.height = setHeight(newRoot);
        return newRoot;

    }

    private AVLNode rotateRight(AVLNode root) {
        AVLNode newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        root.height = setHeight(root);
        newRoot.height = setHeight(newRoot);
        return newRoot;

    }

    private int setHeight(AVLNode root) {
        return Math.max(height(root.leftChild), height(root.rightChild) + 1);
    }

    /**
     * Get height of Nodes
     */
    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    /**
     * check whether the Node is Left Heavy
     */
    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    /**
     * check whether the Node is Right Heavy
     */
    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    /**
     * Calculate the balance factor
     */
    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }
}



