// *******Class************
public static class PriorityQueue {
  ArrayList<Integer> data;
  private int size;

  // CONSTRUCTOR
  public PriorityQueue() {
    data = new ArrayList<>();
    size = 0;
  }

  // EFFICIENT CONSTRUCTOR
  // O(n) for inserting n elements -> per element O(1)
  public Priorityqueue(K[] arr){
      data = new ArrayList<>();

      for(K val: arr){
          data.add(val);
          size++;
      }

      int lastIdx = size() - 1;
      int lastIdxPar = (lastIdx - 1) /2;
      for(int i=lastIdxPar; i>=0; i--){
          downheapify(i);
      }
  }

  // ********************************** Required for 'add' & 'remove' **********************************
  public boolean isSmaller(int i1, int i2){
    if(data.get(i1) < data.get(i2)) return true;
    return false;
  }


  public void swap(int i1, int i2){
    int temp = data.get(i1);
    data.set(i1, data.get(i2));
    data.set(i2, temp);
  }


  // no base case is required for upheapify, coz called only when if condition is satisfied
  // O(log N) where N = number of nodes in CBT, & logN is height of tree
  public void upheapify(int idx){
    int parIdx = (idx - 1) / 2;

    if(isSmaller(idx, parIdx)){
      // if(our element is smaller than the parent element)
      // i) swap ii) call upheapify
      swap(idx, parIdx);
      upheapify(parIdx);
    }
  }


  public void downheapify(int idx){

    int min = idx;
    int left = (2 * idx) + 1;
    int right = (2 * idx) + 2;

    if(left < size && isSmaller(left, min)) min = left;
    if(right < size && isSmaller(right, min)) min = right;

    // to avoid infinite recursion due to downheapify this if condition is necessary
    if(min != idx){
      swap(idx, min);
      downheapify(min);
    }
  }
  // *************************************************************************************************

  public void add(int val) {
    // O(log n)
    data.add(val);
    size++;
    upheapify(size() - 1); // upheapify call kar diya last idx ko
  }


  public int remove() {
    // O(log n)
    if(size() == 0){
      System.out.println("Underflow");
      return -1;
    }
    int val = peek();
    swap(0, size() - 1);
    // data.remove(size() - 1);
    size--;
    downheapify(0);
    return val;
  }


  public int peek() {
    // O(1)
    if(size == 0){
      System.out.println("Underflow");
      return -1;
    }
    return data.get(0);
  }


  public int size() {
    // O(1)
    return size;
  }


  public ArrayList<Integer> heapSort1(){
    ArrayList<Integer> sorted = new ArrayList<>();
      // O(nlogn)
      while(size() > 0){
        int val = remove();
        sorted.add(val);
      }
      return sorted;
  }


  // Introduced a size property
  // When remove is called -> size-- ... actual element is not removed
  // intead of returning the method size() ... size data member is returned
  // In Place Heap Sort -> O(1) Extra Space
  public ArrayList<Integer> heapSort2(){
      while(size() > 0){
          remove(); // only size -- no actual removal
      }

      return data;
  }

}

public static void main(String[] args) throws Exception {
  // int[] arr = {20, 50, 30, 10, 40, 60};
  // PriorityQueue qu = new PriorityQueue(arr); // USING OUR EFFICIENT CONSTRUCTOR

  // one by one insertion -> O(nlogn)
  // qu.add(20);
  // qu.add(50);
  // qu.add(30);
  // qu.add(10);
  // qu.add(40);
  // qu.add(60);

  // ArrayList<Integer> res = qu.heapSort();
  // System.out.println(res); // sorted ArrayList but the original qu becomes empty

}
