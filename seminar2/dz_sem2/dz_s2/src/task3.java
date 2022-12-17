import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.
public class task3 {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(File.class.getName());
        logger.setLevel(Level.INFO);
        try {
            FileHandler ch = new FileHandler("task3.log", true);
            logger.addHandler(ch);
            SimpleFormatter sFormat = new SimpleFormatter();
            ch.setFormatter(sFormat);
            logger.info("Запуск пузырька");
        } catch (IOException e) {

        }

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Задайте длину массива : ");
        int num = iScanner.nextInt();
        iScanner.close();
        int[] str = new int[num];
        for (int i = 0; i < str.length; i++) {
            str[i] = ThreadLocalRandom.current().nextInt(1, num + 1);
        }
        logger.info("Создание массива "+Arrays.toString(str));
        System.out.println(Arrays.toString(str));

        int tmp = 0;
        for (int i = 0; i < num; i++)
        {
            for (int j = 1; j < num - i; j++)
                if (str[j-1] > str[j]) {
                    tmp = str[j];
                    logger.info("Переставляем местами элементы "+str[j-1]+" и "+str[j]);
                    str[j] = str[j-1];
                    str[j-1] = tmp;
                    logger.info("Результат перестановки "+Arrays.toString(str));

                }
        }
        logger.info("Вывод результата "+Arrays.toString(str));
        System.out.println(Arrays.toString(str));
    }



}

