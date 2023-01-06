//Реализовать консольное приложение, которое:
//Принимает от пользователя и “запоминает” строки.
//Если введено print, выводит строки так, чтобы последняя введенная
// была первой в списке, а первая - последней.
//Если введено revert, удаляет предыдущую введенную строку из памяти.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class task2 {
    static List<String > list;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<String> list = new Stack<String>();
//        list = new LinkedList();
        boolean triger = true;
        while (triger){
            System.out.print(" input text: ");
            String str = input.next();
            if (str.contains("print")){
                printNum(list);
            }
            else if (str.contains("revert")){
                revert(list);
            }
            else {
                list.push(str);
            }
            if (str.contains("exit")){
                System.out.print(list);
                triger = false;
            }



        }


    }
    static void revert(Stack<String> text) {
        text.pop();
        System.out.println(text);
//        while (!text.isEmpty()){
//            System.out.print(" "+ text.pop());
//      }
    }
    static void printNum(Stack<String> text) {
        while (!text.isEmpty()){
            System.out.print(" "+ text.pop());
        }
        System.out.println();

    }

}
