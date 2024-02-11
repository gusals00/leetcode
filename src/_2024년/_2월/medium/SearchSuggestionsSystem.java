package _2024년._2월.medium;

import java.util.*;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();

        for (String product : products) {
            add(root, product);
        }

        List<List<String>> result = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            if((root = root.childs[c - 'a']) == null)
                break;
            result.add(root.getThree());
        }

        while (result.size() < searchWord.length())
            result.add(new ArrayList<>());

        return result;
    }

    private void add(TrieNode root, String product) {
        for (char c : product.toCharArray()) {
            if(root.childs[c - 'a'] == null) {
                root.childs[c - 'a'] = new TrieNode();
            }
            root = root.childs[c - 'a'];
            root.add(product);
        }
    }

    private static class TrieNode {
        TrieNode[] childs;
        PriorityQueue<String> queue;

        public TrieNode() {
            childs = new TrieNode[26];
            queue = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void add(String word) {
            queue.add(word);
            if(queue.size() > 3) {
                queue.remove();
            }
        }

        public List<String> getThree() {
            List<String> result = new ArrayList<>();
            while(!queue.isEmpty()) {
                result.add(queue.remove());
            }
            Collections.reverse(result);
            return result;
        }
    }
}