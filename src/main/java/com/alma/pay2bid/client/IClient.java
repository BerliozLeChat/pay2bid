package com.alma.pay2bid.client;

import com.alma.pay2bid.bean.AuctionBean;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

/**
 * The Interface of a client in our model
 * @author Alexis Giraudet
 * @author Arnaud Grall
 * @author Thomas Minier
 * Application corrigée et améliorée par Camille Le Luet, Asma Khelifi, François Hallereau, Sébastien Vallée et Sullivan Pineau
 */
public interface IClient extends Remote, Serializable {
    /**
     * @param auction
     * @throws RemoteException
     */
    void newAuction(AuctionBean auction) throws RemoteException;

    /**
     * @param auction
     * @throws RemoteException
     */
    void submit(AuctionBean auction) throws RemoteException;

    /**
     * @param buyer
     * @throws RemoteException
     */
    void bidSold(IClient buyer) throws RemoteException;

    /**
     * @param auctionID
     * @param price
     * @throws RemoteException
     */
    void newPrice(UUID auctionID, int price) throws RemoteException;

    public UUID get_UUID() throws RemoteException;

    /**
     * @return
     * @throws RemoteException
     */
    String getName() throws RemoteException;

    ClientState getState() throws RemoteException;

    void setState(ClientState newState) throws RemoteException;

    public void FenetreAttenteFinRound() throws RemoteException;

    public void FermetureFenetreAttenteFinRound() throws RemoteException;
}
