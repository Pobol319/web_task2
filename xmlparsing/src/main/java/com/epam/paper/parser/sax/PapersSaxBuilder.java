package com.epam.paper.parser.sax;

import com.epam.paper.entity.Paper;

import java.io.IOException;
import java.util.Set;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class PapersSaxBuilder {
    private Set<Paper> papers;
    private PaperHandler paperHandler;
    private XMLReader reader;

    public PapersSaxBuilder() {
        paperHandler = new PaperHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(paperHandler);
        } catch (SAXException e) {

        }
    }

    public Set<Paper> getPapers() {
        return papers;
    }

    public void buildSetPapers(String path) {
        try {
            reader.parse(path);
        } catch (SAXException e) {

        } catch (IOException e) {

        }
        papers = paperHandler.getPapers();
    }
}
