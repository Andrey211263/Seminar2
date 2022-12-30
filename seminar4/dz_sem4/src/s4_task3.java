// =====================================================================================
//* В калькулятор добавьте возможность отменить последнюю операцию.
//======================================================================================
import java.util.*;
public class s4_task3 {
        public static void main(String[] args) {
                while (true) {
                        String[] rt = new String[]{""};
//                String ext = " ";

                        Stack<String> st = new Stack<>();
                        Scanner iScanner = new Scanner(System.in);
                        System.out.print("Введите выражение разделяя элементы пробелами. Выход 0: ");
                        String str = iScanner.nextLine();

                        rt = str.split(" "); //получаем распарсиную строку
//                        String[] action = new String[]{""};
                        if (rt[0].charAt(0) != '0') {
                                st.push(rt[0]);
                                st.push(rt[2]);
                                st.push(rt[1]);
                                System.out.println("Хотите отменить операцию, - 'yes' \n" +
                                        "продолжить - enter");
                                String action = iScanner.nextLine();
                                if (action.equals("yes")) {
                                        System.out.println("*Отмена операции* -> "+rt[0]+rt[1]+rt[2]);
//                                        iScanner.close();
//                                        break;
                                } else calc(rt, st);
                        }

                        else {
                                System.out.println("*****ПОКА!*****");
                                iScanner.close();
                                break;
                                }

                        }

                }

              public static void calc(String[] rt, Stack<String> st) {

                      String sign = st.pop();
                switch (sign.charAt(0)) {
                        case '+' -> {
                                double sum = Double.parseDouble(st.pop()) + Double.parseDouble(st.pop());
                                System.out.println(rt[0] + " + " + rt[2] + " = " + sum);
                        }
                        case '-' -> {
                                double sub = Double.parseDouble(st.pop()) - Double.parseDouble(st.pop());
                                System.out.println(rt[0] + " - " + rt[2] + " = " + sub); }
                        case '*' -> {
                                double mul = Double.parseDouble(st.pop()) * Double.parseDouble(st.pop());
                                System.out.println(rt[0] + " * " + rt[2] + " = " + mul); }
                        case '/' -> {
                                if (Double.parseDouble(rt[2]) != 0) {
                                        double div = Double.parseDouble(st.pop()) / Double.parseDouble(st.pop());
                                        System.out.println(rt[0] + " / " + rt[2] + " = " + div); }
                                else {
                                        System.out.println("*На ноль делить нельзя!*");
                                }
                        }
                        default -> System.out.println("Это мы не умеем! ");
                }
                }
        }
