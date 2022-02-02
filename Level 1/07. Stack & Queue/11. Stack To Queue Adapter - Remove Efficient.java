public class Main {

  public static class StackToQueueAdapter {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
      helperS = new Stack<>();
    }

    int size() {
      return mainS.size();
    }

    void add(int val) {
      while (mainS.size() > 0)
        helperS.push(mainS.pop());

      mainS.push(val);

      while (helperS.size() > 0)
        mainS.push(helperS.pop());
    }

    int remove() {
      if (mainS.size() == 0) {
        System.out.println("Queue underflow");
        return -1;
      }
      return mainS.pop();
    }

    int peek() {
      if (mainS.size() == 0) {
        System.out.println("Queue underflow");
        return -1;
      }
      return mainS.peek();
    }
  }
