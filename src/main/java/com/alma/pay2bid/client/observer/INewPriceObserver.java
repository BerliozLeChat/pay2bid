package com.alma.pay2bid.client.observer;

import java.util.UUID;

/**
 * An observer notified when an item has a new price
 * @author Alexis Giraudet
 * @author Arnaud Grall
 * @author Thomas Minier
 * Application corrigée et améliorée par Camille Le Luet, Asma Khelifi, François Hallereau, Sébastien Vallée et Sullivan Pineau
 */
public interface INewPriceObserver {
    void updateNewPrice(UUID auctionID, Integer price);
}
