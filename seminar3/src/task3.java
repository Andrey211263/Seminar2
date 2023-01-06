
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        List<ArrayList<String>> booksStore = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            booksStore.add(new ArrayList<>());
            System.out.println("Введите жанр: ");
            booksStore.get(i).add(scanner.nextLine());
            while (true) {
                System.out.println("Введите произведение: ");
                String item = scanner.nextLine();
                if (item.equals("q")){
                    break;
                }
                booksStore.get(i).add(item);
            }
        }

        scanner.close();
        int i = 0;
        for (int j = 0; j < booksStore.get(0).size(); j++)
        {
            for (i = 0; i < booksStore.size(); i++)
            {
                System.out.print(booksStore.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

//        for (int i = 0; i < booksStore.size(); i++) {
//
//            for (int j = 0; j < booksStore.get(i).size(); j++) {
//                System.out.print(booksStore.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
