/**
 * Created by fabi on 06/05/16.
 */
public class ServiceControllerImpl implements ServiceController {


    private final Service service;

    public ServiceControllerImpl() {
        service = AkkaSystem.getServiceActor();
    }

    @Override
    public boolean addWork() {
        if (service.isBusy().get()) {
            return false;
        } else {
            service.doSomeWork();
            return true;
        }
    }
}
