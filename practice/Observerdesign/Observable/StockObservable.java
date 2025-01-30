package Observerdesign.Observable;

import Observerdesign.Observer.NotificationAlertObserver;

public interface StockObservable {
    void add(NotificationAlertObserver notificationAlertObserver);

    void remove(NotificationAlertObserver notificationAlertObserver);

    void notifySubscriber();

    void setStockCount(int stockCount);

    int getStockCount();
}
