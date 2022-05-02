public static class Student implements Comparable<Student>{
    int rollNo, marks, weight;

    Student(){}
    Student(int rollNo, int marks, int weight){
        this.rollNo = rollNo;
        this.marks = marks;
        this.weight = weight;
    }
    public String toString(){
        return ("rollNo = " + this.rollNo + ", marks = " + this.marks + ", weight = " + this.weight);
    }

    public int compareTo(Student other){
        // Smaller Roll No -> Greater Priority
        return this.rollNo - other.rollNo;
    }
  }

  public static class StudentWtComparator implements Comparator<Student>{
      public int compare(Student s1, Student s2){
          // Higher Weight - Higher Priority
          return s2.weight - s1.weight;
      }
  }

  public static class StudentMrksComparator implements Comparator<Student>{
      public int compare(Student s1, Student s2){
          // Higher Marks - Higher Priority
          return s2.marks - s1.marks;
      }
  }

  // ********************************************** Priorityqueue Class **********************************************

  public static class Priorityqueue<K> {
    public ArrayList<K> data;
    private int size;
    private Comparator<K> comp;

    // NO - Args
    public Priorityqueue() {
      data = new ArrayList<>();
      size = 0;
      this.comp = null;
    }

    // Single Args -> f
    public Priorityqueue(Comparator<K> comp) {
        data = new ArrayList<>();
        size = 0;
        this.comp = comp;
    }


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


    public void add(K val) {
        // O(log n)

        data.add(val);
        size++;
        upheapify(size() - 1);
    }


    public boolean isSmaller(int i1, int i2){
        K s1 = data.get(i1);
        K s2 = data.get(i2);

        if(comp == null){
            // means no args contructor is executed
            // hence call Comparable interface -> CompareTo method
            // for using s1c.compareTo(s2c)
            // s1c and s2c must be of type "Comparable"
            Comparable s1c = (Comparable)s1;
            Comparable s2c = (Comparable)s2;

            // s1.compareTo(s2) will not work
            if(s1c.compareTo(s2c) < 0)
                return true;
            return false;

        } else {
            // Call Comparator interface -> Compare
            if(comp.compare(s1, s2) < 0)
                return true;
            return false;
        }
    }


    // i1 & i2 are indices
    public void swap(int i1, int i2){
        K temp = data.get(i1);
        data.set(i1, data.get(i2));
        data.set(i2, temp);
    }


    // O(log N) where N = number of nodes in CBT, & logN is height of tree
    public void upheapify(int idx){
        int parIdx = (idx - 1) / 2;

        if(isSmaller(idx, parIdx)){
            swap(idx, parIdx);
            upheapify(parIdx);
        }
    }


    public K remove() {
        // O(log n)
        if(size() == 0){
            System.out.println("Underflow");
            return null;
        }

        K val = peek();
        swap(0, size() - 1);
        // data.remove(size() - 1);
        size--;

        downheapify(0);
        return val;
    }


    public void downheapify(int idx){
        int min = idx;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if(left < size && isSmaller(left, min)){
            min = left;
        }

        if(right < size && isSmaller(right, min)){
            min = right;
        }

        if(min != idx){
            swap(idx, min);
            downheapify(min);
        }
    }


    public K peek() {
        // O(1)
        if(size() == 0){
            System.out.println("Underflow");
            return null;
        }

        return data.get(0);
    }


    public int size() {
        // O(1)
        return size;
    }


    // public ArrayList<Integer> heapSort(){
    //     ArrayList<Integer> sorted = new ArrayList<>();

    //     // nlogn
    //     while(size() > 0){
    //         int val = remove();
    //         sorted.add(val);
    //     }

    //     return sorted;
    // }

    // In Place Heap Sort -> O(1) Extra Space
    public ArrayList<K> heapSort(){
        while(size() > 0){
            remove();
        }

        return data;
    }
}


public static void main(String[] args) throws Exception {

    Priorityqueue<Student> pq = new Priorityqueue<>(new StudentWtComparator());

    pq.add(new Student(30, 90, 40));
    pq.add(new Student(20, 99, 60));
    pq.add(new Student(50, 97, 80));
    pq.add(new Student(10, 100, 50));
    pq.add(new Student(40, 80, 110));

    while(pq.size() > 0){
        Student top = pq.remove();
        System.out.println(top);
    }

}
