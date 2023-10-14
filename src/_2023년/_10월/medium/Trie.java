package _2023년._10월.medium;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public static class Node {
        Map<Character,Node> child = new HashMap<>();
        boolean word;
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for(int i=0; i<word.length(); i++) {
            node = node.child.computeIfAbsent(word.charAt(i), c -> new Node());
        }
        node.word = true;
    }

    public boolean search(String word) {
        Node node = root;

        for(int i=0; i<word.length(); i++) {
            node = node.child.get(word.charAt(i));
            if (node == null) {
                return false;
            }
        }
        return node.word;
    }

    public boolean startsWith(String prefix) {
        Node node = root;

        for(int i=0; i<prefix.length(); i++) {
            node = node.child.get(prefix.charAt(i));
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}
