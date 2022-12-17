import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class task4 {

    public static void main (String[] args) {
        Logger logger = Logger.getLogger(File.class.getName());
        logger.setLevel(Level.INFO);
        try {
            FileHandler ch = new FileHandler("task4.log", true);
            logger.addHandler(ch);
            SimpleFormatter sFormat = new SimpleFormatter();
            ch.setFormatter(sFormat);
            logger.info("Запуск калькулятора");
        }
        catch (IOException e) {

        }
        while (true)
        {
            String[] rt = new String[]{""};
            String ext = " ";


            Scanner iScanner = new Scanner(System.in);
            System.out.print("Введите выражение разделяя элементы пробелами. Выход 0: ");
            String str = iScanner.nextLine();
            logger.log(Level.WARNING, "Ввели выражение " + str);

            rt = str.split(" "); //получаем распарсиную строку
            ext = rt[0]; // проверяем условие выхода

            if (ext.charAt(0) != '0') {
                double num1 = Double.parseDouble(rt[0]);
                double num2 = Double.parseDouble(rt[2]);

                ext = rt[1];
                switch (ext.charAt(0)) {
                    case '+' -> {
                        double sum = num1 + num2;
                        System.out.println(num1 + " + " + num2 + " = " + sum);
                        logger.log(Level.INFO, "результат " + sum);
                    }
                    case '-' -> {
                        double sub = num1 - num2;
                        System.out.println(num1 + " - " + num2 + " = " + sub);
                        logger.log(Level.INFO, "результат " + sub);
                    }
                    case '*' -> {
                        double mul = num1 * num2;
                        System.out.println(num1 + " * " + num2 + " = " + mul);
                        logger.log(Level.INFO, "результат " + mul);
                    }
                    case '/' -> {
                        if(num2 != 0)
                        {
                            double div = num1 / num2;
                            System.out.println(num1 + " / " + num2 + " = " + div);
                            logger.log(Level.INFO, "результат " + div);
                        }
                        else
                        {
                            System.out.println("*На ноль делить нельзя!*");
                        }
                    }
                    default -> System.out.println("Это мы не умеем! ");
                }
            } else {
                System.out.println("*****ПОКА!*****");
                logger.info("Выход из калькулятора");
                iScanner.close();
                break;
            }

        }

    }
}
