package service;

import java.util.List;

public class ServiceSelector {
    private List<Service> services;

    public ServiceSelector(List<Service> services){
        this.services = services;
    }

    public Service selectService(int number) {
        for(Service service : services){
            if(service.isCalled(number)){
                return service;
            }
        }
        return null;
    }

}
