// Bipartite -> DFS
// BFS given in video

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

   // can be done using int[] vis to store
   // -1 -> Not visited
   // 0 -> Even visited
   // 1 -> Odd visited
   public static boolean dfs(ArrayList<Edge> graph[], int src, HashSet<Integer> odd, HashSet<Integer> even, boolean[] vis, int level){

      vis[src] = true;
      if(level % 2 == 0) even.add(src);
      else odd.add(src);

      for(Edge e : graph[src]){

         if(vis[e.nbr] == false){

            boolean ans = dfs(graph, e.nbr, odd, even, vis, level + 1);
            if(ans == false) return false;

         }else{
            // cycle detected

            // Src par khade hoke nbr ka decision le rahe hai -> level + 1
            if(odd.contains(e.nbr) == true && (level + 1) % 2 == 0){
               // pehle odd me added tha ab even me add hona chahta hai
               return false;
            }

            if(even.contains(e.nbr) == true && (level + 1) % 2 == 1){
               // pehle even me tha ab odd me add hona chahta hai
               return false;
            }

         }

      }

      // ye component toh bipartite tha
      return true;
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

      HashSet<Integer> odd = new HashSet<>();
      HashSet<Integer> even = new HashSet<>();
      boolean[] vis = new boolean[vtces];

      // for every component call DFS
      for(int i = 0; i < vtces; i++){

         if(vis[i] == false){

            boolean isBipartite = dfs(graph, i, odd, even, vis, 0);
            if(isBipartite == false){
               // ek component mill gya jo bipartite nhi hai
               System.out.println("false");
               return;
            }
         }

      }

      System.out.println("true");
   }
}
