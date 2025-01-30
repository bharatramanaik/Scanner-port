package Observerdesign.Observable;

import java.util.ArrayList;
import java.util.List;

import Observerdesign.Observer.NotificationAlertObserver;

public class IphoneObservable implements StockObservable{
    @SuppressWarnings({ "rawtypes", "unchecked" })
    List<NotificationAlertObserver> lAlertObservers = new ArrayList();
    int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        lAlertObservers.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        lAlertObservers.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubscriber() {
        for (NotificationAlertObserver notificationAlertObserver : lAlertObservers) {
            notificationAlertObserver.update();
        }
    }

    @Override
    public void setStockCount(int newstockCount) {
        if (stockCount == 0 && newstockCount != 0) {
            notifySubscriber();
        }
        stockCount += newstockCount;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
    
}
