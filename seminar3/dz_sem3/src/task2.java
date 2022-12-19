import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

//Пусть дан произвольный список целых чисел, удалить из него четные числа
public class task2 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Задайте длину массива : ");
        int num = iScanner.nextInt();
        iScanner.close();
        ArrayList<Integer> str = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            str.add(ThreadLocalRandom.current().nextInt(1, num + 1));
        }
        System.out.println(str);
        int i = 0;
        while(i < str.size()){
            if (str.get(i)%2 == 0  ) {
                System.out.println(" *Удаляем* "+str.get(i)+" ");
                str.remove(i);
                i--;

            }
            i++;
            }
        System.out.println(" Наш массив "+str);
        }
    }

