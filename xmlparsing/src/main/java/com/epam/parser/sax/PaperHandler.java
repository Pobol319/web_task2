package com.epam.parser.sax;

import com.epam.entity.*;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class PaperHandler extends DefaultHandler {
    private Set<Paper> papers;
    private Paper current = null;
    private PaperEnum currentEnum = null;
    private EnumSet<PaperEnum> withText;

    public PaperHandler() {
        papers = new HashSet<Paper>();
        withText = EnumSet.range(PaperEnum.TITLE, PaperEnum.SUBJECT);
    }

    public Set<Paper> getPapers() {
        return papers;
    }

    public void startElement(String uri, String localName, String qName, Attributes arts) {
        String newspaperValue = PaperEnum.NEWSPAPER.getValue();
        String magazine = PaperEnum.MAGAZINE.getValue();
        if (newspaperValue.equals(localName)) {
            current = new Newspaper();
            current.setId(Integer.parseInt(arts.getValue(0)));
            current.setOwner(arts.getValue(1));
        } else if (magazine.equals(localName)) {
            current = new Magazine();
            current.setId(Integer.parseInt(arts.getValue(0)));
            current.setOwner(arts.getValue(1));
        } else {
            PaperEnum temp = convertIntoPaperEnum(localName);
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        String newspaperValue = PaperEnum.NEWSPAPER.getValue();
        String magazine = PaperEnum.MAGAZINE.getValue();
        if (newspaperValue.equals(localName)) {
            papers.add(current);
        }
        if (magazine.equals(localName)) {
            papers.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum){
                case TITLE:
                    current.setTitle(s);
                    break;
                case PRICE:
                    current.setPrice(Integer.parseInt(s));
                    break;
                case SUBSCRIPTION_INDEX:
                    ((Newspaper)current).setSubscriptionIndex(Integer.parseInt(s));
                    break;
                case OUTPUT_FREQUENCY:
                    ((Newspaper)current).setOutputFrequency(OutputFrequencyEnum.valueOf(s.toUpperCase()));
                    break;
                case SUBJECT:
                    ((Magazine)current).setSubject(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }

    private PaperEnum convertIntoPaperEnum(String localName) {
        PaperEnum[] values = PaperEnum.values();
        for (PaperEnum e : values) {
            if (e.getValue().equals(localName)) {
                return e;
            }
        }
        return null;
    }
}
