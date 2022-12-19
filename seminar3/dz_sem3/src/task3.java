import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.round;

//Задан целочисленный список ArrayList. Найти минимальное
//максимальное и среднее из этого списка
//*******************
public class task3 {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Задайте длину массива : ");
        int num = iScanner.nextInt();
        iScanner.close();
        ArrayList<Integer> str = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            str.add(ThreadLocalRandom.current().nextInt(1, num + 1));
        }
        System.out.println(str);
        int max = str.get(0);
        int min = str.get(0);
        int index_min = 0;
        int index_max = 0;
        double sum = 0;
        int i = 0;
        while (i < str.size()) {
            if (str.get(i) > max) {
                max = str.get(i);
                index_max = i;
            }
            if (str.get(i) < min) {
                min = str.get(i);
                index_min = i;
            }

            sum += str.get(i);
            i++;
        }
        sum = sum/num;

        String res = decimalFormat.format(sum);
        System.out.println(" index_max = " + index_max + "; max - " + max);
        System.out.println(" index_min = " + index_min + "; min - " + min);
        System.out.println(" Среднеарифметическое - " + res);
    }
}

