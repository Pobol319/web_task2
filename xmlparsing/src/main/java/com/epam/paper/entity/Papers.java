package com.epam.paper.entity;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "paper"
})
@XmlRootElement(name = "papers")
public class Papers {
    @XmlElementRef(name = "paper", namespace = "http://www.example.com/papers", type = JAXBElement.class)
    protected List<JAXBElement<? extends Paper>> paper;

    public List<JAXBElement<? extends Paper>> getPaper() {
        if (paper == null) {
            paper = new ArrayList<JAXBElement<? extends Paper>>();
        }
        return this.paper;
    }
}