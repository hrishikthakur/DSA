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

   static String smallestPath = "";
   static int smallestPathWt = Integer.MAX_VALUE;

   static String largestPath = "";
   static int largestPathWt = Integer.MIN_VALUE;

   static String ceilPath = "";
   // Ceil -> Badho me sabse chota
   static int ceilWt = Integer.MAX_VALUE;

   static String floorPath = "";
   // Floor -> Choto me sabse badha
   static int floorWt = Integer.MIN_VALUE;

   static int val = 0;
   static int k = 0;
   static PriorityQueue<Pair> pq = new PriorityQueue<>();


   static class Pair implements Comparable<Pair>{

      String pathSofar;
      int weightSofar;

      Pair(String psf, int wsf){
         this.pathSofar = psf;
         this.weightSofar = wsf;
      }

      // min heap
      public int compareTo(Pair other){
         return this.weightSofar - other.weightSofar;
      }

   }


   public static void dfs(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String pathSofar, int weightSofar){

      if(src == dest) {

         // Smallest Path
         if(weightSofar < smallestPathWt){
            smallestPathWt = weightSofar;
            smallestPath = pathSofar;
         }

         // Largest Path
         if(weightSofar > largestPathWt){
            largestPathWt = weightSofar;
            largestPath = pathSofar;
         }

         // Ceil
         if(weightSofar > val && weightSofar < ceilWt){
            ceilWt = weightSofar;
            ceilPath = pathSofar;
         }

         // Floor
         if(weightSofar < val && weightSofar > floorWt){
            floorWt = weightSofar;
            floorPath = pathSofar;
         }

         // Kth Largest Path
         if(pq.size() < k ){
            pq.add(new Pair(pathSofar, weightSofar));

         }else if(weightSofar > pq.peek().weightSofar){
            // if(our batsman > pq me padha worst batsman)
            pq.remove();
            pq.add(new Pair(pathSofar, weightSofar));
         }

         return;
      }

      visited[src] = true;

      for(Edge e : graph[src]){
         if(visited[e.nbr] == false){
            dfs(graph, e.nbr, dest, visited, pathSofar + e.nbr, weightSofar + e.wt);
         }
      }

      visited[src] = false; // unmarking node to visit it again using other paths
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
      int dest = Integer.parseInt(br.readLine());
      val = Integer.parseInt(br.readLine());
      k = Integer.parseInt(br.readLine());

      boolean[] visited = new boolean[vtces];
      dfs(graph, src, dest, visited, "" + src, 0);

      System.out.println("Smallest Path = " + smallestPath + "@" + smallestPathWt);
      System.out.println("Largest Path = " + largestPath + "@" + largestPathWt);
      System.out.println("Just Larger Path than " + val + " = " + ceilPath + "@" + ceilWt);
      System.out.println("Just Smaller Path than " + val + " = " + floorPath + "@" + floorWt);
      System.out.println(k + "th largest path = " + pq.peek().pathSofar + "@" + pq.peek().weightSofar);
   }


}
