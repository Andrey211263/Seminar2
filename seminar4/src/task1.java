import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
// Реализовать консольное приложение, которое принимает от пользователя строку
// вида text~num. Нужно рассплитить строку по ~, соохранить техт в связный список на
// апозицию num. Если введено print~num, выводит строку из позиции num в связном
// списке и удаляет ее из списка.
public class task1 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            list.add(""+i);
            }
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String text = sc.nextLine();
        int number =0;
        String string = "null";
        String[] array = text.split("~"); // Test~5
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            }
        for (int i = 0; i < array.length; i++) {
            try{
                number = Integer.parseInt(array[i]);
            }
            catch (Exception e) {
                string = array[i];
            }
        }
        for (String sss: list)
        {
                System.out.print(sss+" ");
            }
        System.out.println();

        removeList(list,number);
        addList(list,string,number);


        for (String list1: list)
        {
            System.out.print(list1+" ");
        }

    }
    public static void removeList(LinkedList<String> list, int number)
    {
        list.remove(number);
    }
    public static void addList(LinkedList<String> list, String text, int number)
    {
        list.add(number, text);
    }
}