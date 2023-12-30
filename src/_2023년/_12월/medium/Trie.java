package _2023년._12월.medium;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private static class Node {
        boolean isWord = false;
        Map<Character, Node> map = new HashMap<>();
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++) {
            node = node.map.computeIfAbsent(word.charAt(i), k -> new Node());
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++) {
            node = node.map.get(word.charAt(i));
            if(node == null) {
                return false;
            }
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0; i<prefix.length(); i++) {
            node = node.map.get(prefix.charAt(i));
            if(node == null) {
                return false;
            }
        }
        return true;
    }
}
