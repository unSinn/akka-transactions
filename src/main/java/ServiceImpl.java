import akka.dispatch.OnComplete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;

import java.util.concurrent.atomic.AtomicBoolean;

import static akka.dispatch.Futures.future;

/**
 * Created by fabi on 06/05/16.
 */
public class ServiceImpl implements Service {

    final Logger log = LoggerFactory.getLogger(this.getClass());
    final ExecutionContext ec = AkkaSystem.system.dispatcher();

    private final WorkProcessor workProcessor;
    private AtomicBoolean busy = new AtomicBoolean(false);

    public ServiceImpl() {
        workProcessor = new WorkProcessor();
        log.info("Ready. busy:{}", isBusy());
    }

    public Future<Integer> doSomeWork() {
        busy.set(true);
        log.info("Starting work. busy:{}", isBusy());
        Future<Integer> future = future(() -> workProcessor.doWork(), ec);
        future.onComplete(onWorkComplete(), ec);
        return future;
    }

    @Override
    public AtomicBoolean isBusy() {
        return busy;
    }


    private OnComplete<Integer> onWorkComplete() {
        return new OnComplete<Integer>() {
            @Override
            public void onComplete(Throwable throwable, Integer o) throws Throwable {
                busy.set(false);
                /*log.info("All work done shutting down in 1s busy:{}", isBusy());
                Thread.sleep(1000);
                log.info("shutting down.");
                AkkaSystem.system.terminate();
                */
            }
        };
    }


}
