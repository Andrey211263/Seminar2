// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

import java.util.LinkedList;
import java.util.Random;

public class s5Task4 {
    public static void main(String[] args) {


    int[][] array = new int[8][8];
    int count = 0;
        while (count != 8) {
        LinkedList<Integer> lineX = new LinkedList<Integer>();
        LinkedList<Integer> lineY = new LinkedList<Integer>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = 0;
            }
        }
        Random rnd = new Random();
        int x_1 = rnd.nextInt(8);
        int y_1 = rnd.nextInt(8);
        array[x_1][y_1] = 1;
        lineX.add(x_1);
        lineY.add(y_1);
        count = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (checkField(lineX, i) && checkField(lineY, j) && fields(lineX, lineY, i, j)) {
                    array[i][j] = 1;
                    lineX.add(i);
                    lineY.add(j);
                    count++;
                }
            }
        }
    }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[i][j] + " ");
        }
        System.out.println();
    }
        System.out.println("\nРасстановка ферзей когда не бьют друг друга");
}

    public static boolean checkField(LinkedList<Integer> arr, int num) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == num) {
                return false;
            }
        }
        return true;
    }

    public static boolean fields(LinkedList<Integer> array1, LinkedList<Integer> array2, int num1, int num2) {
        for (int i = 0; i < array1.size(); i++) {
            if (Math.abs(array1.get(i) - num1) == Math.abs(array2.get(i) - num2)) {
                return false;
            }
        }
        return true;
    }
}
