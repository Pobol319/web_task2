package com.epam.paper.parser.jaxb;

import com.epam.paper.entity.Magazine;
import com.epam.paper.entity.Newspaper;
import com.epam.paper.entity.Paper;
import com.epam.paper.entity.Papers;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
    private final static QName _Paper_QNAME = new QName("http://www.example.com/papers", "paper");
    private final static QName _Newspaper_QNAME = new QName("http://www.example.com/papers", "newspaper");
    private final static QName _Magazine_QNAME = new QName("http://www.example.com/papers", "magazine");

    public ObjectFactory() {
    }

    public Papers createPapers() {
        return new Papers();
    }

    public Newspaper createNewspaper() {
        return new Newspaper();
    }

    public Magazine createMagazine() {
        return new Magazine();
    }

    @XmlElementDecl(namespace = "http://www.example.com/papers", name = "paper")
    public JAXBElement<Paper> createPaper(Paper value) {
        return new JAXBElement<Paper>(_Paper_QNAME, Paper.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.example.com/papers", name = "newspaper", substitutionHeadNamespace = "http://www.example.com/papers", substitutionHeadName = "paper")
    public JAXBElement<Newspaper> createNewspaper(Newspaper value) {
        return new JAXBElement<Newspaper>(_Newspaper_QNAME, Newspaper.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.example.com/students", name = "magazine", substitutionHeadNamespace = "http://www.example.com/papers", substitutionHeadName = "paper")
    public JAXBElement<Magazine> createMagazine(Magazine value) {
        return new JAXBElement<Magazine>(_Magazine_QNAME, Magazine.class, null, value);
    }
}
