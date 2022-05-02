public static class Student implements Comparable<Student>{
    int rollNo, marks, weight;

    Student(){}
    Student(int rollNo, int marks, int weight){
        this.rollNo = rollNo;
        this.marks = marks;
        this.weight = weight;
    }

    @Override
    // public likhna was necessary
    public String toString(){
        return ("rollNo = " + this.rollNo + ", marks = " + this.marks + ", weight = " + this.weight);
    }


    public int compareTo(Student other){
        // Smaller Roll No -> Greater Priority
        return this.rollNo - other.rollNo;
    }

}


// ************************************************ Comparators  Classes ************************************************

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
// **************************************************************************************************************


public static void main(String[] args) throws Exception {

    // Overriding the "toString()" ->
    // Student s = new Student(30, 90, 100);
    // System.out.println(s);
    // if "toString()" wouldn't have been overriden then SOP ne row diya hota

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
