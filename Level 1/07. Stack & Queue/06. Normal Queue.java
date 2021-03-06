public static class CustomQueue {
  int[] data;
  int front;
  int rear;
  int size;

  public CustomQueue(int cap) {
    data = new int[cap];
    front = 0;
    rear = 0;
    size = 0;
  }

  int size() {
    return size;
  }

  void display() {
    int counter = size();
    int idx = front;
    while (counter-- > 0) {
      System.out.print(data[idx] + " ");
      idx = (idx + 1) % data.length;
    }
    System.out.println();
  }

  void add(int val) {
    if (size() == data.length) {  // prefer getters/setters over the attributes themseleves
      System.out.println("Queue overflow");
      return;
    }
    data[rear] = val;
    size++;
    rear = (rear + 1) % data.length;
  }

  int remove() {
    if (size() == 0) {
      System.out.println("Queue underflow");
      return -1;
    }
    int val = data[front];
    size--;
    front = (front + 1) % data.length;
    return val;
  }

  int peek() {
    if (size() == 0) {
      System.out.println("Queue underflow");
      return -1;
    }
    int val = data[front];
    return val;
  }
}
