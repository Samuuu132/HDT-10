class GraphPy:
    def __init__(self):
        self.size = 5
        self.INF = float('inf')
        self.adj_matrix = [
            [0,   3,   self.INF, 7,   self.INF],
            [self.INF, 0,   1,   self.INF, 8],
            [self.INF, self.INF, 0,   2,   self.INF],
            [self.INF, self.INF, self.INF, 0,   3],
            [4,   self.INF, self.INF, self.INF, 0]
        ]
        self.vertices = ["A", "B", "C", "D", "E"]

    def floyd_warshall(self):
        dist = [row[:] for row in self.adj_matrix]
        for k in range(self.size):
            for i in range(self.size):
                for j in range(self.size):
                    if dist[i][k] + dist[k][j] < dist[i][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
        return dist

    def get_center(self):
        dist = self.floyd_warshall()
        ecc = []
        for i in range(self.size):
            ecc.append(max(dist[i]))
        center_index = ecc.index(min(ecc))
        return self.vertices[center_index]

if __name__ == "__main__":
    g = GraphPy()
    result = g.floyd_warshall()
    print("Matriz de caminos más cortos:")
    for row in result:
        print('\t'.join('∞' if x==g.INF else str(x) for x in row))
    print("Centro del grafo:", g.get_center())
