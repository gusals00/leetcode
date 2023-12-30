package _2023년._12월.medium;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    private static class Node {
        boolean isWord = false;
        Map<Character, Node> map = new HashMap<>();
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++) {
            node = node.map.computeIfAbsent(word.charAt(i), k -> new Node());
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node node) {
        if(word.length() == 0) {
            return node.isWord;
        }

        if(word.charAt(0) == '.') {
            for (char c : node.map.keySet()) {
                if(search(word.substring(1), node.map.get(c))) {
                    return true;
                }
            }
        }

        if(!node.map.containsKey(word.charAt(0))) {
            return false;
        }

        return search(word.substring(1), node.map.get(word.charAt(0)));
    }
}
