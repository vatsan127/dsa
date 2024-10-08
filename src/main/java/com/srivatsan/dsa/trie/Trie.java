package com.srivatsan.dsa.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Trie {

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        @Override
        public String toString() {
            return "Node{" + "value=" + value + ", children=" + children + ", isEndOfWord=" + isEndOfWord + '}';
        }

        public Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }

    }

    private final Node root = new Node(' ');

    /**
     * Inserts a word into the Trie.
     *
     * @param word the word to be inserted.
     */
    public void insert(String word) {
        Node current = root;
        char[] charArray = word.toCharArray();
        for (Character ch : charArray) {
            if (!current.hasChild(ch)) current.addChild(ch);

            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    /**
     * Checks if the Trie contains a specific word.
     *
     * @param word the word to search for.
     * @return true if the word is found, false otherwise.
     */
    public boolean contains(String word) {
        if (word == null) return false;

        Node current = root;
        char[] charArray = word.toCharArray();
        for (char ch : charArray) {
            if (!current.hasChild(ch)) return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    /**
     * Traverses the Trie and prints all nodes in post-order.
     */
    public void traverse() {
        traverse(root);
    }

    /**
     * A helper function for the traverse method that recursively
     * prints the children of each node in post-order.
     *
     * @param root the root node from which to begin traversal.
     */
    private void traverse(Node root) {
        System.out.println("children: " + Arrays.toString(root.getChildren()));
        for (var child : root.getChildren())
            traverse(child);

        // Post-order: visit the root last
        System.out.println(root.value);
    }

    /**
     * Removes a word from the Trie.
     *
     * @param word the word to remove.
     */
    public void remove(String word) {
        remove(root, word, 0);
    }

    /**
     * A helper function for the remove method. Recursively removes the characters
     * of a word from the Trie, and also deletes nodes if they have no children.
     *
     * @param root  the current node.
     * @param word  the word to remove.
     * @param index the current index of the word.
     */
    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }
        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if (child == null) return;

        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord) {
            root.removeChild(ch);
        }
    }

    /**
     * Finds all words in the Trie that begin with a given prefix.
     *
     * @param prefix the prefix to search for.
     * @return a list of all words that begin with the given prefix.
     */
    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        Node lastNode = findLastNodeOf(prefix);
        System.out.println("lastNode : "+lastNode.toString());
        findWords(lastNode, prefix, words);
        return words;
    }

    /**
     * A helper function for the findWords method. Recursively collects
     * all the words that extend from a given node and prefix.
     *
     * @param root   the current node.
     * @param prefix the prefix string built so far.
     * @param words  the list of words to collect.
     */
    private void findWords(Node root, String prefix, List<String> words) {
        if (root.isEndOfWord) {
            words.add(prefix);
        }

        for (Node child : root.getChildren()) {
            findWords(child, prefix + child.value, words);
        }
    }

    /**
     * Finds the last node of a given prefix in the Trie.
     *
     * @param prefix the prefix to search for.
     * @return the last node of the prefix if it exists, null otherwise.
     */
    private Node findLastNodeOf(String prefix) {
        Node current = root;
        for (char ch : prefix.toCharArray()) {
            Node child = current.getChild(ch);
            if (child == null) {
                return null;
            }
            current = child;
        }
        return current;
    }
}
