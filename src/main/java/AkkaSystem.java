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

    private static Service serviceInstance;

    private static ServiceController controllerInstance;

    public static Service getServiceActor() {
        if (serviceInstance == null) {
            serviceInstance = TypedActor.get(system)
                    .typedActorOf(new TypedProps<>(Service.class, ServiceImpl.class));
        }
        return serviceInstance;
    }

    public static ServiceController getServiceControllerActor() {
        if (controllerInstance == null) {
            controllerInstance = TypedActor.get(system)
                    .typedActorOf(new TypedProps<>(ServiceController.class, ServiceControllerImpl.class));
        }
        return controllerInstance;
    }
}
