package _2023년._8월.medium;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {

    class Trie {

        class Node {
            Map<Character, Node> childs = new HashMap<>();
            boolean word;
        }

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;

            for(int i=0; i<word.length(); i++) {
                node = node.childs.computeIfAbsent(word.charAt(i), c -> new Node());
            }
            node.word = true;
        }

        public boolean search(String word) {
            Node node = root;

            for(int i=0; i<word.length(); i++) {
                node = node.childs.getOrDefault(word.charAt(i), null);
                if(node == null)
                    return false;
            }

            return node.word;
        }

        public boolean startsWith(String prefix) {
            Node node = root;

            for(int i=0; i<prefix.length(); i++) {
                node = node.childs.getOrDefault(prefix.charAt(i), null);
                if(node == null)
                    return false;
            }

            return true;
        }
    }
}
