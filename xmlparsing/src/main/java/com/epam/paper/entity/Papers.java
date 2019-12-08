package com.epam.paper.entity;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
/*

@XmlRootElement(name = "papers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Papers {
    @XmlElement(name = "newspaper")
    private List<Paper> papers = new ArrayList<Paper>();

    public List<Paper> getPapers() {
        return papers;
    }

    public void setPapers(List<Paper> papers) {
        this.papers = papers;
    }


}
*/

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "papers")
public class Papers {
    @XmlElementRef(name = "paper", namespace = "http://www.example.com/papers", type = JAXBElement.class)
    protected List<JAXBElement<? extends Paper>> person;

    public List<JAXBElement<? extends Paper>> getPerson() {
        if (person == null) {
            person = new ArrayList<JAXBElement<? extends Paper>>();
        }
        return this.person;
    }
}