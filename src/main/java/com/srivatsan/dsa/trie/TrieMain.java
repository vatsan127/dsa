package com.srivatsan.dsa.trie;

public class TrieMain {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("hel");
        trie.insert("birds");
        System.out.println(trie.contains("hel"));
//        trie.remove("hel");
        System.out.println(trie.contains("hel"));

        System.out.println(trie.findWords("h"));

    }
}
