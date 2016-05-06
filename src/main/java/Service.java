import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by fabi on 06/05/16.
 */
public interface Service {

    Future<Integer> doSomeWork();

    AtomicBoolean isBusy();
}
