// MAXHEAP -> O(nlogn + klogn)
public static void approach1(int[] nums, int k){
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    // O(n) -> nums will be required as an ArrayList
    // pq.addAll(nums);

    // O(nlogn)
    for(int i : nums)
        pq.add(i);

    // O(klogn)
    while(k-- > 0){
        System.out.print(pq.remove() + " ");
    }
}

// MINHEAP -> O(K + (n - k)logn)
public static void approach2(int[] nums, int k){
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    // O(klogn)
    for(int i = 0; i < k; i++)
        pq.add(nums[i]);

    // O((n - k)logn)
    for(int i = k; i < nums.length; i++){
        if(nums[i] > pq.peek()){
            pq.remove();
            pq.add(nums[i]);
        }
    }

    // Output space is used here -> neglect
    ArrayList<Integer> name = new ArrayList<Integer>();
    while(pq.size() > 0)
        name.add(pq.remove());

    for(int i = name.size() - 1; i >= 0; i--)
        System.out.print(name.get(i) + " ");
}
