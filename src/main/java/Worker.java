import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fabi on 06/05/16.
 */
public class Worker {

    final Logger log = LoggerFactory.getLogger(this.getClass());
    private final int nr;

    public Worker(int nr) {
        this.nr = nr;
    }

    public Integer doWork() throws InterruptedException {
        log.info("doing work");
        int i = 0;
        for (; i < 10; i++) {
            log.info("working..., {}-{}", nr, i);
            Thread.sleep(100);
        }
        return i;
    }

}