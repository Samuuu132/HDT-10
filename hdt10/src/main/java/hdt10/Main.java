package hdt10;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        int[][] result = g.floydWarshall();

        System.out.println("Matriz de caminos más cortos:");
        for (int[] row : result) {
            for (int dist : row)
                System.out.print((dist == Integer.MAX_VALUE / 2 ? "∞" : dist) + "\t");
            System.out.println();
        }

        System.out.println("Centro del grafo: " + g.getCenter());
    }
}
