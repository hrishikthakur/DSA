// Method 1 -> This is Sufficient & best
// ALGO -> R M* W A*

import java.io.*;
import java.util.*;

public class Main {

   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   static class Pair{
      int vtx;
      String pathSofar;

      Pair(int vtx, String pathSofar){
         this.vtx = vtx;
         this.pathSofar = pathSofar;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      Queue<Pair> q = new LinkedList<>();
      q.add(new Pair(src, "" + src));

      boolean[] visited = new boolean[vtces];
      while(q.size() > 0){

         // Remove
         Pair curr = q.remove();

         // if(curr vtx has already been visitd)
         // all its edges have already been explored -> Continue;
         // NOTE : Mark* is done after removal
         if(visited[curr.vtx] == true) continue;

         // Mark*
         visited[curr.vtx] = true;

         // Work -> Print
         System.out.println(curr.vtx + "@" + curr.pathSofar);

         // Add*
         for(Edge e : graph[curr.vtx]){
            if(visited[e.nbr] == false){
               q.add(new Pair(e.nbr, curr.pathSofar + e.nbr));
            }
         }
      }


   }
}

// Method 2
// Algo -> Node add karte hi mark visited
// R W (M* A*w)
// * => unvisited

boolean[] visited = new boolean[vtces];
Queue<Pair> q = new LinkedList<>();

q.add(new Pair(src, "" + src));
visited[src] = true;

while(q.size() > 0){

   // Remove
   Pair curr = q.remove();

   // Work -> Print
   System.out.println(curr.vtx + "@" + curr.pathSofar);

   // Add*
   for(Edge e : graph[curr.vtx]){
      if(visited[e.nbr] == false){
         visited[e.nbr] = true;
         q.add(new Pair(e.nbr, curr.pathSofar + e.nbr));
      }
   }

}

// Method 3
// BFS Using PriorityQueue => Priority is given to shortest length
static class Pair implements Comparable<Pair>{
   int node;
   String pathSofar;
   int weightSofar;

   Pair(int node, String pathSofar, int weightSofar){
       this.node = node;
       this.pathSofar = pathSofar;
       this.weightSofar = weightSofar;
   }

   public int compareTo(Pair other){
       return this.weightSofar - other.weightSofar;
   }
}
