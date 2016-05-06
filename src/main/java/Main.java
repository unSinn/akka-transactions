/**
 * Created by fabi on 06/05/16.
 */
public class Main {


    public static void main(String... args) {
        Work work = new Work();
        try {
            work.doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
