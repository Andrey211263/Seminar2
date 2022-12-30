import java.util.LinkedList;

public class myTurn {
//    int[] array = new int[10];
//    int[] array;
//    int size = 10;
    int index = 0;
    LinkedList<Integer> array = new LinkedList<Integer>();


    public void enqueue(int item) {
        array.add(item);

    }
    public int dequeue() {
        if (array.size() != 0) {
            return array.pollFirst();
        }
        else {
            System.out.println("*Массив пустой, отсутствует элемент для вывода*");
        }
        return 0;
    }
    public int first() {
        return array.getFirst();
    }
    public LinkedList<Integer> get() {
        if (array.size() != 0) {
            return array;
        }
        else {
            System.out.println("*Массив пустой, отсутствует элемент для вывода*");
        }
        return array;
    }
}
