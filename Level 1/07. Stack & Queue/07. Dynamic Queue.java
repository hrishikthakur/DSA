// Dynamic queue vs Normal queue == the add function

void add(int val) {
  if (size() == data.length) {  // prefer getters/setters over the attributes themselves
    int[] temp = new int[data.length * 2];
    int counter = size();
    int i = 0;
    int idx = front;
    while (counter-- > 0) {
      temp[i++] =  data[idx];
      idx = (idx + 1) % data.length;
    }
    front = 0;
    rear = size();
    data = temp;
  }
  data[rear] = val;
  size++;
  rear = (rear + 1) % data.length;
}
