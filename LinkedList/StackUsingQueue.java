import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue {
    private Queue<Integer> queue;

    public StackUsingQueue() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top: " + stack.top());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Top after pop: " + stack.top());
        System.out.println("Is Empty: " + stack.empty());

        stack.pop();
        stack.pop();

        System.out.println("Is Empty after removing all elements: " + stack.empty());
    }
}