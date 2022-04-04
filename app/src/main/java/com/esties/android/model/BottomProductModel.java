package com.esties.android.model;

public class BottomProductModel {
    private int productImage;

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    private String productName;
    private String productLink;

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    private String productPrice;
    public BottomProductModel(int userImage,String link,String name,String productPrice){

        this.productName =name;
        this.productLink =link;
        this.productImage = userImage;
        this.productPrice = productPrice;
    }
}
