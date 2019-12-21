package service;

import domain.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServiceRepository {
    private static final List<Service> services = new ArrayList<>();

    static{
        services.add(new Service(1,"주문등록"));
        services.add(new Service(2,"결제하기"));
        services.add(new Service(3,"프로그램 종료"));
    }

    public static List<Service> services() {
        return Collections.unmodifiableList(services);
    }
}
