package com.epam.paper.parser.sax;

import com.epam.paper.entity.Paper;

import java.io.IOException;
import java.util.List;

import com.epam.paper.exceptions.XmlParserException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class PapersSaxBuilder {
    private List<Paper> papers;
    private PaperHandler paperHandler;
    private XMLReader reader;

    public PapersSaxBuilder() throws XmlParserException {
        paperHandler = new PaperHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(paperHandler);
        } catch (SAXException e) {
            throw new XmlParserException("SAX parsing failure",e);
        }
    }

    public List<Paper> getPapers() {
        return papers;
    }

    public void buildSetPapers(String path) throws XmlParserException {
        try {
            reader.parse(path);
        } catch (SAXException | IOException e) {
            throw new XmlParserException("SAX parsing failure",e);
        }
        papers = paperHandler.getPapers();
    }
}
