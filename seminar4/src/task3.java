import java.util.*;

public class task3 {
    static List<String> list;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        toDeque(arr);
        System.out.println();
        toQueue(arr);


    }

    static void toDeque(int[] arr) {
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            deq.push(arr[i]);
        }
        while (!deq.isEmpty()) {
            System.out.print(deq.pop() + " ");
        }
    }

    static void toQueue(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }
        while (q.peek() != null) {
            System.out.print(q.poll() + " ");
        }
    }
}