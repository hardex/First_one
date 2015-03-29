import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by odogryk on 20.03.2015.
 */
public class hw_pre_oop {

    public static void main(String[] args) {

        // 2. Написать свой вариант ф-и Arrays.equals для short[].
        short[] s1 = {43,432,23,43,22,4};
        short[] s2 = {43,432,23,43,22,4};
        short[] s3 = {43,42,233,3,212,14};
        System.out.println(Arrays.equals(s1,s3));
        System.out.println(IsItEq(s1, s2));

        // 3. Написать свой вариант ф-и Arrays.toString() для int[].
        int[] i1 = {123,4534,666,4,3,2,55555};
//        int[] i2 = {123,4534,666,4,3,2,55555};
        System.out.println(IntToStr(i1));
        System.out.println(Arrays.toString(i1));

        // 4. Написать код, который позволит менять и читать значения произвольных битов в массиве int-ов.
        int[] i5 = {3,2,4,6,7,2323};
        String St; // = new String();

        Scanner scan = new Scanner(System.in);
        char a; // operation
        int p, v; // p - position, v - value.
        int CurrBitCount; // текущая сквозная позиция бита в массиве

        do {
            System.out.println("Массив " + Arrays.toString(i5));
            System.out.println("Массив в битах " + ArrBit(i5));
            System.out.print("Do you want [r]ead/[c]hange a bit or [q]uit?:");
            a = scan.nextLine().charAt(0);
            switch (a){
                case 'r':{
                    System.out.print("Bit position?:");
                    p = scan.nextInt();
                    scan.nextLine();

                    St = "";
                    for (int i:i5) St += Integer.toBinaryString(i);
                    System.out.println(St.charAt(St.length()-p));

                    break;
                }
                case 'c':{
                    System.out.print("Bit position?:");
                    p = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Set value [0/1]?:");
                    v = scan.nextInt();
                    v = (v==0 || v==1) ? v : 0;
                    scan.nextLine();
                    CurrBitCount = 0;

                    for (int i = i5.length -1; i >= 0 && CurrBitCount < p; i--) {
                        // перебираем массив десятичных чисел
                        if (Integer.toBinaryString(i5[i]).length() + CurrBitCount >= p && CurrBitCount < p) {
                            // внутри ли этого числа находится искомый бит?
                            for (int j = Integer.toBinaryString(i5[i]).length() - 1; j >= 0 ; j--) {
                                // ищем бит в числе.
                                CurrBitCount++;
                                if (CurrBitCount == p) {
                                    // нашли бит, устанавливаем.
                                    i5[i] = Integer.parseInt(Integer.toBinaryString(i5[i]).substring(0, j) + v
                                            + Integer.toBinaryString(i5[i]).substring(j+1, Integer.toBinaryString(i5[i]).length()), 2);
                                }

                            }
                        } else {
                            CurrBitCount += Integer.toBinaryString(i5[i]).length();
                        }
                    }
                    break;
                }
                default:{
                    break;
                }
            }
        } while (a=='r'||a=='c');

        // Ввести с консоли дату. Сравнить ее с текущей датой в системе. Вывести отличающиеся части (год, месяц) на экран.
        System.out.print("Введите дату (dd.mm.yyyy):");
        St = scan.nextLine();
        Date dt = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date dte = sdf.parse(St);
            System.out.println("Entered date is "+sdf.format(dte));
            System.out.println("Current date is "+sdf.format(dt));

            if (!St.substring(3, 5).equalsIgnoreCase(sdf.format(dt).substring(3,5)))
                System.out.println("Отличается месяц : "+St.substring(3, 5)+" <> "+sdf.format(dt).substring(3,5));
            if (!St.substring(6, 10).equalsIgnoreCase(sdf.format(dt).substring(6,10)))
                System.out.println("Отличается год : "+St.substring(6, 10)+" <> "+sdf.format(dt).substring(6,10));
        }
            catch (ParseException e) {
                System.out.println("Wrong date!");
            }
        scan.close();

        // 1. Дано текст из 3-х слов “word1 word2 word3”. Поменять 1-е и 3-е слова местами и вывести на экран результат.
        StringBuilder sb = new StringBuilder();
        sb.append("Hello, Pumpkin Eater!");
        System.out.println(wordFind(sb, 3).toString() + " " +wordFind(sb, 2).toString()+ " " +wordFind(sb, 1).toString());



    }

    public static StringBuilder wordFind (StringBuilder sb, int c_search) {
        int c_pos = 0;
        StringBuilder word = new StringBuilder();
        boolean w_started = false;
        for (int i = 0; i < sb.length(); i++) {

            if (sb.charAt(i) != ' ' && sb.charAt(i) != ',' && sb.charAt(i) != '!') {
                if (!w_started){
                    w_started = true;
                    c_pos++;
                    word.setLength(0);
                }
                word.append(sb.charAt(i));
            } else {
                w_started = false;
                if (c_pos == c_search) {
                    return word;
                }
            }
        }
        if (c_pos == c_search) {
            // last word
            return word;
        }
        return new StringBuilder("Word not found");
    }

    private static String tobit(int y) {
        return String.format("%32s", Integer.toBinaryString(y)).replace(' ', '0');
    }

    private static String ArrBit(int[] a){
        String s = "[";
        for (int anA : a) {
            s += Integer.toBinaryString(anA) + ", ";
        }
        return s.substring(0, s.length()-2) + "]";
    }

    public static String IntToStr(int[] ii){
        String St = "[";
        for (int anIi : ii) St += anIi + ", ";
        return St.substring(0, St.length()-2) + "]";
    }

    public static boolean IsItEq(short[] sh1, short[] sh2) {
        if (sh1.length != sh2.length) return false;
        // boolean eq = true;
        for (int i = 0; i < sh1.length; i++)
            if (sh1[i] != sh2[i]) return false;
        return true;
    }

}
