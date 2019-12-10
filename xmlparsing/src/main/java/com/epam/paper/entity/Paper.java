package com.epam.paper.entity;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlType(name = "Paper", propOrder = {"title", "price"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Newspaper.class, Magazine.class})
public class Paper {
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "owner", required = false)
    protected String owner;
    @XmlElement(name = "title")
    protected String title;
    @XmlElement(name = "price")
    protected int price;

    public Paper() {
    }

    public Paper(String id, String owner, String title, int price) {
        this.id = id;
        this.owner = owner;
        this.title = title;
        this.price = price;
    }

    public void setId(String id) {
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

    public String getId() {
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
        return this.id.equals(paperObj.id) && this.owner.equals(paperObj.owner) &&
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
                "id = " + id +
                ", owner = " + owner +
                ", title = " + title +
                ", price = " + price;
    }


}
