package com.epam.paper.parser.jaxb;

import com.epam.paper.entity.Paper;
import com.epam.paper.entity.Papers;
import com.epam.paper.exceptions.XmlParserException;
import com.epam.paper.parser.Parser;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbParser implements Parser {
    private static final String PACKAGE_INFO = "com.epam.paper.entity";

    public List<Paper> parse(String pathToFile) throws XmlParserException {
        JAXBContext jc = null;
        List<Paper> paperList = null;
        try {
            File file = new File(pathToFile);
            jc = JAXBContext.newInstance(PACKAGE_INFO);
            Unmarshaller um = jc.createUnmarshaller();
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            String schemaName = getClass().getClassLoader().getResource("papers.xsd").getPath();
            File schemaLocation = new File(schemaName);
            Schema schema = factory.newSchema(schemaLocation);
            um.setSchema(schema);
            Papers papers = (Papers) um.unmarshal(file);
            paperList = new ArrayList<>();
            for (JAXBElement<? extends Paper> paper : papers.getPaper()) {
                paperList.add(paper.getValue());
            }
        } catch (JAXBException | SAXException e) {
            throw new XmlParserException("JAXB parsing failure", e);
        }
        return paperList;
    }
}
