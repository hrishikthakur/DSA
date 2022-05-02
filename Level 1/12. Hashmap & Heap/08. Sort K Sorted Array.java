public static void sorted(int[] arr, int k){

   PriorityQueue<Integer> pq = new PriorityQueue<>();
   // add k elements
   for(int i = 0; i < k; i++)
      pq.add(arr[i]);

   for(int i = k; i < arr.length; i++){
      pq.add(arr[i]);
      System.out.println(pq.remove());
   }

   while(pq.size() > 0)
      System.out.println(pq.remove());
}
