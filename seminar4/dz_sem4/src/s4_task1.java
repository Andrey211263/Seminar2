//Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет
// “перевернутый”  список.
//

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class s4_task1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Задайте длину массива : ");
        int num = iScanner.nextInt();
        iScanner.close();

        Deque<Integer> str = new LinkedList<Integer>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < num; i++) {
//            str.add(ThreadLocalRandom.current().nextInt(1, num + 1));
            str.add(i);}
        System.out.println(str);

        while(str.peekLast() != null){
            res.add(str.pollLast()); }
        System.out.println(res);

        int count = res.size();
        while (count - 1 > 0){
            res.add(count, res.get(0));
            res.remove(0);
            count--;
        }
        System.out.println(res);
    }
}