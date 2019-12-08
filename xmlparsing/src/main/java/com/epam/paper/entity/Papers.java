package com.epam.paper.entity;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

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
