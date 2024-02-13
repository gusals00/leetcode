package _2024년._2월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {
    Deque<Pair> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }
        stack.push(new Pair(price, span));

        return span;
    }

    private static class Pair {
        int price;
        int span;

        public Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }
}
