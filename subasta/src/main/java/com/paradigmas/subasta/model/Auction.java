package com.paradigmas.subasta.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Auction {
    @Id
    private String id;
    private Date initialDate;
    private Date finalDate;
    private String serialProduct;
    private String creatorDocument;
    private String buyerDocument;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public String getSerialProduct() {
        return serialProduct;
    }

    public void setSerialProduct(String serialProduct) {
        this.serialProduct = serialProduct;
    }

    public String getCreatorDocument() {
        return creatorDocument;
    }

    public void setCreatorDocument(String string) {
        this.creatorDocument = string;
    }

    public String getBuyerDocument() {
        return buyerDocument;
    }

    public void setBuyerDocument(String string) {
        this.buyerDocument = string;
    }


}
