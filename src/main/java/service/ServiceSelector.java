package service;

import java.util.List;

public class ServiceSelector {
    private List<Service> services;

    public ServiceSelector(List<Service> services){
        this.services = services;
    }

    public Service selectService(int number) throws IllegalAccessException {
        for(Service service : services){
            if(service.isCalled(number)){
                return service;
            }
        }
        throw new IllegalAccessException("올바르지 않은 기능 번호 입니다");
    }

}
