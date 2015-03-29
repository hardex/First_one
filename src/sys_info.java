import java.util.Arrays;

/**
 * Created by odogryk on 21.02.2015.
 */
public class sys_info {


    public static void main(String[] args) {

        Runtime r = Runtime.getRuntime();
        System.out.println(System.getProperty("os.name"));
        System.out.println(r.availableProcessors());
        System.out.println(r.totalMemory()/1024/1024);
        System.out.println("Memory for Java "+ r.totalMemory()/1024/1024 + " Mb");

        int[] a = new int[100];
        for (int i = 0; i< a.length; ++i) {
            a[i] = i;
        }
        System.out.println(Arrays.toString(a));

        int i = 1;
        System.out.println(i++/--i);

    }
}
