import java.util.Set;
import java.io.*;
import java.util.*;
public class s5task1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
//        Пусть дан список сотрудников:
//        Иван Иванов
//        Светлана Петрова
//        Кристина Белова
//        Анна Мусина
//        Анна Крутова
//        Иван Юрин
//        Петр Лыков
//        Павел Чернов
//        Петр Чернышов
//        Мария Федорова
//        Марина Светлова
//        Мария Савина
//        Мария Рыкова
//        Марина Лугова
//        Анна Владимирова
//        Иван Мечников
//        Петр Петин
//        Иван Ежов

//import java.util.Scanner;
//!**********                                 ***********!
//!Не реализовано редактирование и дополнение справочника!
//!**********                                 ***********!
public class s5Task1 {
    public static HashMap<String, ArrayList<Integer>> phoneNumber;
    public static  Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        String line = "";
        String[] str;

        try {
            File file = new File("J:\\Java\\Seminar\\seminar5\\dz_sem5\\src\\s5Task1.txt");
            if (file.createNewFile()) { // если справочника нет создадим его
                System.out.println("file.created");
                System.out.println("Справочник пустой! Заполни его-> \n");
                // создаем справочник
                phoneNumber = InputPhone();
                Set<Map.Entry<String, ArrayList<Integer>>> entries = phoneNumber.entrySet();
                for(Map.Entry<String, ArrayList<Integer>> entry: entries){
                    System.out.println(entry.getKey()+" : "+entry.getValue());
                }
                // сохраняем в файл
                writephone(String.valueOf(phoneNumber));
            }

            else {
                BufferedReader bufReader = new BufferedReader(new FileReader(file));
                System.out.println("Вывод файла справочника ");
                line = bufReader.readLine();
                bufReader.close();
                ReadPhone(line);
            }
        }
        catch (Exception e) {
        }
        scanner.close();
    }

    //Запись в файл
    public static void writephone(String line) {

        try {
            BufferedWriter fl = new BufferedWriter(new FileWriter("J:\\Java\\Seminar\\seminar5\\dz_sem5\\src\\s5Task1.txt"));
            fl.write(line);
            fl.close();
        }
        catch (IOException e) {
        }
    }
    // Ввод: пользователь, телефоны
    public static HashMap<String, ArrayList<Integer>> InputPhone() {
        HashMap<String,  ArrayList<Integer>> phoneNumber = new HashMap<>();
        String str = "";
//        Scanner scanner = new Scanner(System.in);
        boolean triger = true;
        while (triger) {
            int value = 0;
            System.out.println("Введите пользователя, выход q: ");
            String key = scanner.nextLine();
            if (key.equals("q")) { // Выход из набора
                triger = false;
            }
            else {
                if (phoneNumber.containsKey(key)) {
                    System.out.println("Введите телефон: ");
                    value = Integer.parseInt(scanner.nextLine());
                    phoneNumber.get(key).add(value);
                } else {
                    ArrayList<Integer> arrayList = new ArrayList<Integer>(1);
                    System.out.println("Введите телефон: ");
                    value = Integer.parseInt(scanner.nextLine());
                    arrayList.add(value);
                    phoneNumber.put(key, arrayList);
                }
            }
        }

        return phoneNumber;
    }
    // Вывод справочника
    public static void ReadPhone(String line){
        String[] str = new String[]{};
        String lines = line.substring(1, line.length() - 2); //убираем '{', ']}'
        String[] tmp = new String[]{""};
        String[] num = new String[]{""}; // телефонные номара
        str = lines.split("], ");  //убираем '],' разделяем по ключам


        HashMap<String, ArrayList<Integer>> nbr = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            tmp = str[i].replace("[", "").replace(",", "").split("=");// Убираем '=', '[', ','
            num = tmp[1].split(" ");

            ArrayList<Integer> arrayList = new ArrayList<Integer>(1);
            int count = num.length;
            for (int j = 0; j < count; j++) {
                int value = Integer.parseInt(num[j]);
                arrayList.add(value);
            }
            nbr.put(tmp[0], arrayList);
        }
        Set<Map.Entry<String, ArrayList<Integer>>> entries = nbr.entrySet();
        for(Map.Entry<String, ArrayList<Integer>> entry: entries){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}