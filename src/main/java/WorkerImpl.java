import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;

import static akka.dispatch.Futures.future;

/**
 * Created by fabi on 06/05/16.
 */
public class WorkerImpl implements Worker {

    final Logger log = LoggerFactory.getLogger(this.getClass());
    final ExecutionContext ec = AkkaSystem.system.dispatcher();
    private final int nr;

    public WorkerImpl(int nr) {
        this.nr = nr;
    }

    public Future<Integer> doWork() throws InterruptedException {
        log.info("doing work");
        return future(() -> {
            int i = 0;
            for (; i < 10; i++) {
                log.info("working..., {}-{}", nr, i);
                Thread.sleep(100);
            }
            return i;
        }, ec);
    }

}