import akka.dispatch.OnComplete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;

/**
 * Created by fabi on 06/05/16.
 */
public class ServiceImpl implements Service {

    final Logger log = LoggerFactory.getLogger(this.getClass());
    final ExecutionContext ec = AkkaSystem.system.dispatcher();

    private final Worker worker1;
    private final Worker worker2;
    private final Worker worker3;


    public ServiceImpl() {
        worker1 = AkkaSystem.getWorkActor();
        worker2 = AkkaSystem.getWorkActor();
        worker3 = AkkaSystem.getWorkActor();
    }

    public Future<Integer> doAllWork() throws InterruptedException {
        worker1.doWork();

        worker2.doWork();

        Future<Integer> finalFuture = worker3.doWork();
        finalFuture.onComplete(new OnComplete<Integer>() {
            @Override
            public void onComplete(Throwable throwable, Integer o) throws Throwable {
                log.info("All worker1 done shutting down.");
                AkkaSystem.system.terminate();
            }
        }, ec);
        return finalFuture;
    }
}
