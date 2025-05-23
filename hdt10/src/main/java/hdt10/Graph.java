package hdt10;

import java.util.Arrays;

public class Graph {
    private final int size = 5;
    private final int INF = Integer.MAX_VALUE / 2;
    private int[][] adjMatrix = new int[size][size];
    private String[] vertices = {"A", "B", "C", "D", "E"};

    public Graph() {
        for (int i = 0; i < size; i++)
            Arrays.fill(adjMatrix[i], INF);
        for (int i = 0; i < size; i++)
            adjMatrix[i][i] = 0;

        adjMatrix[0][1] = 3; // A a B
        adjMatrix[0][3] = 7; // A a D
        adjMatrix[1][2] = 1; // B a C
        adjMatrix[1][4] = 8; // B a E
        adjMatrix[2][3] = 2; // C a D
        adjMatrix[3][4] = 3; // D a E
        adjMatrix[4][0] = 4; // E a A
    }

    public int[][] floydWarshall() {
        int[][] dist = new int[size][size];
        for (int i = 0; i < size; i++)
            dist[i] = Arrays.copyOf(adjMatrix[i], size);

        for (int k = 0; k < size; k++)
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        return dist;
    }

    public String getCenter() {
        int[][] dist = floydWarshall();
        int min = INF;
        int index = -1;

        for (int i = 0; i < size; i++) {
            int maxDist = 0;
            for (int j = 0; j < size; j++) {
                if (dist[i][j] > maxDist)
                    maxDist = dist[i][j];
            }
            if (maxDist < min) {
                min = maxDist;
                index = i;
            }
        }

        return vertices[index];
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void addEdge(int from, int to, int weight) {
        adjMatrix[from][to] = weight;
    }

    public void removeEdge(int from, int to) {
        adjMatrix[from][to] = INF;
    }
}
