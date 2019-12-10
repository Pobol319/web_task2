package com.epam.paper.factorytest;

import com.epam.paper.exceptions.IncorrectTypeParserException;
import com.epam.paper.parser.Parser;
import com.epam.paper.parser.dom.DomParser;
import com.epam.paper.parser.factory.ParserFactory;
import com.epam.paper.parser.jaxb.JaxbParser;
import com.epam.paper.parser.sax.SaxParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParserFactoryTest {

    @Test
    public void testCreateParserDom() throws IncorrectTypeParserException {
        //given
        String nameParser = "DOM";
        ParserFactory factory = new ParserFactory();
        //when
        Parser parser = factory.createParser(nameParser);
        //then
        Assert.assertEquals(parser.getClass(), DomParser.class);
    }

    @Test
    public void testCreateParserSax() throws IncorrectTypeParserException {
        //given
        String nameParser = "SAX";
        ParserFactory factory = new ParserFactory();
        //when
        Parser parser = factory.createParser(nameParser);
        //then
        Assert.assertEquals(parser.getClass(), SaxParser.class);
    }

    @Test
    public void testCreateParserJAXB() throws IncorrectTypeParserException {
        //given
        String nameParser = "JAXB";
        ParserFactory factory = new ParserFactory();
        //when
        Parser parser = factory.createParser(nameParser);
        //then
        Assert.assertEquals(parser.getClass(), JaxbParser.class);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateParserExpectException() throws IncorrectTypeParserException {
        //given
        String nameParser = "NO";
        ParserFactory factory = new ParserFactory();
        //when
        Parser parser = factory.createParser(nameParser);
        //then
        Assert.assertEquals(parser.getClass(), JaxbParser.class);
    }
}
