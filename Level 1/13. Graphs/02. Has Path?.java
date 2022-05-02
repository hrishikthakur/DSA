public static Boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){

   // base case
   if(src == dest) return true;

   // aate hi visited mark kar do
   visited[src] = true;

   for(Edge e : graph[src]){
      if(visited[e.nbr] == false){
         boolean ans = hasPath(graph, e.nbr, dest, visited);
         if(ans == true) return true;
      }
   }

   return false;
}


// boolean[] visited = new boolean[vts];
// System.out.println(hasPath(graph, src, dest, visited));
