package _2023년._8월.medium;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWordsDataStructure {
    class WordDictionary {
        class Node {
            Map<Character, Node> childs = new HashMap<>();
            boolean word;
        }

        Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node node = root;

            for(int i=0; i<word.length(); i++) {
                node = node.childs.computeIfAbsent(word.charAt(i), c -> new Node());
            }
            node.word = true;
        }

        public boolean search(String word) {
            return search(root, word);
        }

        private boolean search(Node node, String word) {
            if(word.length() == 0)
                return node.word;

            if(word.charAt(0) == '.') {
                for(char c : node.childs.keySet()) {
                    if(search(node.childs.get(c), word.substring(1)))
                        return true;
                }
            }

            if(!node.childs.containsKey(word.charAt(0)))
                return false;

            return search(node.childs.get(word.charAt(0)), word.substring(1));
        }
    }
}
