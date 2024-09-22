package com.srivatsan.dsa.avl;

/**
 * AVL Trees are a type of self-balancing binary search tree.
 * In an AVL tree, for every node, the difference between the height of the left and right subtrees
 * (called the balance factor) must be less than or equal to one.
 * - balanceFactor = height(left) - height(right)
 * - balanceFactor > 1 indicates a left-heavy tree.
 * - balanceFactor < -1 indicates a right-heavy tree.
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

    private AVLNode root; // Root node of the AVL tree

    /**
     * Public method to insert a value into the AVL tree.
     *
     * @param value The value to be inserted.
     */
    public void insert(int value) {
        root = insert(root, value);
    }

    /**
     * Private method to insert a value recursively.
     *
     * @param root  The root of the current subtree.
     * @param value The value to be inserted.
     * @return The new root of the subtree after insertion and balancing.
     */
    private AVLNode insert(AVLNode root, int value) {
        if (root == null) return new AVLNode(value);
        if (value < root.value) {
            root.leftChild = insert(root.leftChild, value);
        } else {
            root.rightChild = insert(root.rightChild, value);
        }
        root.height = setHeight(root);
        return balance(root);
    }

    /**
     * Balances the AVL tree at the given node if it has become unbalanced.
     *
     * @param node The node to balance.
     * @return The new root of the subtree after balancing.
     */
    private AVLNode balance(AVLNode node) {
        if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) < 0) {
                node.leftChild = rotateLeft(node.leftChild);
            }
            return rotateRight(node);
        } else if (isRightHeavy(node)) {
            if (balanceFactor(node.rightChild) > 0) {
                node.rightChild = rotateRight(node.rightChild);
            }
            return rotateLeft(node);
        }
        return node;
    }

    /**
     * Performs a left rotation on the subtree rooted at the given node.
     *
     * @param root The root of the subtree to rotate left.
     * @return The new root of the subtree after rotation.
     */
    private AVLNode rotateLeft(AVLNode root) {
        AVLNode newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        root.height = setHeight(root);
        newRoot.height = setHeight(newRoot);
        return newRoot;
    }

    /**
     * Performs a right rotation on the subtree rooted at the given node.
     *
     * @param root The root of the subtree to rotate right.
     * @return The new root of the subtree after rotation.
     */
    private AVLNode rotateRight(AVLNode root) {
        AVLNode newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        root.height = setHeight(root);
        newRoot.height = setHeight(newRoot);
        return newRoot;
    }

    /**
     * Sets the height of the given node based on its children.
     *
     * @param root The node for which to set the height.
     * @return The height of the node.
     */
    private int setHeight(AVLNode root) {
        return Math.max(height(root.leftChild), height(root.rightChild)) + 1;
    }

    /**
     * Gets the height of a node.
     *
     * @param node The node whose height is to be retrieved.
     * @return The height of the node, or -1 if the node is null.
     */
    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    /**
     * Checks if the node is left-heavy.
     *
     * @param node The node to check.
     * @return True if the node is left-heavy; otherwise, false.
     */
    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    /**
     * Checks if the node is right-heavy.
     *
     * @param node The node to check.
     * @return True if the node is right-heavy; otherwise, false.
     */
    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    /**
     * Calculates the balance factor of a node.
     *
     * @param node The node whose balance factor is to be calculated.
     * @return The balance factor of the node.
     */
    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }
}
