package com.epam.paper;

import com.epam.paper.entity.Newspaper;
import com.epam.paper.entity.Paper;
import com.epam.paper.entity.Papers;
import com.epam.paper.parser.dom.PapersDomBuilder;
import com.epam.paper.parser.jaxb.JaxbParser;
import com.epam.paper.parser.sax.PapersSaxBuilder;
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
    public static void main(String[] args) throws JAXBException, IllegalAccessException {

        String pathXml = "src\\main\\resources\\papersImpl.xml";
        String pathXsd = "src\\main\\resources\\papers-schema.xsd";

/*        PapersDomBuilder papersDOMBuilder = new PapersDomBuilder();
        papersDOMBuilder.buildSetPapers(pathXml);
        System.out.println(papersDOMBuilder.getPapers());*/

/*        PapersSaxBuilder papersSAXBuilder = new PapersSaxBuilder();
        papersSAXBuilder.buildSetPapers(pathXml);
        System.out.println(papersSAXBuilder.getPapers());*/

        Papers pap = new Papers();
        JaxbParser parser = new JaxbParser();
        File file = new File(pathXml);
        pap.setPapers(parser.getData("./src/main/resources/papersImpl.xml"));
        System.out.println(pap.getPapers().toString());


    }


}

