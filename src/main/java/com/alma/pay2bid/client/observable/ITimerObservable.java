package com.alma.pay2bid.client.observable;

import com.alma.pay2bid.client.observer.ITimerObserver;

/**
 * An observable that notifies its observers when a timer has been updated
 * @author Alexis Giraudet
 * @author Arnaud Grall
 * @author Thomas Minier
 * Application corrigée et améliorée par Camille Le Luet, Asma Khelifi, François Hallereau, Sébastien Vallée et Sullivan Pineau
 */
public interface ITimerObservable  {
    boolean addTimerObserver(ITimerObserver observer);

    boolean removeTimerObserver(ITimerObserver observer);
}
