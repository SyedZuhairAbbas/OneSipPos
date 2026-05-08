package org.example.models;

public class Category {
    int id;
    String name;
    String iconPath;
    int sortOrder;

    public Category(int id, String name, String iconPath, int sortOrder) {
        this.id = id;
        this.name = name;
        this.iconPath = iconPath;
        this.sortOrder = sortOrder;
    }

    public String getName() {return name;}

    public int getId() {return id;}

    public String getIconPath() {return iconPath;}

    public int getSortOrder() {return sortOrder;}

    public void setName(String name) {this.name = name;}

    public void setId(int id) {this.id = id;}

    public void setIconPath(String iconPath) {this.iconPath = iconPath;}

    public void setSortOrder(int sortOrder) {this.sortOrder = sortOrder;}
}
