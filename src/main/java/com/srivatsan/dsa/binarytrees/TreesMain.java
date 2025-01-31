package com.srivatsan.dsa.binarytrees;

import java.util.List;

public class TreesMain {
    public static void main(String[] args) {

        /* 8, 6, 7, 2, 5, 12, 15, 10 */
//                  8
//                /    \
//              6   	12
//             /  \    /  \
//            2    7  10   15
//           / \
//        NULL  5


        List<Integer> data1 = List.of(8, 6, 7, 2, 5, 12, 15, 10);
        List<Integer> data2 = List.of(8, 1, 7, 2, 5, 12, 15, 10);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        BinarySearchTree binarySearchTree2 = new BinarySearchTree();
        for (Integer i : data1) {
            binarySearchTree.insert(i);
        }
        for (Integer i : data2) {
            binarySearchTree2.insert(i);
        }

        // Traverse PreOder
        binarySearchTree.preOrderTraverse();

        // Traverse PostOrder
        binarySearchTree.postOrderTraverse();

        // Traverse InOrder
        binarySearchTree.inOrderTraverse();

        // find whether an element exists
        System.out.println(binarySearchTree.find(8));

        // find Min value in Binary Tree
        System.out.println(binarySearchTree.findMinValue());

        // find Min value in BST
        System.out.println(binarySearchTree.findMinValueInBST());

        // compare 2 Binary Trees
        System.out.println(binarySearchTree.compareTrees(binarySearchTree2));

        // Get nodes at a distance from node
        binarySearchTree.getNodeAtDistance(1);

        // Level Order Traversal in Binary Tree
        binarySearchTree.levelOrderTraversal();

        // Get the Max Height of the Binary Tree
        System.out.println("height : " + binarySearchTree.height());

    }
}
