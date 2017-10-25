package com.alma.pay2bid.bean;

import java.util.UUID;

/**
 * AuctionBean represent an auction, ie an item sold by a client
 * @author Alexis Giraudet
 * @author Arnaud Grall
 * @author Thomas Minier
 */
public class AuctionBean implements IBean {
    private UUID uuid;
    private UUID creator_UUID;
    private int price;
    private String name;
    private String description;

    public AuctionBean(int price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getCreator_UUID() { return creator_UUID; }

    public void setCreator_UUID(UUID creator_UUID) { this.creator_UUID = creator_UUID; }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
