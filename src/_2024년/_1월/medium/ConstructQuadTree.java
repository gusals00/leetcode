package _2024년._1월.medium;

public class ConstructQuadTree {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length);
    }

    private Node dfs(int[][] grid, int x, int y, int length) {
        if(isSameValue(grid, x, y, length)) {
            return new Node(grid[x][y]==1, true);
        } else {
            length /= 2;
            Node node = new Node(false, false);
            node.topLeft = dfs(grid, x, y, length);
            node.topRight = dfs(grid, x, y+length, length);
            node.bottomLeft = dfs(grid, x+length, y, length);
            node.bottomRight = dfs(grid, x+length, y+length, length);

            return node;
        }
    }

    private boolean isSameValue(int[][] grid, int x, int y, int length) {
        int check = grid[x][y];
        for(int i=x; i<x+length; i++) {
            for(int j=y; j<y+length; j++) {
                if(check != grid[i][j]) {
                    return false;
                }
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
