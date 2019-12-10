package com.epam.paper.parser.factory;

import com.epam.paper.exceptions.IncorrectTypeException;
import com.epam.paper.parser.Parser;
import com.epam.paper.parser.dom.DomParser;
import com.epam.paper.parser.jaxb.JaxbParser;
import com.epam.paper.parser.sax.SaxParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PapersFactory {
    private static final Logger LOG = LogManager.getLogger(PapersFactory.class);
    private static final String INCORRECT_TYPE_MESSAGE = "Type of parser not a enum";

    private enum TypeParser {
        DOM, SAX, JAXB
    }

    public Parser createParser(String typeParser) throws IncorrectTypeException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                LOG.info("DOM parser created");
                return new DomParser();
            case SAX:
                LOG.info("SAX parser created");
                return new SaxParser();
            case JAXB:
                LOG.info("JAXB parser created");
                return new JaxbParser();
            default:
                throw new IncorrectTypeException(INCORRECT_TYPE_MESSAGE);
        }
    }
}
