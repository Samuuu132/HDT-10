package hdt10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    @Test
    public void testAddEdge() {
        Graph g = new Graph();
        g.addEdge(2, 4, 9);
        assertEquals(9, g.getAdjMatrix()[2][4]);
    }

    @Test
    public void testRemoveEdge() {
        Graph g = new Graph();
        g.removeEdge(0, 1);
        assertEquals(Integer.MAX_VALUE / 2, g.getAdjMatrix()[0][1]);
    }

    @Test
    public void testFloydWarshall() {
        Graph g = new Graph();
        int[][] result = g.floydWarshall();
        assertEquals(0, result[0][0]);
        assertTrue(result[0][4] < Integer.MAX_VALUE / 2); // A -> E
    }

    @Test
    public void testCenter() {
        Graph g = new Graph();
        assertEquals("A", g.getCenter());
    }
}
