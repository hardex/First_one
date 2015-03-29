import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by odogryk on 07.03.2015.
 */
public class metods {

        static void doJob(int x) { // копирование аргумента
            x = x + 60;
        }
        static void doJob(int[] a) {
            a[0] = 777;
        }
        static int doJob() {
            int x = 347;
            return x;
        }

        public static void main(String[] args) {
            int x = 1;
            System.out.println("x1 =" + x); // 1
            doJob(x);
            System.out.println("x2 =" + x); // 1
            int[] a = new int[]{1, 2, 3};
            doJob(a);
            System.out.println(Arrays.toString(a)); // [777, 2, 3]
            System.out.println(doJob()); //

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            Date d1 = new Date();
            Calendar c = Calendar.getInstance();
            //c.setTimeInMillis(sdf.parse());
            System.out.println(sdf.format(d1));
            System.out.println(c);

            System.out.println("arg1"+args[0]+" arg2"+args[1]);

        }



}
