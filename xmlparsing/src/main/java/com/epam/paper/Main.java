package com.epam.paper;


import com.epam.paper.exceptions.IncorrectTypeException;
import com.epam.paper.exceptions.XmlParserException;
import com.epam.paper.parser.Parser;
import com.epam.paper.parser.dom.DomParser;
import com.epam.paper.parser.dom.PapersDomBuilder;
import com.epam.paper.parser.factory.PapersFactory;
import com.epam.paper.parser.jaxb.JaxbParser;
import com.epam.paper.parser.sax.PapersSaxBuilder;
import com.epam.paper.parser.sax.SaxParser;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, IllegalAccessException, XmlParserException, SAXException, IncorrectTypeException {

        String pathXml = "src\\main\\resources\\papersImpl.xml";
        String pathXsd = "src\\main\\resources\\papers.xsd";

        /*DomParser domParser = new DomParser();
        System.out.println(domParser.parse(pathXml));*/

       /* SaxParser saxParser = new SaxParser();
        System.out.println(saxParser.parse(pathXml));*/


      /*  JAXBContext context = JAXBContext.newInstance(Paper.class);

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File(pathXsd));

        Unmarshaller unmarshaller = context.createUnmarshaller();

        unmarshaller.setSchema(schema);
       *//* unmarshaller.setEventHandler(new EmployeeValidationEventHandler());*//*

        Paper employee = (Paper) unmarshaller.unmarshal(new File("person.xml"));
        System.out.println(employee);*/

        /*JaxbParser jaxbParser = new JaxbParser();
        System.out.println(jaxbParser.parse(pathXml));*/

        PapersFactory factory = new PapersFactory();
        Parser parser = factory.createParser("JAXB");
        System.out.println(parser.parse(pathXml));

    }


}

