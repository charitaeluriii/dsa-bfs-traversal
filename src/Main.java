import java.util.*;
class Graph{
    int vertices;
    LinkedList<Integer>[] adjList;
    @SuppressWarnings("unchecked")
    public Graph(int vertices){
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++){
            adjList[i] = new LinkedList<>();

        }
    }
    public void addEdge(int source , int dest){
        adjList[source].add(dest);
        adjList[dest].add(source);
    }
    public void BFS(int startvertex){
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startvertex);
        System.out.print("BFS traversal from "+startvertex+" : ");
        while(!queue.isEmpty()){
            int currentvertex = queue.poll();
            System.out.print(currentvertex + " ");
            visited[currentvertex] = true;
            for(int neighbor : adjList[currentvertex]){
                if(!visited[neighbor]){
                    queue.add(neighbor);
                    visited[neighbor]= true;
                }
            }
        }
    }
}
class Main{
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        //graph.addEdge(4, 5);
        graph.BFS(3);
    }
}