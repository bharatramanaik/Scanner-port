package Observerdesign;

import Observerdesign.Observable.IphoneObservable;
import Observerdesign.Observer.EmailObserverImpl;
import Observerdesign.Observer.NotificationAlertObserver;
import Observerdesign.Observer.PhonenumObserverImpl;

public class Main {
    public static void main(String[] args) {
        IphoneObservable iphoneObservable = new IphoneObservable();
        NotificationAlertObserver emailobserver = new EmailObserverImpl(iphoneObservable, "abc@gmail.com");
        NotificationAlertObserver numObserver  = new PhonenumObserverImpl(iphoneObservable, "873648");

        iphoneObservable.add(numObserver);
        iphoneObservable.add(emailobserver);
        iphoneObservable.setStockCount(10);
        iphoneObservable.setStockCount(10);
        
    }
}
