package Observerdesign.Observer;

import Observerdesign.Observable.StockObservable;

public class EmailObserverImpl implements NotificationAlertObserver{

    StockObservable stockObservable;
    String email;

    public EmailObserverImpl(StockObservable stockObservable, String email){
        this.stockObservable = stockObservable;
        this.email = email;
    }


    @Override
    public void update() {
        sendMessageOnEmail("email sent to "+email);
    }
    
    public void sendMessageOnEmail(String msg){
        System.out.println(msg);
    }
}
