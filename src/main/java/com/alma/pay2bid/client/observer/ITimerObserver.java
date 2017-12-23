package com.alma.pay2bid.client.observer;

/**
 * An observer notified when a timer has been updated
 * @author Alexis Giraudet
 * @author Arnaud Grall
 * @author Thomas Minier
 * Application corrigée et améliorée par Camille Le Luet, Asma Khelifi, François Hallereau, Sébastien Vallée et Sullivan Pineau
 */
public interface ITimerObserver {
    void updateTimer(String time);
}
