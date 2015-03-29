import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by hardex on 28.02.2015.
 */
public class hw_arrays {
    public static void main(String[] args) {
        /*Задача 1:
        1. Задать массив целых чисел длинной 10 эл.
        2. Отсортировать числа в массиве
        3. Вывести на экран результат.
        4. Сделать возможность наполнения массива с клавиатуры*.
        */
        System.out.println("Task 1.");
        int[] a = {2,3,1,65,23,34,67,233,32,56};
        System.out.println("Начальный массив : "+Arrays.toString(a));

        Arrays.sort(a);
        System.out.println("Отсортированный массив : "+Arrays.toString(a));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Вы хотите вводить массив?[y/n]:");
        if (scanner.nextLine().equals("y")) {
            for (int i = 0; i < a.length; i++) {
                System.out.print("Введите элемент а[" + i + "]:");
                a[i] = scanner.nextInt();
            }

            Arrays.sort(a);
            System.out.println("Массив введенный вручную и отсортированный : " + Arrays.toString(a));
        }
        System.out.println("Task 2.");
        /*
        Задача 2:
        1. Задать массив целых чисел длинной N эл.
        2. Поменять 1-й и последний элемент местами.
        3. Вывести массив на экран.
        */
        int n = 12;
        int[] b = new int[n];
        Arrays.fill(b, 34);
        b[0]--; b[n-1]++;
        System.out.println("Начальный массив : " + Arrays.toString(b));
        int bf = b[0]; // buffer
        b[0] = b[n-1];
        b[n-1] = bf;
        System.out.println("Обработанный Массив : " + Arrays.toString(b));

        /*
        Задача 3:
        1. Ввести с клавиатуры массив из 10 чисел.
        2. Разбить его на 2 массива равной длинны.
        3. Отсортировать каждую из половинок и вывести их содержимое на экран.
        */

        System.out.println("Task 3.");
        int[] c1;
        System.out.print("Вы хотите вводить массив?[y/n]:");
        if (scanner.nextLine().equals("y")) {
            c1 = new int[10];
            for (int i = 0; i < c1.length; i++) {
                System.out.print("Введите элемент а[" + i + "]:");
                c1[i] = scanner.nextInt();
            }

            System.out.println("Массив введенный вручную : " + Arrays.toString(c1));
        } else {
            c1 = new int[] {2, 334, 1, 465, 3, 34, 967, 233, 32, 56};
            System.out.println("Начальный массив : "+Arrays.toString(c1));

        }
        int[][] c2 = {Arrays.copyOf(c1,c1.length/2),Arrays.copyOfRange(c1,c1.length/2, c1.length)};
        System.out.println("Mассив 1 : "+Arrays.toString(c2[0]));
        Arrays.sort(c2[0]);
        System.out.println("Mассив (sorted) 1 : " + Arrays.toString(c2[0]));
        System.out.println("Mассив 2 : " + Arrays.toString(c2[1]));
        Arrays.sort(c2[1]);
        System.out.println("Mассив (sorted) 2 : "+Arrays.toString(c2[1]));

        /*
        Задача 4:
        1. Среднее арифметическое элементов массива.
        */
        System.out.println("Task 4.");
        int[] d = {5, 45, 34, 43, 32, 4, 96, 23, 221, 516};
        System.out.println("Mассив : "+Arrays.toString(d));
        for (int i = 1; i < d.length; i++) {
            d[0] = d[0]+d[i];
        }
        System.out.println("Среднее арифметическое элементов массива : "+((double) d[0]/d.length));

        /*
        Задачи на 5-ку 
        - Написать код для зеркального переворота массива (1,2,3,4) -> (4,3,2,1).
        - Написать программу, которая позволит задать длину массива с клавиатуры, наполнить его
        элементами, а затем выводить нужный элемент по его индексу на консоль.
        */

        System.out.println("Task 5, - Написать код для зеркального переворота массива (1,2,3,4) -> (4,3,2,1). /из нечетного кол-ва интересней/");

        int[] e = {1,2,3,4,5};
        System.out.println("Mассив : "+Arrays.toString(e));
        int j = e.length-1;
        for (int i = 0; i < e.length/2; i++) {
            bf = e[i];
            e[i] = e[j];
            e[j] = bf;
            j--;
        }
        System.out.println("зеркальн Mассив : "+Arrays.toString(e));

        System.out.println("Task 5, - Написать программу, которая позволит задать длину массива с клавиатуры, наполнить его\n" +
                "        элементами, а затем выводить нужный элемент по его индексу на консоль.");

        System.out.print("Вы хотите вводить массив?[y/n]:");
        if (scanner.nextLine().equals("y")) {
            System.out.print("Какой длины массив?[n]:");
            n = scanner.nextInt();
            int[] f = new int[n];
            // Ввод масива
            for (int i = 0; i < n; i++) {
                System.out.print("Введите элемент f[" + i + "]:");
                f[i] = scanner.nextInt();
            }

            boolean read = true; // индекс массива корректен
            while (read) {
                System.out.print("Введите номер элемента f[i]:");
                n = scanner.nextInt();
                if (n<0||n>=f.length) read = false;
                else System.out.println("Значение элемента f[" + n + "]:"+f[n]);
            }

            System.out.println("Вы вышли за пределы массива.");
        }

        System.out.println("End.");
    }
}
