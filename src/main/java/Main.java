/**
 * Created by fabi on 06/05/16.
 */
public class Main {


    public static void main(String... args) {
        try {
            AkkaSystem.getServiceActor().doAllWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
