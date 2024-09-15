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
        BinaryTrees binaryTrees = new BinaryTrees();
        BinaryTrees binaryTrees2 = new BinaryTrees();
        for (Integer i : data1) {
            binaryTrees.insert(i);
        }
        for (Integer i : data2) {
            binaryTrees2.insert(i);
        }

        // Traverse PreOder
        binaryTrees.preOrderTraverse();

        // Traverse PostOrder
        binaryTrees.postOrderTraverse();

        // Traverse InOrder
        binaryTrees.inOrderTraverse();

        // find whether an element exists
        System.out.println(binaryTrees.find(8));

        // find Min value in Binary Tree
        System.out.println(binaryTrees.findMinValue());

        // find Min value in BST
        System.out.println(binaryTrees.findMinValueInBST());

        // compare 2 Binary Trees
        System.out.println(binaryTrees.compareTrees(binaryTrees2));

        // Get nodes at a distance from node
        binaryTrees.getNodeAtDistance(1);

        // Level Order Traversal in Binary Tree
        binaryTrees.levelOrderTraversal();

        // Get the Max Height of the Binary Tree
        System.out.println("height : " + binaryTrees.height());

    }
}
