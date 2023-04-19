package lk.ijse.gdse.service;

import lk.ijse.gdse.entity.User;
import lk.ijse.gdse.service.custom.impl.ReservationServiceImpl;
import lk.ijse.gdse.service.custom.impl.RoomServiceImpl;
import lk.ijse.gdse.service.custom.impl.StudentServiceImpl;
import lk.ijse.gdse.service.custom.impl.UserServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){

    }

    private static ServiceFactory getServiceFactory(){
        if (serviceFactory==null){
            return new ServiceFactory();
        }
        return serviceFactory;
    }
    public enum ServiceTypes{
        MAINPAGE,USERLOGIN,USERFORM,STUDENTFORM,ROOMFORM,RESERVATION,DASHBOARD,LOGINFORM,REGISTRATIONFORN
    }
    public SuperService getService(ServiceFactory.ServiceTypes types){
        switch (types){
            case USERFORM:
                return new UserServiceImpl();
            case STUDENTFORM:
                return new StudentServiceImpl();
            case ROOMFORM:
                return new RoomServiceImpl();
            case RESERVATION:
                return new ReservationServiceImpl();
            default:
                return null;
        }
    }
}
