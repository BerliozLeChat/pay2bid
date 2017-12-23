package com.alma.pay2bid.client.observer;

import com.alma.pay2bid.client.IClient;

/**
 * An observer notified when an item has been sold
 * @author Alexis Giraudet
 * @author Arnaud Grall
 * @author Thomas Minier
 * Application corrigée et améliorée par Camille Le Luet, Asma Khelifi, François Hallereau, Sébastien Vallée et Sullivan Pineau
 */
public interface IBidSoldObserver {
    void updateBidSold(IClient client);
}
