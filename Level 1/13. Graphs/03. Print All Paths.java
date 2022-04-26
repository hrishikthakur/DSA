public static void dfs(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String pathSofar){

   if(src == dest) System.out.println(pathSofar);

   visited[src] = true;

   for(Edge e : graph[src]){
      if(visited[e.nbr] == false){
         dfs(graph, e.nbr, dest, visited, pathSofar + e.nbr);
      }
   }

   visited[src] = false; // unmarking node to visit it again using other paths
}


// boolean[] visited = new boolean[vtces];
// dfs(graph, src, dest, visited, "" + src);
