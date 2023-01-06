// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди
// и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
// (Подобную задачу решали на семинаре. Здесь так же нужно создать класс, который
// будет реализовывать указанные методы)


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

import static java.lang.System.out;

public class s4_task2 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        myTurn str = new myTurn();
        out.println(str.get());

        boolean triger = true;
        while (triger == true) {
            out.print("Поместить элемент в конец очереди: 1\n" +
                    "Возврат первого элемента из очереди с удалением: 2\n" +
                    "Возврат первого элемента из очереди без удаления: 3\n" +
                    "Просмотр списка: 4\n" +
                    "Выход: 0\n");
            int choice = iScanner.nextInt();
            switch (choice) {
                case 1 -> {
                    out.print("**Введите число для добавления в массив:");
                    str.enqueue(iScanner.nextInt());
                }
                case 2 -> {
                    out.println("**Вы удалили: "+str.dequeue());
                }
                case 3 -> {
                    out.println("**Первый элемент списка: "+str.first());
                    out.println(str.get());
                }
                case 4 -> {
                    out.println("**Ваш список: "+str.get());
                }
                case 0 -> {
                    triger = false;
                }
                default -> out.println("**Подумай! ");
            }
        }
        out.println(str.get());
        iScanner.close();
    }
}
