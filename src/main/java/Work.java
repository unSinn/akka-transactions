import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fabi on 06/05/16.
 */
public class Work {

    final Logger log = LoggerFactory.getLogger(this.getClass());

    public void doWork() throws InterruptedException {
        log.info("doing work");
        Thread.sleep(1000);
    }
}
