package com.epam.paper.parser.dom;

import com.epam.paper.entity.Magazine;
import com.epam.paper.entity.Newspaper;
import com.epam.paper.entity.OutputFrequencyEnum;
import com.epam.paper.entity.Paper;
import com.epam.paper.exceptions.XmlParserException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PapersDomBuilder {
    private List<Paper> papers;
    private DocumentBuilder documentBuilder;
    private static final String NEWSPAPER = "newspaper";
    private static final String MAGAZINE = "magazine";

    public PapersDomBuilder() throws XmlParserException {
        this.papers = new ArrayList<Paper>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new XmlParserException("DOM parsing failure", e);
        }
    }

    public List<Paper> getPapers() {
        return papers;
    }

    public void buildListPapers(String path) throws XmlParserException {
        Document document = null;
        try {
            document = documentBuilder.parse(path);
            Element root = document.getDocumentElement();

            addPaper(root, NEWSPAPER);
            addPaper(root, MAGAZINE);

        } catch (SAXException | IOException e) {
            throw new XmlParserException("DOM parsing failure", e);
        }
    }

    private void addPaper(Element root, String typeOfPaper) {
        NodeList paperList = root.getElementsByTagName(typeOfPaper);
        for (int i = 0; i < paperList.getLength(); i++) {
            Element paperElement = (Element) paperList.item(i);
            Paper paperTemp = null;
            if (typeOfPaper.equals(NEWSPAPER)) {
                paperTemp = buildNewspaper(paperElement);
            }
            if (typeOfPaper.equals(MAGAZINE)) {
                paperTemp = buildMagazine(paperElement);
            }
            papers.add(paperTemp);
        }
    }

    private Paper buildNewspaper(Element paperElement) {
        Newspaper newspaper = new Newspaper();
        setPaperFields(paperElement, newspaper);
        setNewspaperFields(paperElement, newspaper);
        return newspaper;
    }

    private Paper buildMagazine(Element paperElement) {
        Magazine magazine = new Magazine();
        setPaperFields(paperElement, magazine);
        setNewspaperFields(paperElement, magazine);
        setMagazineFields(paperElement, magazine);
        return magazine;
    }

    private void setMagazineFields(Element paperElement, Paper paper) {
        String subject = getElementTextContent(paperElement, "subject");
        ((Magazine) paper).setSubject(subject);
    }

    private void setNewspaperFields(Element paperElement, Paper paper) {
        int subscriptionIndex = Integer.parseInt(getElementTextContent(paperElement, "subscription-index"));
        ((Newspaper) paper).setSubscriptionIndex(subscriptionIndex);
        OutputFrequencyEnum outputFrequencyEnum = OutputFrequencyEnum.valueOf(getElementTextContent(paperElement, "output-frequency").toUpperCase());
        ((Newspaper) paper).setOutputFrequency(outputFrequencyEnum);
    }

    private void setPaperFields(Element paperElement, Paper paper) {
        paper.setId(paperElement.getAttribute("id"));
        paper.setOwner(paperElement.getAttribute("owner"));
        paper.setTitle(getElementTextContent(paperElement, "title"));
        paper.setPrice(Integer.parseInt(getElementTextContent(paperElement, "price")));
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }

}
