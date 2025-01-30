package Observerdesign.Observer;

import Observerdesign.Observable.StockObservable;

public class PhonenumObserverImpl implements NotificationAlertObserver{

    StockObservable stockObservable;
    String username;

    public PhonenumObserverImpl(StockObservable stockObservable, String username){
        this.stockObservable = stockObservable;
        this.username = username;
    }

    @Override
    public void update() {
        sendMessageOnPhonNum("message sent to number "+username);
    }

    public void sendMessageOnPhonNum(String msg){
        System.out.println(msg);
    }
    
}
