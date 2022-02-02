/**
 * @param {number[][]} isConnected
 * @return {number}
 */

 class Graph {
    static dfs_rec_adjcyMtrx2(G, V, u, visited) {
        for (let v = 0; v < V; v++) {
            if (G[u][v] && !visited[v]) {
                visited[v] = 1;
                this.dfs_rec_adjcyMtrx2(G, V, v, visited);
            }
        }
        return true;
    }

    static dfs_rec_adjcyMtrx(G, V = G.length) {
        let count = 0;
        const visited = new Array(V).fill(0);
        for (let u = 0; u < V; u++) {
            if (!visited[u]) {
                this.dfs_rec_adjcyMtrx2(G, V, u, visited);
                count++;
            }
        }
        return count;
    }
}

var findCircleNum = function(isConnected) {
    return Graph.dfs_rec_adjcyMtrx(isConnected);
};