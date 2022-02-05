class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        buildGraph(graph, prerequisites, numCourses);
        List<Integer> topologicalOrder = new ArrayList();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!isTopologicalSortPossible(graph, i, visited, topologicalOrder)) {
                    return new int[]{};
                }
            }
        }
        int[] result = new int[topologicalOrder.size()];
        int i = 0;
        for (int num : topologicalOrder) {
            result[i++] = num;
        }
        return result;
    }
    
    private boolean isTopologicalSortPossible(List<Integer>[] graph, int src, int[] visited, List<Integer> topologicalOrder) {
        if (visited[src] != 0) {
            return visited[src] == 1;
        }
        visited[src] = -1;
        for (int i : graph[src]) {
            if (!isTopologicalSortPossible(graph, i, visited, topologicalOrder)) {
                return false;
            }
        }
        visited[src] = 1;
        topologicalOrder.add(src);
        return true;
    }
    
    private void buildGraph(List[] graph, int[][] prerequisites, int n) {
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] edge : prerequisites) {
            graph[edge[0]].add(edge[1]);
        }
    }
}