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

   // O(N + E) where,
   // N is the total no. of vertices
   // E is the total no. of edges
   public static void display(ArrayList<Edge>[] graph){

      int vts = graph.length;
      for(int i = 0; i < vts; i++){
         System.out.print(i + ": ");

         for(Edge e : graph[i]){
            System.out.print("{" + e.src + ", "  + e.nbr + ", " + e.wt + "} ");
         }
         System.out.println();
      }

   }

   public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);

      int vts = scn.nextInt();

      ArrayList<Edge>[] graph = new ArrayList[vts];
      for(int i = 0; i < vts; i++)
         graph[i] = new ArrayList<>();

      // no of edges
      int edges = scn.nextInt();

      while(edges-- > 0){
         int v1 = scn.nextInt();
         int v2 = scn.nextInt();
         int wt = scn.nextInt();

         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));

      }

      int src = scn.nextInt();
      int dest = scn.nextInt();

      display(graph);
   }
}
