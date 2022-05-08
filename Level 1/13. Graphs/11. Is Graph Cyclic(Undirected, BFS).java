import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   // BFS -> Undirected Graph
   public static boolean cycleDetection(ArrayList<Edge> graph[], boolean[] visited, int src){

      Queue<Integer> q = new LinkedList<>();
      q.add(src);

      while(q.size() > 0){

         // remove
         int curr = q.remove();

         // if element is already visited, it implies uss element takk jaane k 2 paths hai
         // which implies that there is a cycle present
         if(visited[curr] == true) return true;

         // M*
         visited[curr] = true;

         // A*
         for(Edge e : graph[curr]){
            if(visited[e.nbr] == false){
               q.add(e.nbr);
            }
         }

      }

      return false;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      boolean[] visited = new boolean[vtces];
      for(int i = 0; i < vtces; i++){

         if(visited[i] == false){
            // implies a new component -> Call BFS on this new Component
            boolean isCycle = cycleDetection(graph, visited, i);
            if(isCycle == true){
               System.out.println("true");
               return; // I MISSED THIS RETURN OUT
            }
         }

      }

      System.out.println("false");
   }
}

// Algo
// isCyclic == true iff node is already visited and is not the parent of our node

// Queue me push karna hoga src, parent
static class Pair{

   int src;
   int par;

   Pair(int src, int par){
      this.src = src;
      this.par = par;
   }
}

// BFS -> Undirected Graph
public static boolean cycleDetection(ArrayList<Edge> graph[], boolean[] visited, int src){

   Queue<Pair> q = new LinkedList<>();
   q.add(new Pair(src, -1));
   visited[src] = true;

   while(q.size() > 0){

      // remove
      Pair curr = q.remove();

      // A*
      for(Edge e : graph[curr.src]){
         if(visited[e.nbr] == false){
            visited[e.nbr] = true;
            q.add(new Pair(e.nbr, curr.src));

         }else{
            if(curr.par != -1 && e.nbr != curr.par){
               return true;
            }
         }
      }

   }

   return false;
}
