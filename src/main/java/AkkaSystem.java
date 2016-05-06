import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.TypedProps;
import akka.japi.Creator;
import com.typesafe.config.ConfigFactory;

/**
 * Created by fabi on 06/05/16.
 */
public class AkkaSystem {

    public static final ActorSystem system = ActorSystem.create("akka-transaction", ConfigFactory.load());

    private static int workerNr = 0;

    public static Service getServiceActor() {
        return TypedActor.get(system).typedActorOf(new TypedProps<>(Service.class, ServiceImpl.class));
    }

    public static Worker getWorkActor() {
        final int nr = workerNr++;
        return TypedActor.get(system).typedActorOf(new TypedProps<>(Worker.class,
                        (Creator<WorkerImpl>) () -> new WorkerImpl(nr)),
                "worker-" + nr);
    }
}
