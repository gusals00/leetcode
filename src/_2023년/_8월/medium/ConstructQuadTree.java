package _2023년._8월.medium;

public class ConstructQuadTree {

    public Node construct(int[][] grid) {
        return recur(grid.length, grid, 0, 0);
    }

    private Node recur(int length, int[][] grid, int x, int y) {
        if(checkSame(grid, x, y, length))
            return new Node(grid[x][y]==1, true);
        else {
            length = length/2;

            Node node = new Node(false, false);
            node.topLeft = recur(length, grid, x, y);
            node.topRight = recur(length, grid, x, y + length);
            node.bottomLeft = recur(length, grid, x + length, y);
            node.bottomRight = recur(length, grid, x + length, y + length);
            return node;
        }
    }

    private boolean checkSame(int[][] grid, int x, int y, int length) {
        for(int i=x; i<x+length; i++) {
            for(int j=y; j<y+length; j++) {
                if(grid[i][j] != grid[x][y])
                    return false;
            }
        }

        return true;
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
