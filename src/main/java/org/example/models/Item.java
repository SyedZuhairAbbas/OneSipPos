package org.example.models;

public class Item {
    int id;
    int categoryId;
    String name;
    String imagePath;
    boolean hasSizes;
    int priceSmall;
    int priceLarge;
    int priceSingle;

    public Item(int id, int priceSingle, int priceLarge, int priceSmall, boolean hasSizes, String imagePath, int categoryId, String name) {
        this.id = id;
        this.priceSingle = priceSingle;
        this.priceLarge = priceLarge;
        this.priceSmall = priceSmall;
        this.hasSizes = hasSizes;
        this.imagePath = imagePath;
        this.categoryId = categoryId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriceSingle() {
        return priceSingle;
    }

    public void setPriceSingle(int priceSingle) {
        this.priceSingle = priceSingle;
    }

    public int getPriceLarge() {
        return priceLarge;
    }

    public void setPriceLarge(int priceLarge) {
        this.priceLarge = priceLarge;
    }

    public int getPriceSmall() {
        return priceSmall;
    }

    public void setPriceSmall(int priceSmall) {
        this.priceSmall = priceSmall;
    }

    public boolean isHasSizes() {
        return hasSizes;
    }

    public void setHasSizes(boolean hasSizes) {
        this.hasSizes = hasSizes;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
