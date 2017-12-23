package com.alma.pay2bid.client.observable;

import com.alma.pay2bid.client.observer.IBidSoldObserver;

/**
 * An observable that notifies its observers when an item has been sold
 * @author Alexis Giraudet
 * @author Arnaud Grall
 * @author Thomas Minier
 * Application corrigée et améliorée par Camille Le Luet, Asma Khelifi, François Hallereau, Sébastien Vallée et Sullivan Pineau
 */
public interface IBidSoldObservable {
    boolean addBidSoldObserver(IBidSoldObserver observer);

    boolean removeBidSoldObserver(IBidSoldObserver observer);
}
