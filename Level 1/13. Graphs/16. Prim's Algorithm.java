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

   static class Pair implements Comparable<Pair>{

      int node;
      String psf;
      int wsf;

      Pair(int node, String psf, int wsf){
         this.node = node;
         this.psf = psf;
         this.wsf = wsf;
      }

      public int compareTo(Pair other){
         // high priority given to the smallest weight
         return this.wsf - other.wsf;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());

      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(src, "" + src, 0));

      boolean[] vis = new boolean[vtces];

      while(pq.size() > 0){

         // remove
         Pair curr = pq.remove();

         // EXTRA STEP -> if(Already visited node/vertex) don't perform any work
         if(vis[curr.node] == true) continue;

         // Mark*
         vis[curr.node] = true;

         // Work
         System.out.println(curr.node + " via " + curr.psf + " @ " + curr.wsf);

         // Add*
         for(Edge e : graph[curr.node]){
            if(vis[e.nbr] == false){
               pq.add(new Pair(e.nbr, curr.psf + e.nbr, curr.wsf + e.wt));
            }
         }
      }

   }
}
