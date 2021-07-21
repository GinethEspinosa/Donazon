package net.smallacademy.authenticatorapp;

public class Item {
    Integer idItem;
    String nameItem;
    String description;
    String category;
    String imageItem;

    public Item(Integer idItem, String nameItem, String description, String category, String imageItem) {
        this.idItem = idItem;
        this.nameItem = nameItem;
        this.description = description;
        this.category = category;
        this.imageItem = imageItem;
    }

    public Integer getIdItem() {
        return idItem;
    }


    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }


    public String getNameItem() {
        return nameItem;
    }


    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public String getImage() {
        return imageItem;
    }


    public void setImage(String imageItem) {
        this.imageItem = imageItem;
    }
}