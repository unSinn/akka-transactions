import scala.concurrent.Future;

import java.util.concurrent.Callable;

/**
 * Created by fabi on 06/05/16.
 */
public interface Service {

    Future<Integer> doAllWork() throws InterruptedException;
}
