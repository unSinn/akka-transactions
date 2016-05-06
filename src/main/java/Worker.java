import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.concurrent.Future;

/**
 * Created by fabi on 06/05/16.
 */
public interface Worker {

    Future<Integer> doWork() throws InterruptedException;

}
