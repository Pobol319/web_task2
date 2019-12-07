package com.epam.entity;

public abstract class Paper {
    private int id;
    private String owner;
    private String title;
    private int price;

    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Paper paperObj = (Paper) obj;
        return this.id == paperObj.id && this.owner.equals(paperObj.owner) &&
                this.title.equals(paperObj.owner) && this.price == paperObj.price;
    }

    @Override
    public int hashCode() {
        int result = 0;
        if (owner != null) {
            result += owner.hashCode();
        }
        if (title != null) {
            result += title.hashCode();
        }
        result = 17 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return " \n Papers: " +
                "id = " + id  +
                ", owner = " + owner +
                ", title = " + title +
                ", price = " + price ;
    }


}
