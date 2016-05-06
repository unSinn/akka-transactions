/**
 * Created by fabi on 06/05/16.
 */
public class WorkProcessor {

    private final Worker worker3;
    private final Worker worker2;
    private final Worker worker1;

    public WorkProcessor() {
        worker1 = new Worker(1);
        worker2 = new Worker(2);
        worker3 = new Worker(3);
    }

    public Integer doWork() throws InterruptedException {
        Integer sum = worker1.doWork();
        sum += worker2.doWork();
        sum += worker3.doWork();
        return sum;
    }
}
