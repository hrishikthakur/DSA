public static class Pair implements Comparable<Pair>{
   int data, listIdx, dataIdx;

   Pair(){}
   Pair(int data, int listIdx, int dataIdx){
      this.data = data;
      this.listIdx = listIdx; // to know that which arraylist element belongs to
      this.dataIdx = dataIdx; // to know index of next element to be inserted from that arraylist
   }

   public int compareTo(Pair other){
      // compare Pair on basis of data, smaller data -> higher priority
      // MINHEAP on the basis of data
      return this.data - other.data;
   }
}

public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
   PriorityQueue<Pair> pq = new PriorityQueue<>();
   ArrayList<Integer> res = new ArrayList<>();

   // Insert 0th idx element of each ArrayList
   // at any given time k elements will be present in the pq
   // O(k * log k)
   for(int i = 0; i < lists.size(); i++){
      pq.add(new Pair(lists.get(i).get(0), i, 0));
   }

   // O(Nt * logk)
   while(pq.size() > 0){
      Pair top = pq.remove();
      res.add(top.data);

      if(top.dataIdx + 1 < lists.get(top.listIdx).size()){
         // insert next Pair
         pq.add(new Pair(lists.get(top.listIdx).get(top.dataIdx + 1), top.listIdx, top.dataIdx + 1));
      }
   }

   // O(Nt * logk + k * logk) where Nt = n1 + n2 + n3 + ... nk
   return res;
}
