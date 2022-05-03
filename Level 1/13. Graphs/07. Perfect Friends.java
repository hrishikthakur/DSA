import java.io.*;
import java.util.*;

public class Main {

   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr){
         this.src = src;
         this.nbr = nbr;
      }

      Edge(int src, int nbr, int wt){
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   // keep dfs as void for future -> Trust me on this one
   public static void dfs(ArrayList<Edge>[] graph, int src, boolean[] visited, int[] count){

      visited[src] = true;

      count[0]++;
      // for - each loop is easier
      for(Edge e : graph[src]){
         if(visited[e.nbr] == false){
            dfs(graph, e.nbr, visited, count);
         }
      }

   }

   public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);

      int vtces = scn.nextInt();
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for(int vtx = 0; vtx < vtces; vtx++){
         graph[vtx] = new ArrayList<>();
      }

      int edges = scn.nextInt();
      for(int edg = 0; edg < edges; edg++){
         int v1 = scn.nextInt();
         int v2 = scn.nextInt();

         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      ArrayList<Integer> noOfConnectedComps = new ArrayList<>();
      boolean[] visited = new boolean[vtces];
      for(int vtx = 0; vtx < vtces; vtx++){
         int[] count = new int[1];
         if(visited[vtx] == false){
            dfs(graph, vtx, visited, count);
         }
         noOfConnectedComps.add(count[0]);
      }

      // To get the sum of further elements -> APPROACH 1
      int ans = 0;
      for(int i = 0; i < noOfConnectedComps.size(); i++){
         for(int j = i + 1; j < noOfConnectedComps.size(); j++){
            ans += noOfConnectedComps.get(i) * noOfConnectedComps.get(j);
         }
      }

      // To get the sum of further elements -> APPROACH 2
      int totalComps = vtces;
      for(int comp : noOfConnectedComps){

      }

      System.out.println(ans);
      // System.out.println(noOfConnectedComps);
   }

}
