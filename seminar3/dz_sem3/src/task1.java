//Реализовать алгоритм сортировки слиянием
//Естественное неймановское слияние
//Прямое слияние Боуза-Нельсона

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class task1 {
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
        ArrayList<Integer> res_str = new ArrayList<>(num);


        res_str = sort_merge(str, num);
        while (res_str.size() != 0) {
            str = res_str;
            res_str = sort_merge(str, num);
        }
        System.out.println(str);




    }
    // метод "Естественное Неймановское слияние 1945 год"
    static ArrayList<Integer> sort_merge(ArrayList<Integer> str, Integer num){
        ArrayList<Integer> str1 = new ArrayList<>();
        ArrayList<Integer> str2 = new ArrayList<>();

        boolean trigger = true; // разбиваем исходник на два массива
        for (int i = 0; i < num-1; i++) {
            if (trigger){
                if (str.get(i) <= str.get(i + 1))
                {
                    str1.add(str.get(i));
                }
                else
                {
                    str1.add(str.get(i));
                    trigger = false;
                }
            }
            else {
                if (str.get(i) <= str.get(i + 1)) {
                    str2.add(str.get(i));}
                else{
                    str2.add(str.get(i));
                    trigger = true;
                }
            }
        }
        if (trigger) str1.add(str.get(num - 1));
        else str2.add(str.get(num - 1));

    // собираем строку

        ArrayList<Integer> res = new ArrayList<>();
        int count1 = str1.size();
        int count2 = str2.size();
        if (count2 == 0){
            return str2; // признак окончания сортировки: 2-я строка пустая
        }
        int j = 0;
        for (int i = 0; i < count1; i++) {
            if (j < count2) {
                if (str1.get(i) < str2.get(j)) {
                    res.add(i+j, str1.get(i));
                } else {
                    res.add(i+j, str2.get(j));
                    j++;
                    i--;
                }

            } else res.add(i+j, str1.get(i));
        }

        while (j < count2){
            res.add(count1, str2.get(j));
            count1++;
            j++;

        }
        return res;

    }
}
